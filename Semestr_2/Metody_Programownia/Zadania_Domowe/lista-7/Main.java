package com.company;

public class Main {

    public static void main(String[] args) {
        //ChooseOfVehicle nowy = new ChooseOfVehicle();

        VehiclesCollection v1 = new VehiclesCollection();
        CarForm a = new CarForm(v1);
        v1.print();
    }
}
