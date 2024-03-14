package com.bizimkredi.bizimkrediservice.model.abstracts;


import com.bizimkredi.bizimkrediservice.enums.ApplicationStatus;
import com.bizimkredi.bizimkrediservice.model.User;
import com.bizimkredi.bizimkrediservice.model.abstracts.Loan;
import com.bizimkredi.bizimkrediservice.model.abstracts.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Application {

    private Loan loan;
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    private Application() {
    }

    /*
    public Application(CreditCard creditCard, User user, LocalDateTime localDateTime) {
        this.creditCard = creditCard;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }*/

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Application(Loan loan, User user, LocalDateTime localDateTime) {
        this.loan = loan;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return '\n' + "Application{" + '\n' +
//                "loan=" + loan +
                "user=" + user.toString() + '\n' +
                "product" + product + '\n' +
                "localDateTime=" + localDateTime.format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss a")) + '\n' +
                "applicationStatus=" + applicationStatus + '\n' +
                '}';
    }
}
