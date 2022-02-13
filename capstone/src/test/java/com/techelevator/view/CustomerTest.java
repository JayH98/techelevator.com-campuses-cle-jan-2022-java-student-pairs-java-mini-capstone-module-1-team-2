package com.techelevator.view;

import com.techelevator.Customer;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

public class CustomerTest {

    @Test
    public void does_setItemsCustomerHas_increment_inventory_count(){

        //arrange
        Customer customer = new Customer();




        String location1 = "A1";
        String location2 = "A1";
        String location3 = "A1";
        String location4 = "A1";
        String location5 = "A1";
        String location6 = "A1";
        //act

        customer.setItemsCustomerHas(location1);
        customer.setItemsCustomerHas(location2);
        customer.setItemsCustomerHas(location3);
        customer.setItemsCustomerHas(location4);
        customer.setItemsCustomerHas(location5);
        customer.setItemsCustomerHas(location6);
        Map<String, Integer> testMap = customer.getItemsCustomerHas();

        Map<String, Integer> actualMap = new HashMap<>();
        actualMap.put("A1", -1);

        Integer actual = customer.getItemQuantity("A1");


        //assert

        Assert.assertEquals(testMap, actualMap);
        Assert.assertEquals(1, actual, .001);





    }


}
