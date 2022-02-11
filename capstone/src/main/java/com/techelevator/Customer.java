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

    private List<String> itemsCustomerHas = new ArrayList<>();
    private double money;

    public Customer (List<String> itemsCustomerHas, double money){
        this.itemsCustomerHas = itemsCustomerHas;
        this.money = money;
    }

    public List<String> getItemsCustomerHas() {
        return itemsCustomerHas;
    }

    public void setItemsCustomerHas(List<String> itemsCustomerHas) {
        this.itemsCustomerHas = itemsCustomerHas;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
