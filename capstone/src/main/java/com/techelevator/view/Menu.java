package com.techelevator.view;

import com.techelevator.Inventory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

// TODO comment all of these proccesses

    private PrintWriter out;
    private Scanner in;

//Inventory inventory = new Inventory();

    public Menu(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Menu() {
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.valueOf(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
        } catch (NumberFormatException e) {
// eat the exception, an error message will be displayed below since choice will be null
        }
        if (choice == null) {
            out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }
        out.print(System.lineSeparator() + "Please choose an option >>> ");
        out.flush();
    }

    public double getUsersMoney(String askForMoney) {
// Sets valid values for user money in double
        double money = 0.0;
        while (true) {
            try {
                System.out.println();
                System.out.println(askForMoney);
                String input = in.nextLine();
                money = Double.parseDouble(input);
                if (money != 1.0 && money != 2.0 && money != 5.0 && money != 10.00) {
                    System.out.println("Please only enter dollar bills of $1, $2, $5, $10.");
                    continue;
                }
            } catch (Exception e) {
//prints error message for none number inputs
                System.out.println("You entered an invalid money amount. Please try again.");
                continue;
            }
            return money;
        }
    }

    public String userString(String userMessage) {
        System.out.println();
        System.out.println(userMessage);
        String input = in.nextLine();
        return input;
    }
}

