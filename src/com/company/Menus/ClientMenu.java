package com.company.Menus;

import com.company.Objects.Cart;
import com.company.Objects.ListProducts;
import com.company.Objects.Product;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ClientMenu {

    /** When the client succeed to enter the right AdminLoggins, this menu is printed **/

    public static Scanner scanner = new Scanner(System.in);
    public static boolean quit = false;

    public ClientMenu() {
        myMenuLoop();
    }

    /** This method is running the methods myMenu and userEntry until the user decides to quit the program
     * quit is a boolean set as false at first
     * The loop will stop if it gets a right choice from the user(one of the being decing to quit
     * case 4 from user entry sets boolean as true **/

    private static void myMenuLoop() {
        do {
            myClientMenu();
            userEntry();
        } while (!quit);
    }

    /** This method is used to print what's on the menu **/

    private static void myClientMenu() {
        System.out.println("\n \nWhat do you want to do ? \n");
        System.out.println("1) List products");
        System.out.println("2) My cart");
        System.out.println("3) Logout");
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

            switch (userChoice) {
                case 1:
                    Product.printAllProducts(); // Print All The Products => if 1 is selected the user will be sent to this
                    if (ListProducts.getListOfProducts().size() != 0) {
                        Cart.addToTheCart();
                    }
                    /** If there's something in the product list, then the user will be allowed to add something to his cart
                    else the method addToTheCart() is not executed**/
                    new ClientMenu();
                    break;
                case 2: // Print The Cart => if 2 is selected the user will be sent to this
                    if (ListProducts.getSubList() == null || ListProducts.getListOfProducts() == null){
                        System.out.println("\nYour cart is empty");
                    } else {
                        Cart.printMyCart();
                        Cart.totalPrice();
                        Cart.myMenuLoop();
                    }
                    /**If there is nothing in the product list or in the cart, it will simply print out "Your cart is empty"
                    But if the client added somethings to his cart, the cart will be printed with it's total price
                    And he will be asked if he wants to buy his articles**/
                    break;
                case 3:
                    quit = true; // Return => The user get back to the main menu (Management)
                    break;
                default:
                    System.out.println("Invalid choice, please select one of the options above");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Your user input is not correct, please try again");
            scanner.nextLine();

        }

    }
}
