package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gum extends Items implements Vendables {


    public Gum(String itemName, double itemPrice, String itemSound) {
        super(itemName, itemPrice, itemSound);
    }

    @Override
    public void setItemSound(String itemSound) {
        super.setItemSound("Chew Chew, Yum!");
    }


    public String getItemName(){
        return ;
    }


}
