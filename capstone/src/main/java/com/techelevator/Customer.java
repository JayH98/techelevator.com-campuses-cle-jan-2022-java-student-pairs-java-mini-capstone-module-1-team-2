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


    public Customer() {
    }

    public Map<String, Integer> itemsCustomerHas = new HashMap<>();

    public Map<String, Integer> getItemsCustomerHas() {
        return itemsCustomerHas;
    }

//Getting location, taking out the item and incrementing number
    public void setItemsCustomerHas(String location) {

//TODO figure out why it resets to 5 (already fixed)

        if (itemsCustomerHas.get(location) == null) {
            itemsCustomerHas.put(location, 0);
            Integer number = itemsCustomerHas.get(location);
            number = number + 1;
            itemsCustomerHas.put(location, number);
        }
        else {
            Integer number = itemsCustomerHas.get(location);
            number = number + 1;
            itemsCustomerHas.put(location, number);
        }
    }

    public Integer getItemQuantity(String location) {
        Integer items = itemsCustomerHas.get(location);
        return items;
    }

    public void setInitialItems(String location) {
        itemsCustomerHas.put(location, 0);
    }

}
