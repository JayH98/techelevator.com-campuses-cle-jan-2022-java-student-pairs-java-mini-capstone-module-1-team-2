package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    //Where vending machine exists

    public Inventory() {

        String vendingMachineMenuPath = "vendingmachine.csv";
        File menuFile = new File(vendingMachineMenuPath);
        String line = "";
        List<String[]> parsedInventory = new ArrayList<>();

        try (Scanner menuInput = new Scanner(menuFile)) {
            while (menuInput.hasNextLine()) {
                line = menuInput.nextLine();
                // Should look like Question-1|answer-1|answer-2|correct-answer*|answer-4
                if (line.length() > 0 && line.contains("|")) {
                    parsedInventory.add(line.split("\\|"));
                }
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }
}
