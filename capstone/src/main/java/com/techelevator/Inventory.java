package com.techelevator;


import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Inventory {

    //Where vending machine exists
    List<String[]> listOfInventoryInStringArrays = new ArrayList<>();
    Map<String, String> vendingMachineMap = new HashMap<>();
    Map<String, Vendables> mapOfItems = new HashMap<>();

    public Inventory() {

        String vendingMachineMenuPath = "vendingmachine.csv";
        File menuFile = new File(vendingMachineMenuPath);
        String line = "";

        try (Scanner menuInput = new Scanner(menuFile)) {
            while (menuInput.hasNextLine()) {
                line = menuInput.nextLine();
                // Should look like  Location | Item name | Price | Item Class
                if (line.length() > 0 && line.contains("|")) {
                    listOfInventoryInStringArrays.add(line.split("\\|"));
                }
            }
        } catch (IOException e) {
            System.exit(1);
        }

        for (String[] strings : listOfInventoryInStringArrays){
            double newPrice = Double.parseDouble(strings[2]);
            for (int i = 0; i < 4; i++){
                if (strings[3].equals("Chip")){
                    Chips chips = new Chips(strings[1], newPrice, "Crunch Crunch, Yum!", 5);
                    mapOfItems.put(strings[0], chips);
                }
                else if (strings[3].equals("Candy")){
                    Candy candy = new Candy(strings[1], newPrice, "Munch Munch, Yum!", 5);
                    mapOfItems.put(strings[0], candy);
                }
                else if (strings[3].equals("Drinks")){
                    Drinks drinks = new Drinks(strings[1], newPrice, "Glug Glug, Yum!", 5);
                    mapOfItems.put(strings[0], drinks);
                }
                else if (strings[3].equals("Gum")){
                    Gum gum = new Gum(strings[1], newPrice, "Chew Chew, Yum!", 5);
                    mapOfItems.put(strings[0], gum);
                }
            }
        }

        for (String[] items : listOfInventoryInStringArrays) {
            for (int i = 0; i < items.length; i++) {
                vendingMachineMap.put(items[0], items[2]);

            }
        }
    }

    public List<String[]> getListOfInventoryInStringArrays() {
        return listOfInventoryInStringArrays;
    }

    public Map<String, String> getVendingMachineMap() {
        return vendingMachineMap;
    }


    }

