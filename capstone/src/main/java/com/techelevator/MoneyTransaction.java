package com.techelevator;
import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import java.util.HashMap;
import java.util.Map;

public class MoneyTransaction {

    Menu menu = new Menu();

    public double balance = 0.0;

    public void Transaction(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double vendingBalance) {
        balance += vendingBalance;
    }

}