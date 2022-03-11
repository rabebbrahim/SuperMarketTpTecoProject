package com.company.Objects;

import java.util.Scanner;

public class Product {


    /** This class will create a new object Product
     * its attributes will be his name, price and quantity **/

    public static ListProducts myProductList = new ListProducts();
    private String name;
    private float price;
    private int quantity;


    public Product(String myName, float myPrice, int myQuantity) {
        this.name = myName;
        this.price = myPrice;
        this.quantity = myQuantity;

    }


    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    /** This method is used by the administrator to add products into the product list
     * The user will enter a name, price and quantity he wants to add and then he will be asked
     * if he wants to continue adding products or quit adding products **/

    public static ListProducts addProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean isInProgress = true;

        Product myProduct;

        while (isInProgress) {

            System.out.println("-------- NEW PRODUCT --------");
            System.out.println("Enter product name");
            String nameProductInput = scanner.next();
            System.out.println("Enter product price");
            float priceProductInput = scanner.nextFloat();
            System.out.println("Enter product quantity");
            int quantityProductInput = scanner.nextInt();


            String[] productTab = {nameProductInput, String.valueOf(priceProductInput), String.valueOf(quantityProductInput)};
            System.out.println("Enter the word quit to quit adding products get back at the menu, " +
                    "else type continue to add a new product and continue");
            String resultInput = scanner.next();

            if (resultInput.equalsIgnoreCase("quit")) {
                isInProgress = false;
                myProduct = new Product(productTab[0], Float.parseFloat(productTab[1]), Integer.parseInt(productTab[2]));
                myProductList.getListOfProducts().add(myProduct);
            } else if (resultInput.equalsIgnoreCase("continue")) {
                myProduct = new Product(productTab[0], Float.parseFloat(productTab[1]), Integer.parseInt(productTab[2]));
                myProductList.getListOfProducts().add(myProduct);
            } else {
                System.out.println("Your user input is not correct, please try again");
                isInProgress = false;

            }


        }
        return myProductList;

    }


    /** This method is used to print all the products added in the the previous method
     * addProduct(), if the list size equals 0, it mean no products were added by the
     * user so "There's no product stored in the supermarket" will be printed. Else,
     * it will print all the products added **/
    public static void printAllProducts() {
        if (myProductList.getListOfProducts().size() == 0) {
            System.out.println("There's no product stored in the supermarket");
        } else {
            System.out.println("-------- PRODUCT LIST --------");
            for (int i = 0; i < myProductList.getListOfProducts().size(); i++) {
                System.out.println((i + 1) + ") NAME : " + myProductList.getListOfProducts().get(i).getName() + ", PRICE : " + myProductList.getListOfProducts().get(i).getPrice()
                        + "€, QUANTITY : "+ myProductList.getListOfProducts().get(i).getQuantity());

            }
        }
    }

}








