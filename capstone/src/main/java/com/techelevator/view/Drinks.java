package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drinks extends Vendables {

    Map<String, Double> drinks = new HashMap<String, Double>();

    public Drinks(String itemName, double itemPrice, String itemSound) {
        super(itemName, itemPrice, itemSound);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Glug Glug, Yum!");
    }

    public Map<String, Double> getDrinks() {
        return drinks;
    }

    public void setDrinks(Map<String, Double> drinks) {
        this.drinks = drinks;
    }


}
