package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class VendingMachineCLI {
//creating an instance of the inventory in the vending machine class

    Inventory inventory = new Inventory();
    private List<String[]> displayForVendingMachine = inventory.getListOfInventoryInStringArrays();

//Map<item location, item price/quantity/sound/name>
    Map<String, Vendables> sale = inventory.getMapOfItems();
//= Map of items in vending machine
//Output messages to the user
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Menu Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Make a Purchase";
    private static final String MAIN_MENU_OPTION_LEAVE = "Exit";
//constructor to string above for output messages
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS,
            MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_LEAVE};

//Display options #2 output message for purchases and final/finish of transactions
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Please Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select a Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Complete Transaction";
//constructor for above messages
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,
            PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
//putting instances for the menu and money transactions classes (bucket)

    private Menu menu;
    MoneyTransaction money = new MoneyTransaction();
    Customer customer = new Customer();
    Map<String, Integer> newMapForQuantity = customer.getItemsCustomerHas();

//calling on the menu from the vendingmachine class

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }
//below .. runs the program to display the instructions to user
//TODO printing exception error when selection is out of bounds (f1)
//TODO Print "Quantity Remaining: " and inventory (decrementing) counter
    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//displays option 1
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

//inventory.getDisplay; String of items at index 0 is A1-D4,
//index 1 is the items name, index 2 is the price

// ToDo need to reformat display to show remaining inventory in slot with sold out

                for (String[] stringOfItems : displayForVendingMachine) {
                    System.out.println(" * " + stringOfItems[0] + " * "
                            + stringOfItems[1] + "  " + "  $" + stringOfItems[2]);
                }
//displays option 2
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//do purchase
                while (true) {
                    System.out.println();
// new BigDecimal(money.getBalance()).round(new MathContext(2, RoundingMode.HALF_UP));
//this is beginning balance of 0
                    System.out.println("Current money left in machine: $" + money.display(money.getBalance()));
//all vending math in here!!!
                    String customerPurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
//displays new options 1 (see below) - money is added by user
                    if (customerPurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        System.out.print("Please only enter dollar bills of $1, $2, $5, $10.");
                        double moneyReceived = menu.getUsersMoney("Please enter amount $ ");
                        money.setBalance(moneyReceived);
//new balance is displayed
//this displays new option 2 (see below) .. also changes everything to
//upper case and links to inventory to decrease item amounts (not working yet)
                    } else if (customerPurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        String selection = menu.userString("Please select the item you'd like to purchase");
                        selection = selection.toUpperCase();
                        Map<String, Vendables> slots = inventory.mapOfItems;
                        Vendables itemPicked = slots.get(selection);

// this checks to see if there is any selection in the map or if not sets to 0.

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

//if you do not have enough money put in for purchase the following message is displayed
//-- loops back to feed money


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
//loops back to first 3 options from the display to the exit the program

                        break;
                    }
                }
//this ends the program setting up for next user/customer

            } else if (choice.equals(MAIN_MENU_OPTION_LEAVE)) {
                System.exit(1);
            }
        }
    }
//this is the main run method. This starts the whole process ... it tell the compiler to
//create a new vending machine

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
