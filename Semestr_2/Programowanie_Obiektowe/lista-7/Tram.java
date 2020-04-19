package com.company;

public class Tram extends Vehicle {
    int line;
    int capacity;
    String colour;

    Tram(String brand, int mileage, boolean hybrid, int line, int capacity, String colour){
        this.brand = brand;
        this.mileage = mileage;
        this.hybrid = hybrid;
        this.line = line;
        this.capacity = capacity;
        this.colour = colour;
    }

    Tram(String brand, int mileage, boolean hybrid){
        super(brand, mileage, hybrid);
    }

    public int getLine() {
        return line;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getColour() {
        return colour;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setLine(int line) {
        this.line = line;
    }
}
