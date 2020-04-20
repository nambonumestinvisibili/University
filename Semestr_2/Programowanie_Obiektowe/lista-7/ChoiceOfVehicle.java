package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceOfVehicle {
    private JFrame mainFrame;
    private VehiclesCollection collection;
    private JRadioButton tramRadioButton;
    private JRadioButton carRadioButton;
    private JButton nextButton;
    private JLabel instructions;


    ChoiceOfVehicle(VehiclesCollection v1){
        collection = v1;
        mainFrame = new JFrame("Choosing a type of vehicle...");
        tramRadioButton = new JRadioButton("Tram");
        carRadioButton = new JRadioButton("Car");
        instructions = new JLabel("Select type of a vehicle:");
        nextButton = new JButton("Next");

        instructions.setBounds(10, 30, 300, 20);
        carRadioButton.setBounds(10, 65, 100, 15);
        tramRadioButton.setBounds(110, 65, 100, 15);
        nextButton.setBounds(80, 140, 80, 20);

        ButtonGroup group = new ButtonGroup();
        group.add(carRadioButton);
        group.add(tramRadioButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (carRadioButton.isSelected()){
                    CarForm c1 = new CarForm(collection);
                    mainFrame.dispose();
                }
                else if (tramRadioButton.isSelected()){
                    TramForm t1 = new TramForm(collection);
                    mainFrame.dispose();
                }
            }
        });


        mainFrame.add(nextButton);
        mainFrame.add(instructions);mainFrame.add(carRadioButton);mainFrame.add(tramRadioButton);
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(200, 230);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
}
