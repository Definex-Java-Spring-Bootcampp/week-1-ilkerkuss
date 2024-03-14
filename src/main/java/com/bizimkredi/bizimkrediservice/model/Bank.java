package com.bizimkredi.bizimkrediservice.model;

import com.bizimkredi.bizimkrediservice.model.abstracts.CreditCard;
import com.bizimkredi.bizimkrediservice.model.abstracts.Loan;

import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return '\n' + "Bank{" + '\n' +
                "bankName='" + name + '\n' +
//                ", loanList=" + loanList +
                '}';
    }
}
