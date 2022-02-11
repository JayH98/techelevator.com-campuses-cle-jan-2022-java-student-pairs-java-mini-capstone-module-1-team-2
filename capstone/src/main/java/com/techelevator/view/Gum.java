package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gum extends Vendables {

    Map<String, Double> gum = new HashMap<String, Double>();

    List<Gum> gums = new ArrayList<>();

    public Gum(String itemName, double itemPrice, String itemSound) {
        super(itemName, itemPrice, itemSound);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Chew Chew, Yum!");
    }

    public Map<String, Double> getGum() {
        return gum;
    }

    public void setGum(Map<String, Double> drinks) {
        this.gum = drinks;
    }


}
