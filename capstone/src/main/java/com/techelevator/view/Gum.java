package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gum extends Items {

    public Gum(String itemName, double itemPrice, String itemSound, int inventoryQuantity) {
        super(itemName, itemPrice, itemSound, inventoryQuantity);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Chew Chew, Yum!");
    }
}
