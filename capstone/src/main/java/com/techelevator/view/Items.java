package com.techelevator.view;

public class Items implements Vendables {
    private String itemName;
    private double itemPrice;
    private String itemSound;
    private int inventoryQuantity;

    public Items(String itemName, double itemPrice, String itemSound, int inventoryQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSound = itemSound;
        this.inventoryQuantity = inventoryQuantity;
    }

    public Items() {

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
    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void vendItem(String) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public void setItemSound(String itemSound) {
        this.itemSound = itemSound;
    }

}
