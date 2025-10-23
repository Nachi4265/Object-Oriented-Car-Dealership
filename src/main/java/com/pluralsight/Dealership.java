package com.pluralsight;

import java.util.ArrayList;

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

    public void addVehicle(){}

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void remove(){}



    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){

      //loop through each vehicle, if it is withing the correct price return the result.
        for()


    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make , String model){
        return null;
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
