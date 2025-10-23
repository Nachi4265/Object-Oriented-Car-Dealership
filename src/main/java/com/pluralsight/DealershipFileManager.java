package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

    //TOOLS NEEDED
    //FileReader and Writer
    //BufferReader and Writer
    //String.split
    //Try and catch for errors.


    //Read from a file and turn our text into vehicles that are added to a dealership
    //create and return that dealership
    public Dealership getDealership(){

        //first lets read from our file
        try{
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Skip our first line which is the dealership information
            bufferedReader.readLine();

            String readLineFromFile;
            //Now we need to loop through each line of our file
            while((readLineFromFile = bufferedReader.readLine()) !=null){

                //Store each of our pieces from out inventory into variables
                String[]inventoryParts = readLineFromFile.split("\\|");
                int VIN = Integer.parseInt(inventoryParts[0]);
                int year = Integer.parseInt(inventoryParts[1]);
                String make = inventoryParts[2];
                String model = inventoryParts[3];
                String vehicleType = inventoryParts[4];
                String color = inventoryParts[5];
                int odometer = Integer.parseInt(inventoryParts[6]);
                double price = Double.parseDouble(inventoryParts[7]);

                //Using the information from above we are going to make a vehicle and add it to our dealership
                Vehicle VehicleFromInventory = new Vehicle(VIN,year, make, model,vehicleType,color,odometer,price);

            }
        }catch(Exception e){
            return null;
        }



        try{

            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String readTopLineFromFile;

            //Now we need to loop through ONLY the 1st line of my file
            while((readTopLineFromFile = bufferedReader.readLine()) !=null){
                String[]dealershipInfoParts = readTopLineFromFile.split("\\|");
                String dealershipName = dealershipInfoParts[0];
                String dealershipAddress = dealershipInfoParts[1];
                String dealershipPhoneNum = dealershipInfoParts[2];

                Dealership dealership = new Dealership(dealershipName,dealershipAddress, dealershipPhoneNum);

                
            }


        }
        catch(Exception e){
            return null;
        }


    }

    //Saves the dealership so when we open our program again the data is still there.
    public Dealership saveDealership(){

    }

}
