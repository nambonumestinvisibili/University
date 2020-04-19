package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainEditor {
    JFrame mainFrame;
    JComboBox boxOfVehicles;
    VehiclesCollection collection;
    JLabel instructions;
    JButton edit;
    JButton remove;

    MainEditor(VehiclesCollection v1){
        collection = v1;
        String[] namesOfCars = new String[v1.size()];
        for (int i = 0; i < v1.size(); i++){
            namesOfCars[i] = v1.get(i).getBrand();
        }
        mainFrame = new JFrame();
        instructions = new JLabel("Choose the Vehicle to edit");
        boxOfVehicles = new JComboBox(namesOfCars);
        edit = new JButton("Edit");
        remove = new JButton("Remove");

        mainFrame.setSize(300, 300);
        mainFrame.setLayout(null);
        int comboboxwidth = 150;
        boxOfVehicles.setBounds((mainFrame.getWidth()-comboboxwidth)/2, 60, comboboxwidth, 50);
        remove.setBounds(150, 160, 90, 40);
        edit.setBounds(150, 200, 90, 40);
        instructions.setBounds(((mainFrame.getWidth()-comboboxwidth)/2), 30, comboboxwidth, 15);


        mainFrame.add(remove);
        mainFrame.add(boxOfVehicles);
        mainFrame.add(edit);
        mainFrame.add(instructions);

        mainFrame.setVisible(true);


        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idx = boxOfVehicles.getSelectedIndex();

                if (collection.get(idx) instanceof Car){
                    CarEditor carEditor = new CarEditor(v1, idx);
                    mainFrame.dispose();
                }
                else if (collection.get(idx) instanceof Tram){
                    TramEditor tramEditor = new TramEditor(v1, idx);
                }
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idx = boxOfVehicles.getSelectedIndex();

                collection.remove(idx);
                mainFrame.dispose();
            }
        });



    }
}
