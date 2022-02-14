package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MoneyTransaction {

    Menu menu = new Menu();
//ToDo find a way to change balance to BigDecimal?

/*
static BigDecimal	valueOf(double val)
Translates a double into a BigDecimal, using the double's canonical string representation provided by the Double.toString(double) method.
*/

//This starts the money at $0.00 (approx. VendingMachineCLI line 69)
    public double balance = 0.0;

    public void transaction(double money) {
        balance = balance - money;

    }

    public double getBalance() {
        return balance;
    }

//After user inputs money gives the new $ amount ( if statement approx. VendingMachineCLI line 73)
    public void setBalance(double vendingBalance) {
        balance += vendingBalance;
    }

    public String display(double money) {

//Added formatting for decimals that gives us 2 places after decimal

        if (money > 0.00 && money < 9.99) {
            DecimalFormat d1 = new DecimalFormat("#.00");
            return d1.format(money);
        }
        else {
            DecimalFormat d2 = new DecimalFormat("##.00");
            return d2.format(money);
        }
    }


//Declare how many Q, D, N are given as change versus their value
//Sets up change as objects
    public int[] giveChange(double money) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int[] changeForCustomer = {0, 0, 0};

        if (money <= 0) {
            return changeForCustomer;
        }

//The math for the change value
        if (money > 0) {
            quarters = (int) (money / .25);
            money = money - (quarters * .25);
        }
        if (money > 0) {
            dimes = (int) (money / .10);
            money = money - (dimes * .10);
        }
        if (money > 0) {

//TODO maybe should be 0.05
            nickels = (int) (money / .5);
            money = money - (nickels * .5);
        }
        changeForCustomer[0] = quarters;
        changeForCustomer[1] = dimes;
        changeForCustomer[2] = nickels;

//TODO what does line 84 do?
        setBalance(0);

        return changeForCustomer;

//After change is returned the customer balance is back to $0 (approx.MoneyTransaction line 59)
    }


}

//TODO figure out what to do with this code

//    BigDecimal big = new BigDecimal(10.25);
//    BigDecimal small = new BigDecimal(0.5);
// if (big.compareTo(small) == 0) {
//        System.out.println("Values are equal");
//        }
//        else if (big.compareTo(small) < 0) {
//        System.out.println("big is smaller than small");
//        }
//        else if (big.compareTo(small) > 0) {
//        System.out.println("big is greater than small");
//        }