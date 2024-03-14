package com.bizimkredi.bizimkrediservice.model.abstracts;

import com.bizimkredi.bizimkrediservice.enums.CreditCardType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.Campaign;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;

import java.math.BigDecimal;
import java.util.List;

public abstract class CreditCard implements Product {

    private BigDecimal fee;
    private List<Campaign> campaignList;
    private Bank bank;

    private CreditCardType creditCardType;

    public CreditCard(BigDecimal fee, List<Campaign> campaignList, Bank bank) {
        this.fee = fee;
        this.campaignList = campaignList;
        this.bank = bank;
    }

    public CreditCard(BigDecimal fee, List<Campaign> campaignList) {
        this.fee = fee;
        this.campaignList = campaignList;
    }

    public abstract CreditCardType getCreditCardType();


    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }



    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + campaignList +
                ", bank=" + bank +
                '}';
    }

    @Override
    public BigDecimal getProductAmount() {
        return getFee();
    }
}
