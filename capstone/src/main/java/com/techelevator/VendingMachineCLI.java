package com.techelevator;

import com.techelevator.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineCLI {

	private List<String[]> stuff = new ArrayList<>();
	Inventory inventory = new Inventory();

	public void setStuff(List<String[]> parsedInventory) {
		this.stuff = inventory.getParsedInventory();
	}

	String[] strings = {"hello", "goodbye"};



	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}



	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (String[] stringOfItems : stuff){
					System.out.println(stringOfItems.toString());
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
