package com.company.Objects;


import java.util.ArrayList;
import java.util.Scanner;

public class ListProducts {


    /** This class is used to stock all the ArrayLists of Products **/

    private static ArrayList<Product> listOfProducts = null;
    private static ArrayList<Product> subList = null;

    /** Constructor method of the object ListProducts,
     * Here we don't want an argument, we are only instantiating empty ArrayLists
     * listOfProducts => It will be filled when the administrator will run the app and create new Products to add
     * subList => It will be filled when the customer will run the app and create a Cart with all the products
     * he selected from the list of products **/

    public ListProducts() {
        listOfProducts = new ArrayList<>();
        subList = new ArrayList<>();
    }


    /** Getter method that will allow us to modify and add Product
     * @return          => ArrayList of Products **/

    public static ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public static ArrayList<Product> getSubList() {
        return subList;
    }



}



