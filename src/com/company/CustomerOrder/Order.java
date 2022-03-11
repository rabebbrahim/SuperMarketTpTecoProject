package com.company.CustomerOrder;

import com.company.Objects.Product;
import com.company.Password.CustomerLoggin;

import java.util.ArrayList;

public class Order {

    /** Test class still in process - Creating of an object Order (to print orders details) **/

    private CustomerLoggin customerLoggin;
    private int orderReference;
    private ArrayList<Product> orderdCart;
    private float totalPrice;


    public Order(CustomerLoggin myCustomerLoggin, int myOrderReference, ArrayList<Product> myOrderdCart, Float myTotalPrice) {
        this.customerLoggin = myCustomerLoggin;
        this.orderReference = myOrderReference;
        this.totalPrice = myTotalPrice;
        this.orderdCart = myOrderdCart;
    }



    public CustomerLoggin getCustomerLoggin() {
        return customerLoggin;
    }

    public int getOrderReference() {
        return orderReference;
    }

    public ArrayList<Product> getOrderdCart() {
        return orderdCart;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public static void printMyOrder(Order orderToPrint) {
        System.out.println("\n-------- Your order's details --------");
        System.out.println("\n Order reference : " + orderToPrint.orderReference);
        System.out.println("\n Order's total price : " + orderToPrint.orderReference);
        System.out.println("\n Order's maker : " + orderToPrint.customerLoggin.getUserName());
        for (int i = 0; i < orderToPrint.getOrderdCart().size(); i++) {
            System.out.println("NAME : " + orderToPrint.getOrderdCart().get(i).getName() + ", PRICE : "
                    + orderToPrint.getOrderdCart().get(i).getPrice()
                    + "€, QUANTITY BOUGHT : " + orderToPrint.getOrderdCart().get(i).getQuantity());
        }
    }


}
