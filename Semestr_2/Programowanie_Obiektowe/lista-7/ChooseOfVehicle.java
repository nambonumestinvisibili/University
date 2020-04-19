package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseOfVehicle extends JFrame {
    private VehiclesCollection collection;
    private JRadioButton tramRadioButton;
    private JRadioButton carRadioButton;
    private JButton nextButton;
    private JLabel instructions;


    ChooseOfVehicle(VehiclesCollection v1){
        collection = v1;
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
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (carRadioButton.isSelected()){
                    CarForm c1 = new CarForm(collection);
                    dispose();
                }
                else if (tramRadioButton.isSelected()){
                    TramForm t1 = new TramForm(collection);
                    dispose();
                }
            }
        });


        add(nextButton);
        add(instructions);add(carRadioButton);add(tramRadioButton);
        setSize(200, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
}
