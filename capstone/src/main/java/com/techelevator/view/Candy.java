package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Candy extends Vendables {

    Map<String, Double> candy = new HashMap<String, Double>();

    public Candy(String itemName, double itemPrice, String itemSound) {
        super(itemName, itemPrice, itemSound);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Munch Munch, Yum!");
    }

    public Map<String, Double> getCandy() {
        return candy;
    }

    public void setCandy(Map<String, Double> drinks) {
        this.candy = drinks;
    }


}
