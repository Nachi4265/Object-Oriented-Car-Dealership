package com.pluralsight;

import javax.swing.event.DocumentEvent;

public class UserInterface {

    //Class level variable so all methods can access it
    Dealership dealership;



    //User Interface Constructor that should get our dealership
    public UserInterface(){
        //When a user interface is made it should load our dealership so our information is ready.

        //Create an instance of file manager
        DealershipFileManager dealFileManager = new DealershipFileManager();

        //Our Class level variable is assigned to our Dealership File Manager which gets our dealership info
        this.dealership =  dealFileManager.getDealership();
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

    private void displayVehiclesHelper(Vehicle vehicleToList){
        for(Vehicle v : this.dealership.getAllVehicles()){}
    }





    //METHODS TO GET REQUEST FROM USER.
    private void processGetByPriceRequest() {
       for(Vehicle v : this.dealership.getAllVehicles()){

       }
    }

    private void processGetByMakeModelRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByColorRequest() {
    }

    private void processGetByMileageRequest() {
    }

    private void processGetByVehicleTypeRequest() {
    }

    private void processGetByGetAllVehicleRequest() {
    }

    private void processAddVehicleRequest() {
    }

    private void processRemoveVehicleRequest() {
    }
}
