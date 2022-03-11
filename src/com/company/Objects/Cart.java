package com.company.Objects;

import com.company.CustomerOrder.AllCustomerOrder;
import com.company.CustomerOrder.Order;
import com.company.Password.CustomerLoggin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cart {

    /**
     * This class is used to do everything related to the Client Cart
     **/

    public static Scanner scanner = new Scanner(System.in);
    public static boolean quit = false;

    public Cart() {
    }


    /**
     * This method is used to add some products to the cart
     * It will ask the user which product he wants :
     * If is entry = 0 or doesn't correspond to one of the products number, he will be
     * out of the while loop (isAdded will be set false)
     * If it corresponds to one of the the product number it will be selected and printed
     * Then the user will be asked which quantity of product he wants, if it's bigger than what's in the
     * the product list (store), it's telling the user that the quantity he asked is not in store
     * else, he'll be allowed to add it into his cart
     *
     * @return => a sublist of Products (sublist of the listproducts)
     **/

    public static ArrayList<Product> addToTheCart() {

        Scanner scanner = new Scanner(System.in);
        boolean isAdded = true;
        while (isAdded) {
            System.out.println("Enter your product index or 0 to return : ");
            int productIndex = scanner.nextInt() - 1;

            if (productIndex == -1 || productIndex >= Product.myProductList.getListOfProducts().size()) {
                isAdded = false;
               if (productIndex >= Product.myProductList.getListOfProducts().size()) {
                   System.out.println("Your product index doesn't exist, try again");
               }

            } else {
                System.out.println(((productIndex) + 1) + ") NAME : " + Product.myProductList.getListOfProducts().get(productIndex).getName()
                        + ", PRICE : " + Product.myProductList.getListOfProducts().get(productIndex).getPrice()
                        + "€, QUANTITY : " + Product.myProductList.getListOfProducts().get(productIndex).getQuantity());

                System.out.println("How many products do you want ?");
                int quantityBought = scanner.nextInt();
                if (quantityBought < ListProducts.getListOfProducts().get(productIndex).getQuantity()) {
                    Product myNewProduct = new Product(ListProducts.getListOfProducts().get(productIndex).getName(),
                            ListProducts.getListOfProducts().get(productIndex).getPrice(), quantityBought);
                    ListProducts.getSubList().add(myNewProduct);
                    System.out.println("Product : " + ListProducts.getListOfProducts().get(productIndex).getName() + " added in the cart, quantity added in the cart : " + quantityBought);
                } else {
                    System.out.println("The quantity you're asking is not available in stock ! Try again");
                    isAdded = false;
                }
            }
        }
        return ListProducts.getSubList();


    }


    /**
     * This method is used to print all the products in the cart, so it's printing all the products
     * selected by the user and added into the sublist
     **/

    public static void printMyCart() {
        if (ListProducts.getSubList().size() == 0) {
            System.out.println("\nThere's no product in your cart");
        } else {
            System.out.println("\n-------- YOUR CART LIST --------");
            for (int i = 0; i < ListProducts.getSubList().size(); i++) {
                System.out.println("NAME : " + ListProducts.getSubList().get(i).getName() + ", PRICE : " + ListProducts.getSubList().get(i).getPrice()
                        + "€, QUANTITY BOUGHT : " + ListProducts.getSubList().get(i).getQuantity());
            }

        }

    }


    /**
     * This methode calculates and printout the total price of the cart
     * It calculates the sum for each i of the quantity x price
     **/

    public static float totalPrice() {
        float totalPrice = 0;
        System.out.println("\n-------- YOUR TOTAL PRICE --------");
        for (int i = 0; i < ListProducts.getSubList().size(); i++) {
            totalPrice += ListProducts.getSubList().get(i).getQuantity() * ListProducts.getSubList().get(i).getPrice();
        }
        System.out.println("Total : " + totalPrice + "€");
        return totalPrice;

    }


    /**
     * When the client is asked if he wants to validate the cart, if the answer is buy the cart
     * (in the method user entry just above) then this method will set the quantity in stock (so the quantity
     * in the listOfProducts) = it will substrack the quantity in stock - the quantity bought by the client
     **/

    public static void validateCart() {
        ArrayList<Product> cartContent = ListProducts.getSubList();
        ArrayList<Product> stock = ListProducts.getListOfProducts();
        for (int i = 0; i < cartContent.size(); i++) {
            for (int j = 0; j < stock.size(); j++) {
                if (stock.get(j).getName() == cartContent.get(i).getName()) {
                    stock.get(j).setQuantity(stock.get(j).getQuantity() - cartContent.get(i).getQuantity());
                }
            }
        }
    }

    public static void addOrder(){
        CustomerLoggin client = new CustomerLoggin(CustomerLoggin.getUserName(), CustomerLoggin.getPassword());
        for (int i = 0; i < ListProducts.getSubList().size(); i++) {
            Order saveOrder = new Order(client, (int)Math.random(), ListProducts.getSubList(), Cart.totalPrice());
            AllCustomerOrder.getOrdersList().add(saveOrder);
        }
    }



    /**
     * This method is running the methods myMenu and userEntry until the user decides to quit the program
     * quit is a boolean set as false at first
     * The loop will stop if it gets a right choice from the user(one of the being decing to return
     * case 2 from user entry sets boolean as true
     **/

    public static void myMenuLoop() {
        do {
            printOutBuyMyCart();
            userEntry();
        } while (!quit);
    }

    /**
     * This method is used to print what's on the menu
     **/

    public static void printOutBuyMyCart() {
        System.out.println("\nWhat do you want to do ?");
        System.out.println("1) Buy cart");
        System.out.println("2) Return");


    }


    /**
     * This method is constructed as a switch case with the options listed in myMenu()
     * To get the user entry, a scanner called userChoice is declared
     * If the user doesn't enter one of the number option listed "Invalid choice, please select one of
     * the options above" will be printed
     * If the user enters something else than an integer an exception will be caught and "Your user
     * input is not correct, please try again" will be printed
     **/

    private static void userEntry(){

        try {
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    Cart.validateCart(); // Buy cart => if 1 is selected the user will be sent to this
                    // it this case that will set the quantity is selected
                    System.out.println("Ok, your cart have been processed, you'll receive your order soon");

                    break;
                case 2:
                    quit = true; // Return => The user get back to the client menu
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




