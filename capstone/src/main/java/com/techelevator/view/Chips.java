package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Chips extends Items {

    public Chips(String itemName, double itemPrice, String itemSound, int inventoryQuantity) {
        super(itemName, itemPrice, itemSound, inventoryQuantity);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Crunch Crunch, Yum!");
    }

}
