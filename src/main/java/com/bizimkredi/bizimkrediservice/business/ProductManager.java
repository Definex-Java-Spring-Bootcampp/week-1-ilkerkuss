package com.bizimkredi.bizimkrediservice.business;

import com.bizimkredi.bizimkrediservice.enums.CreditCardType;
import com.bizimkredi.bizimkrediservice.enums.LoanType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.Campaign;
import com.bizimkredi.bizimkrediservice.model.abstracts.CreditCard;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {

    private static ProductManager productManagerInstance;
    private ProductFactory productFactory = new ProductFactory();
    private List<Product> productLoanList = new ArrayList<>();
    private List<Product> productCreditCardList = new ArrayList<>();


    public ProductManager() {

    }

    public static synchronized ProductManager getInstance() {
        if (productManagerInstance == null)
            productManagerInstance = new ProductManager();

        return productManagerInstance;
    }


    /**
     * Gets ProductName,ProductSurname,ProductMail,password,phoneNumber,isActive as paramaters,checks for unique ProductMail and create intended Product.Add intended Product to productList.
     * Returns Product.
     */
    public Product getLoanProduct(LoanType loanType , BigDecimal loanAmount, Integer loanInstallment, Double loanInterestRate, Bank loanBank) {

        Product loanProduct = productFactory.createLoanProduct(loanType,loanAmount,loanInstallment,loanInterestRate,loanBank);
        productLoanList.add(loanProduct);

        return loanProduct;

    }

    public Product getCreditCardProduct(CreditCardType creditCardType, BigDecimal feeAmount, List<Campaign> campaignList, Bank creditCardBank) {

        Product creditCardProduct = productFactory.createCreditCardProduct(creditCardType,feeAmount,campaignList,creditCardBank);
        productCreditCardList.add(creditCardProduct);

        return creditCardProduct;

    }

    public void listCreditCardCampaignsDescendingOrder(){

        List<Product> sortedCreditCardsList = productCreditCardList.stream().sorted(Comparator.comparingInt(creditCard->((CreditCard)creditCard).getCampaignList().size()).reversed()).toList();
        sortedCreditCardsList.forEach(card-> ((CreditCard)card).getCampaignList().forEach(System.out::println));
    }

    //GETTERS - SETTERS

    public List<Product> getProductLoanList() {
        return productLoanList;
    }

    public List<Product> getProductCreditCardList() {
        return productCreditCardList;
    }
}
