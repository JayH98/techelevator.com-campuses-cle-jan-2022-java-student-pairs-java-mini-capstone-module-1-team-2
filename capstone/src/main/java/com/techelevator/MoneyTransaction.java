package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Vendables;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MoneyTransaction {

    Menu menu = new Menu();
    //ToDo find a way to change balance to BigDecimal

    /*
    static BigDecimal	valueOf(double val)
Translates a double into a BigDecimal, using the double's canonical string representation provided by the Double.toString(double) method.

     */
    public double balance = 0.0;

    public void transaction(double money) {
        balance = balance - money;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double vendingBalance) {
        balance += vendingBalance;
    }

    public String display(double money) {
        //

        if (money > 0.00 && money < 9.99) {
            DecimalFormat d1 = new DecimalFormat("#.00");
            return d1.format(money);
        }
        else {
            DecimalFormat d2 = new DecimalFormat("##.00");
            return d2.format(money);
        }
    }

    public int[] giveChange(double money) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int[] changeForCustomer = {0, 0, 0};

        if (money <= 0) {
            return changeForCustomer;
        }
        if (money > 0) {
            quarters = (int) (money / .25);
            money = money - (quarters * .25);
        }
        if (money > 0) {
            dimes = (int) (money / .10);
            money = money - (dimes * .10);
        }
        if (money > 0) {
            nickels = (int) (money / .5);
            money = money - (nickels * .5);
        }
        changeForCustomer[0] = quarters;
        changeForCustomer[1] = dimes;
        changeForCustomer[2] = nickels;

        setBalance(0);

        return changeForCustomer;
    }


}

//    BigDecimal big = new BigDecimal(10.25);
//    BigDecimal small = new BigDecimal(0.5);
//if (big.compareTo(small) == 0) {
//        System.out.println("Values are equal");
//        }
//        else if (big.compareTo(small) < 0) {
//        System.out.println("big is smaller than small");
//        }
//        else if (big.compareTo(small) > 0) {
//        System.out.println("big is greater than small");
//        }