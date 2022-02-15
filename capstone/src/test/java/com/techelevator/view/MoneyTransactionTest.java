package com.techelevator.view;

import com.techelevator.Customer;
import com.techelevator.MoneyTransaction;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTransactionTest {
    @Test
    public void does_display_shows_repeating_decimal_values(){

        //arrange
        MoneyTransaction money = new MoneyTransaction();
        double testDouble = 5.0000002;

        //act
        String actual = money.display(testDouble);

        //assert
        Assert.assertEquals("5.00",actual);
    }
    @Test
    public void does_giveChange_display_correct_change() {

        //arrange
        MoneyTransaction money = new MoneyTransaction();
        double testDouble = 5.9999999999;
        int[] testArray = {24, 0, 0};

        //act
        int[] actual = money.giveChange(testDouble);

        //assert
        Assert.assertArrayEquals(testArray, actual);
    }
}
