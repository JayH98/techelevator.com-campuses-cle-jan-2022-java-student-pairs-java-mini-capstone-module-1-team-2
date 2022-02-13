package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import javax.swing.*;
import java.util.*;

public class VendingMachineCLI {


    Inventory inventory = new Inventory();
    private List<String[]> displayForVendingMachine = inventory.getListOfInventoryInStringArrays();

    //	Map<item location, item price/quantity/sound/name>
    Map<String, Vendables> sale = inventory.getMapOfItems(); // = Map of items in vending machine

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_LEAVE = "Leave";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS,
            MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_LEAVE};

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,
            PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


    private Menu menu;
    MoneyTransaction money = new MoneyTransaction();
    Customer customer = new Customer();
    Map<String, Integer> newMapForQuantity = customer.getItemsCustomerHas();




    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

//				inventory.getDisplay; String of items at index 0 is A1-D4,
//				index 1 is the items name, index 2 is the price

                for (String[] stringOfItems : displayForVendingMachine) {
                    System.out.println(" * " + stringOfItems[0] + " * "
                            + stringOfItems[1] + "  " + "  $" + stringOfItems[2]);
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                while (true) {
                    System.out.println();
                    System.out.println("Current money left in machine: $" + money.getBalance());
                    // all vending math in here!!!
                    String customerPurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    if (customerPurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        System.out.print("Please only enter dollar bills of $1, $2, $5, $10.");
                        double moneyReceived = menu.getUsersMoney("Please enter amount");
                        money.setBalance(moneyReceived);
                    } else if (customerPurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        String selection = menu.userString("Please select the item you'd like to purchase");
                        selection = selection.toUpperCase();
                        Map<String, Vendables> slots = inventory.mapOfItems;
                        Vendables itemPicked = slots.get(selection);

                        if (customer.getItemQuantity(selection) == null) {
                            customer.setInitialItems(selection);
                        }
                        if (customer.getItemQuantity(selection) >= 0 && customer.getItemQuantity(selection) < 5) {
                            if (money.getBalance() >= itemPicked.getItemPrice()) {
                                System.out.println();

                                customer.setItemsCustomerHas(selection);
                                double moneyToSubtract = itemPicked.getItemPrice();
                                money.transaction(moneyToSubtract);
                                System.out.println(itemPicked.getItemSound());
                                System.out.println(customer.getItemQuantity(selection));


                            } else {
                                System.out.println("You need to enter more money.");
                            }
                        } else System.out.println("Item out of stock");
                    } else if (customerPurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        //give customer back change
                        //print quarters/whatever

                        int[] changeForCustomer = money.giveChange(money.getBalance());
                        System.out.println();
                        System.out.println("Change returned: " + changeForCustomer[0] + " Quarter(s) " + changeForCustomer[1]
                                + " Dime(s) " + changeForCustomer[2] + " Nickel(s)");


                        break;
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_LEAVE)) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
