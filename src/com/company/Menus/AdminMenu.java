package com.company.Menus;

import com.company.CustomerOrder.AllCustomerOrder;
import com.company.CustomerOrder.Order;
import com.company.Objects.Product;
import com.company.Password.CustomerLoggin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {

    /** When the administrator succeed to enter the right AdminLoggins, this menu is printed **/

    private static Scanner scanner = new Scanner(System.in);
    private static boolean quit = false;


    public AdminMenu() {
        myMenuLoop();
    }

    /** This method is running the methods myMenu and userEntry until the user decides to quit the program
     * quit is a boolean set as false at first
     * The loop will stop if it gets a right choice from the user(one of the being decing to quit
     * case 4 from user entry sets boolean as true **/

    private static void myMenuLoop() {
        do {
            myAdminMenu();
            userEntry();
        } while (!quit);
    }

    /** This method is used to print what's on the menu **/

    private static void myAdminMenu() {
        System.out.println("\n \n What do you want to do ? \n");
        System.out.println("1) List products");
        System.out.println("2) Add a product");
        System.out.println("3) All customer order");
        System.out.println("4) Return");
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
            // Switch case for user choice
            switch (userChoice) {
                case 1:
                    Product.printAllProducts(); // Print All The Products => if 1 is selected the user will be sent to this
                    new AdminMenu();
                    break;
                case 2:
                    Product.addProduct(); // Add a Product to the Product List => if 2 is selected the user will be sent to this
                    break;
                case 3:
                    // All Customer Order (Story 5)
                    if (AllCustomerOrder.getOrdersList() == null){
                        System.out.println("\nThere's no orders in your list");
                    } else {
                    AllCustomerOrder.printOrdersList(); }
                    new AdminMenu();
                case 4 :
                    quit = true; // Return => The user get back to the main menu (Management)
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
