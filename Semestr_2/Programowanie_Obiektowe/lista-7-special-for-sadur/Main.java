package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileData;
        if (args.length > 1) fileData = args[1];
        else fileData = "VehicleData.ser";



        try {
            FileInputStream fis = new FileInputStream(fileData);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Vehicle> arrV = new ArrayList<>();
            arrV = (ArrayList<Vehicle>) ois.readObject();


            VehiclesCollection v = new VehiclesCollection();

            for (int i = 0; i < arrV.size(); i++){
                v.add(arrV.get(i));
            }

            GUI g = new GUI(v);

        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
