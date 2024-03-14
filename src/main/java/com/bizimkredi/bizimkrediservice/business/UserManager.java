package com.bizimkredi.bizimkrediservice.business;

import com.bizimkredi.bizimkrediservice.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class UserManager {
    private static UserManager userManagerInstance;
    private List<User> userList = new ArrayList<>();


    public UserManager() {

    }

    public static synchronized UserManager getInstance() {
        if (userManagerInstance == null)
            userManagerInstance = new UserManager();

        return userManagerInstance;
    }


    /**
     * Gets userName,userSurname,userMail,password,phoneNumber,isActive as paramaters,checks for unique userMail and create intended user.Add intended user to userList.
     * Returns user.
     */
    public User getUser(String userName, String userSurname, String userMail, String password, String phoneNumber, Boolean isActive) {

        // checking for new user exist in our customerList
        for (User user : userList) {
            if (user.getEmail().equals(userMail)) {
                System.out.println("Sayın: " + userName + " " + userSurname + " " + user.getEmail() + " ile Sistemde Kayıt bulunmaktadır lütfen farklı bir Mail deneyiniz.");
                return user;
            }
        }

        User returnUser = new User(userName, userSurname, userMail, password, phoneNumber, true);
        userList.add(returnUser);

        return returnUser;
    }

    public void getUserWithMostApplications() {
        Optional<User> optionalUser = userList.stream().max(Comparator.comparingInt(user -> user.getApplicationList().size()));

        if (optionalUser.isPresent()) {
            System.out.println("\n" + "Max Başvuru yapan kişi:" + optionalUser.get() + "\n" + "Başvuru Sayısı:" + optionalUser.get().getApplicationList().size());
//            return optionalUser.get();
        } else {
            System.out.println("En fazla başvurusu olan kullanıcı bulunamadı.");
//            return null;
        }
    }

    public void getUserWithHighestLoanCost() {
        double totalAmount = 0.0;

        Optional<User> optionalUser = userList.stream().max(Comparator.comparing(user -> user.getApplicationList().stream()
                .filter(application -> application.getProduct() != null).mapToDouble(app -> app.getProduct().getProductAmount().doubleValue()).sum()));

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            totalAmount = user.getApplicationList().stream()
                    .filter(application -> application.getProduct() != null)
                    .mapToDouble(app -> app.getProduct().getProductAmount().doubleValue())
                    .sum();
            System.out.println("\n" + "En yüksek kredi tutarlı kullanıcı : " + user + "\n" + "Kredi tutarı : " + totalAmount);
//            return optionalUser.get();
        } else {
            System.out.println("En yüksek kredi tutarlı kullanıcı bulunamadı.");
//            return null;
        }
    }

    public void listApplicationsOfLastMonths() {
        System.out.println("\n" + "Sistemdeki son 1 aylık başvurular:" + userList.stream()
                .flatMap(user -> user.getApplicationList().stream())
                .filter(app -> app.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(1))).toList());
    }

    public void listUserApplicationWithMail(String userMail) {

        userList.stream().filter(user -> user.getEmail().equals(userMail)).forEach(user -> user.getApplicationList().forEach(System.out::println));
    }

    public List<User> getUserList() {
        return userList;
    }
}
