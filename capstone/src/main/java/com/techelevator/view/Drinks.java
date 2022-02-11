package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Drinks extends Items {

    public Drinks(String itemName, double itemPrice, String itemSound, int inventoryQuantity) {
        super(itemName, itemPrice, itemSound, inventoryQuantity);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Glug Glug, Yum!");
    }
}
