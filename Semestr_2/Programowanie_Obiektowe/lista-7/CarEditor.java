package com.company;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.awt.event.ActionEvent;

public class CarEditor extends CarForm {
    //VehiclesCollection collection;
    int editedCarIndex;

    CarEditor(VehiclesCollection v1, int index) {super(v1); editedCarIndex = index;}

    @Override
    public void actionPerformed(ActionEvent e){
        String brd = brand.getText();
        String mlg = mileage.getText();
        String brn = burning.getText();
        String avg = averageVelocity.getText();
        String ful = (String) fuel1.getSelectedItem();
        boolean hib = yesHybrid.isSelected();
        System.out.println(collection.get(editedCarIndex).getBrand());
        int ml = Integer.parseInt(mlg);
        float br = Float.parseFloat(brn);
        int avgv = Integer.parseInt(avg);


        if (collection.get(editedCarIndex) instanceof Car){
            collection.get(editedCarIndex).setBrand(brd);
            collection.get(editedCarIndex).setMileage(ml);
            collection.get(editedCarIndex).setHybrid(hib);
            ((Car) collection.get(editedCarIndex)).setBurning(br);
            ((Car) collection.get(editedCarIndex)).setAverageVelocity(avgv);
            ((Car) collection.get(editedCarIndex)).setFuel(ful);
        }


        mainFrame.dispose();
        //GUI G = new GUI(collection);

    }
}
