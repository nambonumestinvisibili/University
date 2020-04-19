package com.company;

public class Main {

    public static void main(String[] args) {

        VehiclesCollection v1 = new VehiclesCollection();
        Car c1 = new Car("Saab", 10, true, 10, "ON", 20);
        v1.add(c1);
        Car c2 = new Car("Audi", 1, true, (float) 5.5, "95", 100);
        v1.add(c2);
        Car c3 = new Car("PPassat", 300000, false, 68, "98", 68 );
        v1.add(c3);
        GUI g = new GUI(v1);
        //ChooseOfVehicle c = new ChooseOfVehicle();
        //Review r = new Review(v1);
        //GUI g = new GUI(v1);
        //MainEditor e1 = new MainEditor(v1);
        //Calculator cal = new Calculator(v1);
    }
}
