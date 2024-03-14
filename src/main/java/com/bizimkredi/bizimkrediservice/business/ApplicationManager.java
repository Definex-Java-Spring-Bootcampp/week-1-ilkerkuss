package com.bizimkredi.bizimkrediservice.business;

import com.bizimkredi.bizimkrediservice.model.User;
import com.bizimkredi.bizimkrediservice.model.abstracts.Application;
import com.bizimkredi.bizimkrediservice.model.abstracts.Loan;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    private static ApplicationManager applicationManagerInstance;

    private List<Application> loanApplicationList = new ArrayList<>();
    private List<Application> creditCardApplicationList = new ArrayList<>();

    public ApplicationManager() {

    }

    public static synchronized ApplicationManager getInstance() {
        if (applicationManagerInstance == null)
            applicationManagerInstance = new ApplicationManager();

        return applicationManagerInstance;
    }

//    public Application getApplication(Product product, User user, LocalDateTime localDateTime) {
//       if(product.getClass().getSimpleName().equals("Loan")){
//
//           Application returnLoanApplication = new Application();
//       }
//        loanApplicationList.add(returnLoanApplication);
//
//        return returnLoanApplication;
//    }
}
