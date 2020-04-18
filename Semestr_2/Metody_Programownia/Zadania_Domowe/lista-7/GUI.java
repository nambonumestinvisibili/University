package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GUI {
    VehiclesCollection collection;

    GUI(VehiclesCollection veh){
        collection = veh;

        JFrame mainFrame = new JFrame("Vehicles Collection Editor");
        mainFrame.setLayout(null);
        mainFrame.setSize(450, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //collectionOfVehicles = new ArrayList<>();


        String hello = "<html>Welcome to Vehicles Collection Editor!<br/> What do you want to do?</html>";
        int invitLen = 300;
        JLabel invitation = new JLabel(hello, SwingConstants.CENTER);
        invitation.setBounds((mainFrame.getWidth()-invitLen)/2,30,invitLen,100);
        //invitation.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton addVehicle = new JButton("Add a vehicle");
        int addHei = 120;
        addVehicle.setBounds((mainFrame.getWidth()-200)/2, addHei, 200, 60);

        JButton searchVehicles = new JButton("Search your vehicles");
        searchVehicles.setBounds((mainFrame.getWidth()-200)/2, addHei+80, 200, 60);

        JButton editVehicles = new JButton("Edit your vehicles");
        editVehicles.setBounds((mainFrame.getWidth()-200)/2, addHei+160, 200, 60);

        mainFrame.add(editVehicles);
        mainFrame.add(searchVehicles);
        mainFrame.add(addVehicle);
        mainFrame.add(invitation);
        mainFrame.setVisible(true);

    }

}
