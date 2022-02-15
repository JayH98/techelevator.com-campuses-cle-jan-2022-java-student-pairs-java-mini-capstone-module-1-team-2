package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VendingLog {
    //TODO make our log write out customers actions ??How??
//Writes to our log
    public void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("VendingMachineLog.txt"));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
