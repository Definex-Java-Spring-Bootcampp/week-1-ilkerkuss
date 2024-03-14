package com.bizimkredi.bizimkrediservice.model.concretes;



import com.bizimkredi.bizimkrediservice.enums.LoanType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.abstracts.Loan;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions;

    public ConsumerLoan() {

    }

    public ConsumerLoan(BigDecimal amount, Integer installment, Double interestRate, Bank bank) {
        super(amount, installment, interestRate,bank);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    public void calculate(BigDecimal amount, int installment) {
        //tc bul, maaşı bul
    }


}
