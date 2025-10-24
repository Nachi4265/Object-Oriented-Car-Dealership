package com.pluralsight;

import java.util.ArrayList;
import java.util.Objects;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    //CONSTRUCTOR
    public Dealership(String name, String address, String phone) {
        this.inventory = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }



    //GETTERS AND SETTERS.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }





    //METHODS

    //ADD OR REMOVE VEHICLE
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void remove(Vehicle vehicle){
        inventory.remove(vehicle);
    }




    //GET VEHICLE BY INFORMATION
    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){

        //loop through each vehicle, if it is withing the correct price return the result.
        // ask what is the maximum and minimum price you are looking for.
        //Look at each vehicle in my list,
        //compare the value of that vehicle to the max and min price
        //if it's within that range then show me the vehicle.

        //An ArrayList that will store all of our vehicles that match our
        ArrayList<Vehicle> results = new ArrayList<>();

        for(Vehicle vehicle:inventory){

            //if the vehicle price is less
            if(vehicle.getPrice() > minPrice && vehicle.getPrice() < maxPrice){
              //  System.out.println(vehicle);
                results.add(vehicle);
            }
        }
        //Return the vehicles that are within our range.
        return results;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make , String model){
        ArrayList<Vehicle> MakeModelResult = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(Objects.equals(vehicle.getMake(), make) && Objects.equals(vehicle.getModel(), model)){
                MakeModelResult.add(vehicle);
            }
        }
        return MakeModelResult;
    }

    public ArrayList<Vehicle> getVehiclesByYear(String year){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMiles, int maxMiles ){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }

}
