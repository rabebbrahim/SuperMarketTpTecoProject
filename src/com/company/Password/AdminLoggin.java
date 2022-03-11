package com.company.Password;

import com.company.Menus.AdminMenu;

import java.util.Scanner;

public class AdminLoggin {

    /** This is where the Admin Loggin are created and verified **/

    private String userNameAdmin;
    private String passwordAdmin;


    /** This constructor is used to create a new object Admin Loggin
     * with two attributes  username and a password **/

    public AdminLoggin(String myUserNameAdmin, String myPasswordAdmin) {
        this.userNameAdmin = myUserNameAdmin;
        this.passwordAdmin = myPasswordAdmin;
    }

    public String getUserNameAdmin() {
        return userNameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }


    /** This method will asked the user Admin to enter a predefined username and password
     * and verify if his inputs are correct, if not he'll have to try again and he does he'll
     * access to the admin menu
     * If his password or his username is not correct the access will be denied **/

    public static void createAccountAdmin() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- ENTER YOUR ACCOUNT INFORMATION --------");
        System.out.println("Username :");
        String userNameInput = scanner.next();
        System.out.println("Password :");
        String userPasswordInput = scanner.next();

        boolean isPasswordWrong = verifyPassword(userPasswordInput.trim());
        boolean isUserNameWrong = verifyUserName(userNameInput.trim());
            if (isPasswordWrong || isUserNameWrong) {
                System.out.println("Sorry your user name or your password is not correct\n");
            } else {

                new AdminMenu();


        }

    }


    /** This method is a boolean that is verifying if the username corresponds
     * to a predefined username, here we chose "admin" as his username
     * This will be used in the createAccount() method to compare the userName input
     * and "admin", if it's the same, is wrong is set to false **/

    private static boolean verifyUserName(String userName) {
        boolean isWrong = true;
        if (userName.trim().equalsIgnoreCase("admin")) {
            isWrong = false;
        }
        return isWrong;
    }

    /** This method is a boolean that is verifying if the password corresponds
     * to a predefined password, here we chose "admin" as his password
     * This will be used in the createAccount() method to compare the user Password input
     * and "admin", if it's the same, is wrong is set to false **/

    private static boolean verifyPassword(String password) {
        boolean isWrong = true;
        if (password.trim().equalsIgnoreCase("admin")) {
            isWrong = false;
        }
        return isWrong;

    }


}