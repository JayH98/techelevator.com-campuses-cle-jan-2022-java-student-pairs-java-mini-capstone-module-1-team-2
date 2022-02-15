package com.techelevator.view;

public class Items implements Vendables {
    private String itemName;
    private double itemPrice;
    private String itemSound;
    private int inventoryQuantity;

// Constructor for our implemented Vendables with getters and setters
// Used by each item group (Candy, Chips, Drinks, and Gum)
// Called by Inventory Class to Map mapOfItems

    public Items(String itemName, double itemPrice, String itemSound, int inventoryQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSound = itemSound;

//Sets all items to a number (Candy, Chips, Drinks, and Gum)
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


// Overrides for vendables
    @Override
    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setItemSound(String itemSound) {
        this.itemSound = itemSound;
    }

}
