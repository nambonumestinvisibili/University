package com.company;

import java.util.ArrayList;

public class VehiclesCollection<Vehicles> {
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

    public Vehicle get(int index){return collectionOfVehicles.get(index);}

    public void remove(int index){collectionOfVehicles.remove(index);}

    public int size() {
        return collectionOfVehicles.size();
    }
}
