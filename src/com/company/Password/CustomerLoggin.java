package com.company.Password;

import com.company.Menus.ClientMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerLoggin {

    /** This is where the Customer Loggin are created and verified **/

    private static String userName;
    private static String password;
    AllCustomerLoggin myCustomerLoggin = new AllCustomerLoggin();

    public CustomerLoggin() {

    }

    /** This constructor is used to create a new object Customer Loggin
     * with two attributes  username and a password **/

    public CustomerLoggin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }


    /** This method will asked the user if he has an account or not, verify if the username exists and
     * if it corresponds to the password
     * If the user doesn't have an account, a new object CustomerLoggin is created and added to the
     * AllCustomerLoggin ArrayList (of CustomerLoggin),
     * Once it's created, we can verify is the userName input corresponds to a name in the array list
     * (so if the user name exists) and if the password input corresponds to the one placed in the array
     * If both methods are verified, then the client will access to the client menu **/

    public void createAccount() {
        boolean isCreated = true;

        while (isCreated) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------- LOGGIN --------");
            System.out.println("Do you have an account ? Type yes or no");
            String result = scanner.next();
            if (result.equalsIgnoreCase("yes")) {
                isCreated = false;
                System.out.println("-------- ENTER YOUR ACCOUNT INFORMATION --------");
                System.out.println("Username :");
                String userNameInput = scanner.next();
                System.out.println("Password :");
                String userPasswordInput = scanner.next();

                boolean isWrong = verifyPassword(userPasswordInput.trim(), myCustomerLoggin.getListOfLoggin());
                boolean isExist = verifyUserName(userNameInput.trim(), myCustomerLoggin.getListOfLoggin());
                if (isWrong || !isExist) {
                    System.out.println("Sorry your user name or your password is not correct\n");
                    isCreated = true;
                } else {

                    new ClientMenu();

                }

            } else if (result.equalsIgnoreCase("no")) {
                System.out.println("-------- CREATE A NEW ACCOUNT --------");
                System.out.println("Username :");
                String userNameInput = scanner.next();
                System.out.println("Password :");
                String userPasswordInput = scanner.next();
                boolean isExist = verifyUserName(userNameInput.trim(), myCustomerLoggin.getListOfLoggin());
                if (isExist) {
                    System.out.println("Sorry this username already exist");
                } else {
                    CustomerLoggin customerLoggin = new CustomerLoggin(userNameInput, userPasswordInput);
                    myCustomerLoggin.getListOfLoggin().add(customerLoggin);
                }
            } else {
                System.out.println("Sorry we didn't get your answer, try again !\n");
            }
        }

    }


    /** This method is a boolean that is verifying if the username doesn't already exist
     * in the ArrayList.
     * This will be used in the createAccount() method to compare the userName input
     * and the ones already created, if it's the same, isAlready is set to true **/

    private boolean verifyUserName(String myUserName, ArrayList<CustomerLoggin> listOfLoggin) {
        boolean isAlredyExist = false;
        for (int i = 0; i < listOfLoggin.size(); i++) {
            CustomerLoggin userNameToVerify = listOfLoggin.get(i);
            if (userNameToVerify.getUserName().trim().equalsIgnoreCase(myUserName.trim())) {
                isAlredyExist = true;
                return isAlredyExist;
            }

        }
        return isAlredyExist;
    }

    /** This method is a boolean that is verifying if the password corresponds
     * to the password user input.
     * This will be used in the createAccount() method to compare the password input
     * and the one stocked in the AllCustomerLoggin ArrayList, if it's the same, is wrong is set to false **/

    private boolean verifyPassword(String myPassword, ArrayList<CustomerLoggin> listOfLoggin) {
        boolean isWrong = true;
        for (int i = 0; i < listOfLoggin.size(); i++) {
            CustomerLoggin passwordToVerify = listOfLoggin.get(i);
            if (passwordToVerify.getPassword().trim().equalsIgnoreCase(myPassword.trim())) {
                isWrong = false;
                return isWrong;
            }

        }
        return isWrong;
    }


}



