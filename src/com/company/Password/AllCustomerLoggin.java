package com.company.Password;

import java.util.ArrayList;
import java.util.HashMap;

public class AllCustomerLoggin {


    /** This class is used to stock all the customer loggins **/

    private ArrayList<CustomerLoggin> listOfLoggin = null;

    /** Constructor method of the object CustomerLoggin,
     * Here we don't want an argument, we are only instantiating an empty ArrayList
     * It will be fill when the user will run the app and create his CustomerLoggin **/

    public AllCustomerLoggin() {
        listOfLoggin = new ArrayList<>();
    }

    /** Getter method that will allow us to modify and add CustommerLoggin
     * @return          => ArrayList of CustomerLoggin **/

    public ArrayList<CustomerLoggin> getListOfLoggin() {
        return listOfLoggin;
    }

}
