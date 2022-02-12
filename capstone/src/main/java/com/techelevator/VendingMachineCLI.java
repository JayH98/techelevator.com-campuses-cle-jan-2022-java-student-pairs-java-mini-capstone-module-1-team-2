package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import java.text.NumberFormat;
import java.util.*;

public class VendingMachineCLI {


	Inventory inventory = new Inventory();
	private List<String[]> displayForVendingMachine = inventory.getListOfInventoryInStringArrays();

//	Map<item location, item price/quantity/sound/name>
	Map<String, Vendables> sale = inventory.getMapOfItems(); // = Map of items in vending machine

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_LEAVE = "Leave";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_LEAVE};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


	private Menu menu;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

//				inventory.getDisplay; String of items at index 0 is A1-D4,
//				index 1 is the items name, index 2 is the price

				for (String[] stringOfItems : displayForVendingMachine){
					System.out.println(" * " + stringOfItems[0] + " * "
							+ stringOfItems[1] + "  " + "  $" +stringOfItems[2]);
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
					while (true) {
						System.out.println();
						System.out.println("Current money provided: " + menu.getUsersMoney() );

					}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
