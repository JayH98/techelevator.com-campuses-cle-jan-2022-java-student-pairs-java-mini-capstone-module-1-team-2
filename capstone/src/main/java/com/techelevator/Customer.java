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
       if (itemsCustomerHas.get(location) == null) {
           itemsCustomerHas.put(location, 0);
       }
        Integer number = itemsCustomerHas.get(location);
        number ++;
        itemsCustomerHas.put(location, number);
    }

    public Integer getItemQuantity (String location) {
      return itemsCustomerHas.get(location);
    }
    public void setInitialItems (String location) {
        itemsCustomerHas.put(location, 0);
    }

}
