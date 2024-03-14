package com.bizimkredi.bizimkrediservice.model.concretes;





import com.bizimkredi.bizimkrediservice.enums.LoanType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.abstracts.Loan;

import java.math.BigDecimal;

public class HouseLoan extends Loan {

    private LoanType loanType = LoanType.KONUT_KREDISI;

    public HouseLoan() {

    }

    public HouseLoan(BigDecimal amount, Integer installment, Double interestRate, Bank bank) {
        super(amount, installment, interestRate,bank);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    public void calculate(BigDecimal amount, int installment) {

    }
}
