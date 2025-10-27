package com.pluralsight;

import javax.swing.event.DocumentEvent;
import java.util.ArrayList;

public class UserInterface {

    //Class level variable so all methods can access it
    Dealership dealership;
    DealershipFileManager dealershipFileManager;



    //User Interface Constructor that should get our dealership
    public UserInterface(){
        //When a user interface is made it should load our dealership so our information is ready.

        //Create an instance of file manager
         this.dealershipFileManager = new DealershipFileManager();

        //Our Class level variable is assigned to our Dealership File Manager which gets our dealership info
        this.dealership =  dealershipFileManager.getDealership();
    }



    //How our user menu is display
    public void display(){


        while (true){
            String mainMenu = """
            ===================| MENU |======================
            1 - Find vehicles within a price range\n
            2 - Find vehicles by make / model\n
            3 - Find vehicles by year range\n
            4 - Find vehicles by color\n
            5 - Find vehicles by mileage range\n
            6 - Find vehicles by type (car, truck, SUV, van)\n
            7 - List ALL vehicles\n
            8 - Add a vehicle\n
            9 - Remove a vehicle\n
            99 - Quit
            """;

            System.out.println(mainMenu);

            int command = InputCollector.promptForInt("Enter a number command");

            switch (command){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetByGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }



    //a private displayVehicles() helper method.  Because you will be
    //displaying many different lists of vehicles, it makes sense to have a helper
    //method that displays the list and can be called from all of the get-vehicles
    //type methods.  This method should have a parameter that is passed in
    //containing the vehicles to list.  Within the method, create a loop and
    //display the vehicles!

    private void displayVehiclesHelper(ArrayList<Vehicle>vehicleToList){
        for(Vehicle v : vehicleToList){
            System.out.println(
                    v.getVIN()
                    + " | " +v.getYear()
                    + " | " +v.getMake()
                    + " | " +v.getModel()
                    + " | " +v.getVehicleType()
                    + " | " +v.getColor()
                    + " | " +v.getOdometer()
                    + " | " + v.getPrice());
        }
    }



    //METHODS TO GET REQUEST FROM USER.
    private void processGetByPriceRequest() {
        System.out.println("What is the minimum and maximum price?");
       double minPrice = InputCollector.promptForDouble("Enter minimum price");
       double maxPrice = InputCollector.promptForDouble("Enter maximum price");

       ArrayList<Vehicle>vehiclesByPrice = dealership.getVehiclesByPrice(minPrice,maxPrice);
       displayVehiclesHelper(vehiclesByPrice);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("What is the Make and Model you are looking for?");
        String make = InputCollector.promptForString("Enter Make");
        String model = InputCollector.promptForString("Enter Model");

        ArrayList<Vehicle>vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make,model);
        displayVehiclesHelper(vehiclesByMakeModel);
    }

    private void processGetByYearRequest() {
        System.out.println("What is the year you are looking for?");
        int minYear = InputCollector.promptForInt("Enter Minimum Year (YYYY)");
        int maxYear = InputCollector.promptForInt("Enter Maximum Year (YYYY)");

        ArrayList<Vehicle>vehiclesByYear = dealership.getVehiclesByYear(minYear,maxYear);
        displayVehiclesHelper(vehiclesByYear);
    }

    private void processGetByColorRequest() {
        System.out.println("What vehicle color you are looking for?");
        String color = InputCollector.promptForString("Enter color");

        ArrayList<Vehicle>vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehiclesHelper(vehiclesByColor);

    }//todo add ignore case

    private void processGetByMileageRequest() {
        System.out.println("What vehicle mileage you are looking for?");
        int minMileage = InputCollector.promptForInt("Enter minimum mileage");
        int maxMileage = InputCollector.promptForInt("Enter maximum mileage");

        ArrayList<Vehicle>vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehiclesHelper(vehiclesByMileage);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("What Type of vehicle are you searching for?");
        String vehicleType = InputCollector.promptForString("Enter vehicle type");

        ArrayList<Vehicle>vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehiclesHelper(vehiclesByType);
    }



    private void processGetByGetAllVehicleRequest() {
       displayVehiclesHelper(dealership.getAllVehicles());
    }


    //Add and remove request
    private void processAddVehicleRequest() {
        int VIN  = InputCollector.promptForInt("What is the vehicle VIN number");
        int year = InputCollector.promptForInt("What is the Year of your vehicle");
        String make = InputCollector.promptForString("What is the vehicle make?");
        String model = InputCollector.promptForString("What is the vehicle model?");
        String vehicleType = InputCollector.promptForString("What is the vehicle type");
        String color = InputCollector.promptForString("What is the color of the vehicle");
        int odometer = InputCollector.promptForInt("What is the mileage of the vehicle");
        double price = InputCollector.promptForDouble("What is you asking price for the vehicle");

        Vehicle vehicleToAdd = new Vehicle(VIN,year,make,model,vehicleType,color,odometer,price);
        dealership.addVehicle(vehicleToAdd);

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

    }

    private void processRemoveVehicleRequest() {

        //Put in the information of the vehicle we want to remove
        int VIN  = InputCollector.promptForInt("What is the vehicle VIN number");

        boolean found = false;

        for(Vehicle v : dealership.getAllVehicles()){
            if(VIN == v.getVIN()){
                found = true;
                dealership.remove(v);
                System.out.println("Vehicle Removed!");
                this.dealershipFileManager.saveDealership(dealership);
                break;
            }
        }

        if(found == false){
                System.out.println("Could not find that Vehicles VIN");
        }
    }

}
