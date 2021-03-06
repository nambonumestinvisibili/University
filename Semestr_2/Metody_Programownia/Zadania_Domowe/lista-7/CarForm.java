package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarForm extends Form implements ActionListener {
    JLabel burningLabel;
    JLabel fuelLabel;
    JLabel averageVelocityLabel;
    JTextField burning, fuel, averageVelocity;
    VehiclesCollection collection;
    JToolBar fuel1;

    CarForm(VehiclesCollection v){
        collection = v;

        burningLabel = new JLabel("Burning:");
        fuelLabel = new JLabel("Type of fuel:");
        averageVelocityLabel = new JLabel("Average velocity: ");

        burning = new JTextField();
        fuel = new JTextField("Either ON or 95");
        averageVelocity = new JTextField();
        fuel1 = new JToolBar();

        fuel1.setRollover(true);
        fuel1.add(new JComboBox(new String[] {"ON", "95", "98"}));

        ArrayList<JLabel> secondListOfLabels = new ArrayList<JLabel>();
        secondListOfLabels.add(burningLabel);
        secondListOfLabels.add(fuelLabel);
        secondListOfLabels.add(averageVelocityLabel);

        ArrayList<Container> secondListofFields = new ArrayList<>();
        secondListofFields.add(burning);
        secondListofFields.add(fuel1);
        secondListofFields.add(averageVelocity);


        int ylabels2 = hybridLabel.getY();
        int i = 1;
        for(JLabel lab : secondListOfLabels){
            lab.setBounds(xlabels, ylabels2 +2*i*dylabels, dxlabels, dylabels);
            mainFrame.add(lab);
            i++;
        }

        int j = 1;
        for(Container field : secondListofFields){
            field.setBounds(xlabels + dxlabels + 10, ylabels2 +2*j*dylabels, dxlabels, dylabels);
            mainFrame.add(field);
            j++;
        }

        save.setBounds(yesHybrid.getX(), averageVelocityLabel.getY()+30, dxlabels, 2*dylabels);
        save.addActionListener(this);


        mainFrame.add(save);
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String brd = brand.getText();
        String mlg = mileage.getText();
        String brn = burning.getText();
        String avg = averageVelocity.getText();
        //String ful = fuel1.getUI();
        boolean hib = yesHybrid.isSelected();

        int ml = Integer.parseInt(mlg);
        float br = Float.parseFloat(brn);
        int avgv = Integer.parseInt(avg);
        String fuel3 = "ON";
        Car newcar = new Car(brd, ml, hib, br, fuel3, avgv);

        collection.add(newcar);
        collection.print();

    }





}
