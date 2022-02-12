package com.techelevator;
import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import java.util.HashMap;
import java.util.Map;

public class MoneyTransaction {

    Menu menu = new Menu();
 //ToDo find a way to change balance to BigDecimal
    public double balance = 0.0;

    public void Transaction(double money) {
        balance = getBalance() - money;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double vendingBalance) {
        balance = vendingBalance;
    }



}