package com.techelevator.view;

public class Vendables {
    private String itemName;
    private double itemPrice;
    private String itemSound;

    public Vendables (String itemName, double itemPrice, String itemSound) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSound =   itemSound;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemSound() {
        return itemSound;
    }

    public void setItemSound(String itemSound) {
        this.itemSound = itemSound;
    }
    
}
