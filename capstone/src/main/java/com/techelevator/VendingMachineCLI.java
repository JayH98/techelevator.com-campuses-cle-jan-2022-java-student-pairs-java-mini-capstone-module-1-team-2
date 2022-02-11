package com.techelevator;

import com.techelevator.view.Menu;

import java.util.*;

public class VendingMachineCLI {


	Inventory inventory = new Inventory();
	private List<String[]> stuff = inventory.getParsedInventory();


//	public void setStuff(List<String[]> list ) {
//		stuff = inventory.getParsedInventory();
//	}





	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	public VendingMachineCLI() {
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (String[] stringOfItems : stuff){
					System.out.println(" * " + stringOfItems[0] + " * "
							+ stringOfItems[1] + "  " + "  $" +stringOfItems[2]);
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
