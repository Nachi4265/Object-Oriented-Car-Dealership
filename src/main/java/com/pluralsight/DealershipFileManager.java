package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    //TOOLS NEEDED
    //FileReader and Writer
    //BufferReader and Writer
    //String.split
    //Try and catch for errors.


    //Read from a file and turn our text into vehicles that are added to a dealership
    //create and return that dealership
    public Dealership getDealership() {

        Dealership dealership = null;

        //first lets read from our file
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            //Read the first line of my file and make a dealership from it.
            String readLineFromFile;
            readLineFromFile = bufferedReader.readLine();

            String[] dealershipInfoParts = readLineFromFile.split("\\|");
            String dealershipName = dealershipInfoParts[0];
            String dealershipAddress = dealershipInfoParts[1];
            String dealershipPhoneNum = dealershipInfoParts[2];

            //Our dealership is made!
            //Our name , Address and phone number are then passed into it.
            dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhoneNum);


            //Now we need to loop through each line of the rest of our file and make vehicles from it.
            while ((readLineFromFile = bufferedReader.readLine()) != null) {


                //Store each of our pieces from out inventory into variables
                String[] inventoryParts = readLineFromFile.split("\\|");
                int VIN = Integer.parseInt(inventoryParts[0]);
                int year = Integer.parseInt(inventoryParts[1]);
                String make = inventoryParts[2];
                String model = inventoryParts[3];
                String vehicleType = inventoryParts[4];
                String color = inventoryParts[5];
                int odometer = Integer.parseInt(inventoryParts[6]);
                double price = Double.parseDouble(inventoryParts[7]);

                //Using the information from above we are going to make a vehicle and add it to our dealership
                Vehicle vehicleFromInventory = new Vehicle(VIN, year, make, model, vehicleType, color, odometer, price);

                //Add our vehicle to our inventory
                dealership.addVehicle(vehicleFromInventory);


            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return our dealership
        return dealership;
    }


    //Saves the dealership so when we open our program again the data is still there.
    public Dealership saveDealership(){
        return null;
    }

}
