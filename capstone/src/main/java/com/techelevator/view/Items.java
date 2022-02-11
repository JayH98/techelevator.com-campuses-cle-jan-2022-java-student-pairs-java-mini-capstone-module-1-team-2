package com.techelevator.view;

public class Items implements Vendables {
    private String itemName;
    private double itemPrice;
    private String itemSound;

    public Items(String itemName, double itemPrice, String itemSound) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSound = itemSound;
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

    @Override
    public double getInventoryQuantity() {
        return 0;
    }

    public void setItemSound(String itemSound) {
        this.itemSound = itemSound;
    }

}
