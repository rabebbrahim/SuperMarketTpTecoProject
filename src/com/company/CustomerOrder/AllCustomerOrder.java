package com.company.CustomerOrder;

import com.company.Objects.Cart;
import com.company.Objects.ListProducts;
import com.company.Objects.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class AllCustomerOrder {


    /**
     * Test class still in process - created to save all customer orders into in ArrayList of Orders
     **/

    private static ArrayList<Order> ordersList = null;


    public AllCustomerOrder() {
        ordersList = new ArrayList<>();
    }


    public static ArrayList<Order> getOrdersList() {
        return ordersList;
    }


    public static void printOrdersList() {

        System.out.println("\n-------- Your orders list content --------");
        for (int i = 0; i < ordersList.size(); i++) {
            System.out.println("Order's reference : " + ordersList.get(i).getOrderReference() + ", Total PRICE : " + ordersList.get(i).getTotalPrice()
                    + "€, Client's identifier  : " + ordersList.get(i).getCustomerLoggin().getUserName());
        }

    }


}