package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Inventory {

    //Where vending machine exists
    List<String[]> parsedInventory = new ArrayList<>();
    Map<String, String> vendingMachineMap = new HashMap<>();

    public Inventory() {

        String vendingMachineMenuPath = "vendingmachine.csv";
        File menuFile = new File(vendingMachineMenuPath);
        String line = "";


        try (Scanner menuInput = new Scanner(menuFile)) {
            while (menuInput.hasNextLine()) {
                line = menuInput.nextLine();
                // Should look like  Location| Item name | Price | Item Class
                if (line.length() > 0 && line.contains("|")) {
                    parsedInventory.add(line.split("\\|"));
                }
            }
        } catch (IOException e) {
            System.exit(1);
        }

        for (String[] items : parsedInventory) {
            for (int i = 0; i < items.length; i++) {
                vendingMachineMap.put(items[0], items[1]);
            }
        }
    }

    public List<String[]> getParsedInventory() {
        return parsedInventory;
    }

    public Map<String, String> getVendingMachineMap() {
        return vendingMachineMap;
    }
}
