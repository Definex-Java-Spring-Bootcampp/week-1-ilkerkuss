package com.bizimkredi.bizimkrediservice.model;


import com.bizimkredi.bizimkrediservice.business.ProductManager;
import com.bizimkredi.bizimkrediservice.business.UserManager;
import com.bizimkredi.bizimkrediservice.enums.CreditCardType;
import com.bizimkredi.bizimkrediservice.enums.LoanType;
import com.bizimkredi.bizimkrediservice.enums.SectorType;
import com.bizimkredi.bizimkrediservice.model.abstracts.Application;
import com.bizimkredi.bizimkrediservice.model.abstracts.CreditCard;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;
import com.bizimkredi.bizimkrediservice.model.concretes.ConsumerLoan;
import com.bizimkredi.bizimkrediservice.model.concretes.HouseLoan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Object Creation

        User user1 = UserManager.getInstance().getUser("ilker", "kuş", "ilker.kus@hotmail.com", "password", "123456789", true);
        User user2 = UserManager.getInstance().getUser("cem", "dirman", "cemdrman@gmail.com", "password1", "456123789", true);
        User userInvalid = UserManager.getInstance().getUser("ahmet", "kuş", "ilker.kus@hotmail.com", "password2", "745641321", true);

        Bank garantiBank = new Bank("Garanti");
        Bank akBank = new Bank("Akbank");
        Bank finansBank = new Bank("FinansBank");

        List<Campaign> akBankCampaignList = new ArrayList<>();
        List<Campaign> garantiCampaignList = new ArrayList<>();
        List<Campaign> finansCampaignList = new ArrayList<>();

        Campaign campaign1 = new Campaign("Şimdi Axess'li Ol 2.600 TL'ye Varan Chip-para Kazan!", "Axess Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);
        Campaign campaign2 = new Campaign("Ayda 7.000 TL'ye Varan Bonus!", "Garanti Content", LocalDate.of(2024, Month.DECEMBER, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);
        Campaign campaign3 = new Campaign("villareyonu.com'da 1.000 TL Bonus!", "Garanti Content", LocalDate.of(2024, Month.NOVEMBER, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.TRAVELS);
        Campaign campaign4 = new Campaign("2024 Ramazan Bayramı Kampanyası!", "Garanti Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.MARKET);
        Campaign campaign5 = new Campaign("CardFinans GO ile 500 TL ParaPuan!", "Finans Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);
        Campaign campaign6 = new Campaign("Yuvanızı Isıtacak Ücretsiz, Faizsiz 3 Taksit Fırsatı!", "Finans Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);

        akBankCampaignList.add(campaign1);
        garantiCampaignList.add(campaign2);
        garantiCampaignList.add(campaign3);
        garantiCampaignList.add(campaign4);
        finansCampaignList.add(campaign5);
        finansCampaignList.add(campaign6);

        Product houseLoan1 = ProductManager.getInstance().getLoanProduct(LoanType.KONUT_KREDISI, new BigDecimal(100000), 12, 2.75, garantiBank);
        Product consumerLoan1 = ProductManager.getInstance().getLoanProduct(LoanType.IHTIYAC_KREDISI, new BigDecimal(500000), 36, 6.75, akBank);
        Product vehicleLoan1 = ProductManager.getInstance().getLoanProduct(LoanType.ARAC_KREDISI, new BigDecimal(200000), 18, 3.19, finansBank);
        Product consumerLoan2 = ProductManager.getInstance().getLoanProduct(LoanType.IHTIYAC_KREDISI, new BigDecimal(25000), 6, 2.59, akBank);
        Product houseLoan2 = ProductManager.getInstance().getLoanProduct(LoanType.KONUT_KREDISI, new BigDecimal(500000), 36, 2.59, garantiBank);

        Product creditCard1 = ProductManager.getInstance().getCreditCardProduct(CreditCardType.STANDART, new BigDecimal(0), akBankCampaignList, akBank);
        Product creditCard2 = ProductManager.getInstance().getCreditCardProduct(CreditCardType.GOLD, new BigDecimal(100), garantiCampaignList, garantiBank);
        Product creditCard3 = ProductManager.getInstance().getCreditCardProduct(CreditCardType.PLATINIUM, new BigDecimal(200), finansCampaignList, finansBank);


        //Users applies to a product
        user1.appylToProduct(vehicleLoan1);
        user1.appylToProduct(consumerLoan2);
        user1.appylToProduct(houseLoan2);

        System.out.println("--------------");
        user2.appylToProduct(vehicleLoan1);
        user2.appylToProduct(consumerLoan2);


        System.out.println("\n" + "Soru 3 ------------------");
        UserManager.getInstance().getUserWithMostApplications(); //Soru 3

        System.out.println("\n" + "Soru 4 ------------------");
        UserManager.getInstance().getUserWithHighestLoanCost(); // Soru 4

        System.out.println("\n" + "Soru 5 ------------------");
        UserManager.getInstance().listApplicationsOfLastMonths(); //Soru 5

        System.out.println("\n" + "Soru 6 ------------------");
        ProductManager.getInstance().listCreditCardCampaignsDescendingOrder(); // Soru 6

        System.out.println("\n" + "Soru 7 ------------------");
        UserManager.getInstance().listUserApplicationWithMail("cemdrman@gmail.com"); // Soru 7
    }

}
