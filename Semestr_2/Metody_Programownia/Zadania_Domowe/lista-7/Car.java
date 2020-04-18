package com.company;

public class Car extends Vehicle {
    float burning;
    String fuel;
    int averageVelocity;


    Car(String brand, int mileage, boolean hybrid, float burning, String fuel, int averageVelocity){
        this.brand = brand;
        this.mileage = mileage;
        this.hybrid = hybrid;
        this.burning = burning;
        this.fuel  = fuel;
        this.averageVelocity = averageVelocity;
    }

    Car(float burning, String fuel){
        this.burning = burning;
        this.fuel = fuel;
    }

    Car(String brand, int mileage, boolean hybrid) {
        super(brand, mileage, hybrid);
    }

    public float getBurning(){return burning;}
    public boolean setBurning(float burning){this.burning = burning; return true;}

    public String getFuel(){return fuel;}
    public boolean setFuel(String fuel){this.fuel = fuel; return true;}

    public int getAverageVelocity() {
        return averageVelocity;
    }
    public void setAverageVelocity(int averageVelocity) {
        this.averageVelocity = averageVelocity;
    }

}
