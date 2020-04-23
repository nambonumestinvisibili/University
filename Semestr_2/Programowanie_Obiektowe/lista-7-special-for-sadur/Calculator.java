package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    VehiclesCollection collection;
    JFrame mainFrame;
    JLabel instructions;
    JComboBox boxOfVehicles;
    JButton calculate;
    JLabel amountOfKMLabel;
    JTextField amountOfKMTextField;
    JLabel res;

    Calculator(VehiclesCollection v1){
        collection = v1;
        String[] namesOfCars = new String[v1.size()];
        for (int i = 0; i < v1.size(); i++){
            namesOfCars[i] = v1.get(i).getBrand();
        }
        mainFrame = new JFrame();
        instructions = new JLabel("Choose the Car to calculate how much money you'd spent by traveling :");
        boxOfVehicles = new JComboBox(namesOfCars);
        calculate = new JButton("Calculate");
        amountOfKMLabel = new JLabel("Insert amount of kilometers");
        amountOfKMTextField = new JTextField("100");
        res = new JLabel("Price: ");

        mainFrame.setSize(300, 300);
        mainFrame.setLayout(null);
        int comboboxwidth = 180;
        int xCor = (mainFrame.getWidth()-comboboxwidth)/2;
        boxOfVehicles.setBounds(xCor, 60, comboboxwidth, 50);
        instructions.setBounds(xCor, 30, comboboxwidth, 15);
        calculate.setBounds(150, 200, 90, 40);
        amountOfKMLabel.setBounds(xCor, 120, comboboxwidth, 15);
        amountOfKMTextField.setBounds(xCor, 140, comboboxwidth, 20);
        res.setBounds(xCor, 170, comboboxwidth, 20);
        //here additional buttons:



        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idx = boxOfVehicles.getSelectedIndex();
                double price;
                double burning;
                double result = 0;
                if (collection.get(idx) instanceof Car) {
                    burning = ((Car) collection.get(idx)).getBurning()/100;
                    switch (((Car) collection.get(idx)).getFuel()) {
                        case "98":
                            price = 4.41;
                            break;
                        case "95":
                            price = 4.02;
                            break;
                        case "ON":
                            price = 4.17;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + ((Car) collection.get(idx)).getFuel());
                    }
                    double km = Double.parseDouble(amountOfKMTextField.getText());
                    result = price*burning*km;
                    res.setText("Price: " + result + " PLN");
                }
                else {
                    res.setText("Not a car");
                }





            }

        });

        mainFrame.add(res);
        mainFrame.add(amountOfKMLabel);
        mainFrame.add(amountOfKMTextField);
        mainFrame.add(boxOfVehicles);
        mainFrame.add(instructions);
        mainFrame.add(calculate);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



    }
}
