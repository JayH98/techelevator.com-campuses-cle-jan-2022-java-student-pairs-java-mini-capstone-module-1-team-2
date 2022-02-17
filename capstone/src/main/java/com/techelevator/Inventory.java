package com.techelevator;


import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Inventory {

//Where vending machine exists

//Array of Strings for items in vending machine
    List<String[]> listOfInventoryInStringArrays = new ArrayList<>();
//Creating new Map<locations, Vendables(interface)> of items in vending machine
    Map<String, Vendables> mapOfItems = new HashMap<>();
    //TODO maybe change to list of vendables in map


    Items items = new Items();

    public Inventory() {

//Calling the csv file that contains vendadable items
        String vendingMachineMenuPath = "vendingmachine.csv";
        File menuFile = new File(vendingMachineMenuPath);
        String line = "";
//Reads the user's input
        try (Scanner menuInput = new Scanner(menuFile)) {
            while (menuInput.hasNextLine()) {
                line = menuInput.nextLine();
//Should look like  Location | Item name | Price | Item Class
                if (line.length() > 0 && line.contains("|")) {
                    listOfInventoryInStringArrays.add(line.split("\\|"));
                }
            }
        } catch (IOException e) {
            System.exit(1);
        }

//Array of Strings that contains the menu items

        //TODO remove item sound from map population
        for (String[] strings : listOfInventoryInStringArrays) {
            double newPrice = Double.parseDouble(strings[2]);
            for (int i = 0; i < 4; i++) {
                if (strings[3].equals("Chip")) {
                    Chips chips = new Chips(strings[1], newPrice, "Crunch Crunch, Yum!", 5);
                    mapOfItems.put(strings[0], chips);
                } else if (strings[3].equals("Candy")) {
                    Candy candy = new Candy(strings[1], newPrice, "Munch Munch, Yum!", 5);
                    mapOfItems.put(strings[0], candy);
                } else if (strings[3].equals("Drink")) {
                    Drinks drinks = new Drinks(strings[1], newPrice, "Glug Glug, Yum!", 5);
                    mapOfItems.put(strings[0], drinks);
                } else if (strings[3].equals("Gum")) {
                    Gum gum = new Gum(strings[1], newPrice, "Chew Chew, Yum!", 5);
                    mapOfItems.put(strings[0], gum);
                }
            }
        }
    }

//OLD CODE
//    public Vendables pickItem(String itemLocation) {
//        Vendables itemPicked = mapOfItems.get(itemLocation);
//        int itemQuantity = itemPicked.getInventoryQuantity();
//        mapOfItems.put(itemLocation, itemPicked);

    public List<String[]> getListOfInventoryInStringArrays() {
        return listOfInventoryInStringArrays;
    }

    public Map<String, Vendables> getMapOfItems() {
        return mapOfItems;
    }
}

