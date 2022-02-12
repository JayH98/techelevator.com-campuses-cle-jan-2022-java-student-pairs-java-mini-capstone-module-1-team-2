package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    /*
    Handle inputs & outputs (print statements)
    choosing item
    receive items
    "Finish Transaction" - in READ ME notes
     */

    private Map<String, Integer> itemsCustomerHas = new HashMap();

    public Customer(){}

    public void setItemsCustomerHas(String location) {      // Getting location, taking out the item and incrementing number
        Integer number = itemsCustomerHas.get(location);
        number ++;
        itemsCustomerHas.put(location, number);
    }
}
