package com.company;

import java.util.ArrayList;

public class VehiclesCollection<Vehicles>{
    private ArrayList<Vehicle> collectionOfVehicles;

    VehiclesCollection(){
        collectionOfVehicles = new ArrayList<>();
    }
    public void add(Vehicle t){
        collectionOfVehicles.add(t);
    }

    public void print(){
        System.out.println(collectionOfVehicles);
    }

}
