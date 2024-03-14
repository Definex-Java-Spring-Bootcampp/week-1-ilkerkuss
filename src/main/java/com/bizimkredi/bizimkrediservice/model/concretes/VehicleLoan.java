package com.bizimkredi.bizimkrediservice.model.concretes;



import com.bizimkredi.bizimkrediservice.enums.LoanType;
import com.bizimkredi.bizimkrediservice.enums.VehicleStatusType;
import com.bizimkredi.bizimkrediservice.model.Bank;
import com.bizimkredi.bizimkrediservice.model.abstracts.Loan;

import java.math.BigDecimal;

public class VehicleLoan extends Loan {

    private LoanType loanType = LoanType.ARAC_KREDISI;
    private VehicleStatusType vehicleStatusType;

    public VehicleLoan() {

    }

    public VehicleLoan(BigDecimal amount, Integer installment, Double interestRate, Bank bank) {
        super(amount, installment, interestRate,bank);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    public void calculate(BigDecimal amount, int installment) {
        //istediği kadar ödeme yapabilir.
    }
}
