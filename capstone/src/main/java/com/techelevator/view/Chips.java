package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Chips extends Items {

    Map<String, Double> chips = new HashMap<String, Double>();

    public Chips(String itemName, double itemPrice, String itemSound) {
        super(itemName, itemPrice, itemSound);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Crunch Crunch, Yum!");
    }

    public Map<String, Double> getChips() {
        return chips;
    }

    public void setChips(Map<String, Double> drinks) {
        this.chips = drinks;
    }


}
