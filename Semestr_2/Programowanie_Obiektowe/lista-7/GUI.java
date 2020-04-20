package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {
    VehiclesCollection collection;
    JButton calc;
    String hello = "<html>Welcome to Vehicles Collection Editor!<br/> What do you want to do?</html>";

    JFrame mainFrame;
    JLabel invitation;
    JButton addVehicle;
    JButton searchVehicles;
    JButton editVehicles;


    GUI(VehiclesCollection veh){
        collection = veh;


        mainFrame = new JFrame("Vehicles Collection Editor");
        mainFrame.setLayout(null);
        mainFrame.setSize(450, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        int invitLen = 300;
        invitation = new JLabel(hello, SwingConstants.CENTER);
        invitation.setBounds((mainFrame.getWidth()-invitLen)/2,30,invitLen,100);

        int addHei = 120;
        addVehicle = new JButton("Add a vehicle");
        addVehicle.setBounds((mainFrame.getWidth()-200)/2, addHei, 200, 60);
        addVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChoiceOfVehicle n1 = new ChoiceOfVehicle(collection);
                //this.dispose();
            }
        });

        searchVehicles = new JButton("Review your vehicles");
        searchVehicles.setBounds((mainFrame.getWidth()-200)/2, addHei+80, 200, 60);
        searchVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Review r1 = new Review(collection);
            }
        });

        editVehicles = new JButton("Edit your vehicles");
        editVehicles.setBounds((mainFrame.getWidth()-200)/2, addHei+160, 200, 60);
        editVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainEditor me = new MainEditor(collection);
            }
        });

        calc = new JButton("Calculate price of transport");
        calc.setBounds((mainFrame.getWidth()-200)/2, addHei+240, 200, 60);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Calculator cal1 = new Calculator(collection);
            }
        });


        mainFrame.add(calc);
        mainFrame.add(editVehicles);
        mainFrame.add(searchVehicles);
        mainFrame.add(addVehicle);
        mainFrame.add(invitation);
        mainFrame.setVisible(true);

    }

}
