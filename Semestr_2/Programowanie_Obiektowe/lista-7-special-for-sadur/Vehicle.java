package com.company;

public abstract class Vehicle{
    int mileage = 0;
    String brand = "undefined";
    boolean hybrid = false;

    public int getMileage(){return mileage;}
    public boolean setMileage(int milleage){this.mileage = milleage; return true;}

    public String getBrand(){return brand;}
    public boolean setBrand(String brand){this.brand = brand; return true;}

    public boolean isHybrid(){return this.hybrid;}
    public boolean setHybrid(boolean isHybrid){this.hybrid = isHybrid; return true;}

    Vehicle(String brand, int mileage, boolean hybrid){
        this.brand = brand;
        this.mileage = mileage;
        this.hybrid = hybrid;
    }
    Vehicle(){}
}
