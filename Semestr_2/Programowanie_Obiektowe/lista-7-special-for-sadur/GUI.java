package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class GUI {
    VehiclesCollection collection;
    JButton calc;
    String hello = "<html>Welcome to Vehicles Collection Editor!<br/> What do you want to do?</html>";

    JFrame mainFrame;
    JLabel invitation;
    JButton addVehicle;
    JButton searchVehicles;
    JButton editVehicles;
    JButton override;
    JButton saveToAnotherFile;
    JButton getFromAnotherFile;


    GUI(VehiclesCollection veh){
        collection = veh;


        mainFrame = new JFrame("Vehicles Collection Editor");
        mainFrame.setLayout(null);
        mainFrame.setSize(450, 660);
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

        override = new JButton("Override input collection");
        override.setBounds((mainFrame.getWidth()-200)/2, addHei+320, 200, 60);
        override.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    ArrayList<Vehicle> aux = collection.getWholeCollection();

                    FileOutputStream fop = new FileOutputStream("VehicleData.ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fop);
                    oos.writeObject(aux);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        saveToAnotherFile = new JButton("Save to another file");
        saveToAnotherFile.setBounds((mainFrame.getWidth()-200)/2, addHei+400, 200, 30);
        saveToAnotherFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFileChooser fc=new JFileChooser();
                int i=fc.showOpenDialog(mainFrame);

                    if(i==JFileChooser.APPROVE_OPTION) {
                        File f = fc.getSelectedFile();
                        String filepath = f.getPath();

                        try{
                            ArrayList<Vehicle> aux = collection.getWholeCollection();

                            FileOutputStream fop = new FileOutputStream(filepath);
                            ObjectOutputStream oos = new ObjectOutputStream(fop);
                            oos.writeObject(aux);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }




            }
        });

        getFromAnotherFile = new JButton("Get collection from another file");
        getFromAnotherFile.setBounds((mainFrame.getWidth()-200)/2, addHei+440, 200, 30);
        getFromAnotherFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc=new JFileChooser();
                int i=fc.showOpenDialog(mainFrame);

                if(i==JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    String filepath = f.getPath();

                    try {
                        FileInputStream fis = new FileInputStream(filepath);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        ArrayList<Vehicle> arrV = new ArrayList<>();
                        arrV = (ArrayList<Vehicle>) ois.readObject();


//                        VehiclesCollection v = new VehiclesCollection();
//
//                        for (int i = 0; i < arrV.size(); i++){
//                            v.add(arrV.get(i));
//                        }

                        collection.override(arrV);

                    } catch (ClassNotFoundException | FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }
        });

        mainFrame.add(getFromAnotherFile);
        mainFrame.add(saveToAnotherFile);
        mainFrame.add(override);
        mainFrame.add(calc);
        mainFrame.add(editVehicles);
        mainFrame.add(searchVehicles);
        mainFrame.add(addVehicle);
        mainFrame.add(invitation);
        mainFrame.setVisible(true);



    }

}
