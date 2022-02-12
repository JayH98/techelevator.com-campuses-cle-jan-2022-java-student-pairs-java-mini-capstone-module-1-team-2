package com.techelevator;
import com.techelevator.view.Vendables;

import java.util.HashMap;
import java.util.Map;

public class MoneyTransaction {

    public int balance;

    public MoneyTransaction(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}