package com.company.Menus;


import com.company.Password.AdminLoggin;
import com.company.Password.CustomerLoggin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Management {

    /** This class is the main menu, it's the first thing that is printed when the program is run **/

    public static Scanner scanner = new Scanner(System.in);
    public static boolean quit = false;


    /** This method corresponds to what is called when a new Management is created in the "Main class" **/

    public Management() {
        myMenuLoop();
    }

    /** This method is running the methods myMenu and userEntry until the user decides to quit the program
     * quit is a boolean set as false at first
     * The loop will stop if it gets a right choice from the user(one of the being decing to quit
     * case 3 from user entry sets boolean as true **/

    private static void myMenuLoop(){
        do {
            myMenu();
            userEntry();
        } while (!quit);
    }


    /** This method is used to print what's on the menu **/

    public static void myMenu() {
        System.out.println("\n \n\uD83E\uDD51 WELCOME TO OUR SUPERMARKET \uD83E\uDD5D\uD83C\uDF52\uD83D\uDED2");
        System.out.println("\nWhat do you want to do ?\n");
        System.out.println("1) Log in as a client");
        System.out.println("2) Log in as an administrator");
        System.out.println("3) Exit");
    }

    /** This method is constructed as a switch case with the options listed in myMenu()
     *  To get the user entry, a scanner called userChoice is declared
     *  If the user doesn't enter one of the number option listed "Invalid choice, please select one of
     *  the options above" will be printed
     *  If the user enters something else than an integer an exception will be caught and "Your user
     *  input is not correct, please try again" will be printed **/

    private static void userEntry() {
        try {
            int userChoice = scanner.nextInt();
            // Swich case for user choice
            switch (userChoice) {
                case 1:
                    // Customer Loggin => if 1 is selected the user will be sent to this
                    CustomerLoggin customerLoggin = new CustomerLoggin();
                    customerLoggin.createAccount();
                    break;
                case 2:
                    // Admin Loggin => if 2 is selected the user will be sent to this
                    AdminLoggin.createAccountAdmin();
                    break;
                case 3:
                    // Quit => The user decides to quit the program
                    quit = true;
                    break;
                default: // Wrong entry, the loop will run again
                    System.out.println("Invalid choice, please select one of the options above");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Your user input is not correct, please try again");
            scanner.nextLine();
        }
    }

}
