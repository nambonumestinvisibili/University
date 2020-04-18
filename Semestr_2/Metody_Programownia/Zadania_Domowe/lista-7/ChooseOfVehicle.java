package com.company;

import javax.swing.*;
import java.awt.*;

public class ChooseOfVehicle extends JFrame {
    private JRadioButton tramRadioButton;
    private JRadioButton carRadioButton;
    private JButton nextButton;
    private JLabel instructions;


    ChooseOfVehicle(){

        tramRadioButton = new JRadioButton("Tram");
        carRadioButton = new JRadioButton("Car");
        instructions = new JLabel("Select type of a vehicle:");
        nextButton = new JButton("Next");

        instructions.setBounds(10, 30, 300, 20);
        carRadioButton.setBounds(10, 65, 100, 15);
        tramRadioButton.setBounds(110, 65, 100, 15);
        nextButton.setBounds(80, 140, 80, 20);

        add(nextButton);
        add(instructions);add(carRadioButton);add(tramRadioButton);
        setSize(200, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
}
