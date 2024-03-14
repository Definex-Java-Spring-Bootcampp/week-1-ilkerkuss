package com.bizimkredi.bizimkrediservice.business;

import com.bizimkredi.bizimkrediservice.enums.CreditCardType;
import com.bizimkredi.bizimkrediservice.enums.LoanType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.Campaign;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;
import com.bizimkredi.bizimkrediservice.model.concretes.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductFactory {
    public Product createLoanProduct(LoanType loanType , BigDecimal loanAmount, Integer loanInstallment, Double loanInterestRate, Bank loanBank) {
        switch (loanType) {
            case IHTIYAC_KREDISI: {
                return new ConsumerLoan(loanAmount,loanInstallment,loanInterestRate,loanBank);
            }
            case KONUT_KREDISI: {
                return new HouseLoan(loanAmount,loanInstallment,loanInterestRate,loanBank);
            }
            case ARAC_KREDISI:{
                return new VehicleLoan(loanAmount,loanInstallment,loanInterestRate,loanBank);
            }
            default:
                throw new IllegalArgumentException(loanType +" Not Found!");
        }
    }


    public Product createCreditCardProduct(CreditCardType creditCardType, BigDecimal feeAmount, List<Campaign> campaignList, Bank bank ) {
        switch (creditCardType) {
            case STANDART: {
                return new StandartCreditCard(feeAmount,campaignList,bank);
            }
            case GOLD: {
                return new GoldCreditCard(feeAmount,campaignList,bank);
            }
            case PLATINIUM:{
                return new PlatiniumCreditCard(feeAmount,campaignList,bank);
            }
            default:
                throw new IllegalArgumentException(creditCardType +" Not Found!");
        }
    }

}
