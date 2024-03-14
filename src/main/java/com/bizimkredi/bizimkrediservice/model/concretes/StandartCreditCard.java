package com.bizimkredi.bizimkrediservice.model.concretes;

import com.bizimkredi.bizimkrediservice.enums.CreditCardType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.Campaign;
import com.bizimkredi.bizimkrediservice.model.abstracts.CreditCard;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;

import java.math.BigDecimal;
import java.util.List;

public class StandartCreditCard extends CreditCard {

    public StandartCreditCard(BigDecimal fee, List<Campaign> campaignList, Bank bank) {
        super(fee, campaignList, bank);
    }

    public StandartCreditCard(BigDecimal fee, List<Campaign> campaignList) {
        super(fee, campaignList);
    }

    @Override
    public CreditCardType getCreditCardType() {
        return CreditCardType.STANDART;
    }
}
