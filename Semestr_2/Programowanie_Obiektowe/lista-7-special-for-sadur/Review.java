package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Review {

    JFrame mainFrame;
    JTabbedPane mainPanel;
    VehiclesCollection collection;


    Review(VehiclesCollection v){
        collection = v;
        mainFrame = new JFrame();
        mainPanel = new JTabbedPane();

        int size = collection.size();

        JPanel[] panelArray = new JPanel[size];
        //--------------------------------------------------------------------------------
        JLabel[] listOfLabels = new JLabel[size*6];

        int panelWidth = 250;
        int j = 0;
        int xCor = (mainFrame.getWidth()-panelWidth)/2;
        int yCor = (mainFrame.getHeight()-panelWidth)/2;
        int dx = 100;
        int dy = 20;

        for (int i = 0; i < size; i++){
            int k = 10;
            listOfLabels[j] = new JLabel("Brand: " + collection.get(i).getBrand());
            listOfLabels[j++].setBounds(xCor+10, yCor+10, dx, dy);
            k += 10;
            listOfLabels[j] = new JLabel("| Milleage: " + collection.get(i).getMileage());
            listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
            k += 10;
            listOfLabels[j] = new JLabel("| Hybrid? " + collection.get(i).isHybrid());
            listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
            k += 10;

            if (collection.get(i) instanceof Car){
                listOfLabels[j] = new JLabel("| Type of Fuel: " + ((Car) collection.get(i)).getFuel());
                listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
                k += 10;
                listOfLabels[j] = new JLabel("| Average Speed: " + ((Car) collection.get(i)).getAverageVelocity());
                listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
                k += 10;
                listOfLabels[j] = new JLabel("| Burning: " + ((Car) collection.get(i)).getBurning());
                listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
                k += 10;
            }
            else if (collection.get(i) instanceof Tram){
                listOfLabels[j] = new JLabel("| Capacity: " + ((Tram) collection.get(i)).getCapacity());
                listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);

                k += 10;
                listOfLabels[j] = new JLabel("| Colour: " + ((Tram) collection.get(i)).getColour());
                listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
                k += 10;
                listOfLabels[j] = new JLabel("| Line number: " + ((Tram) collection.get(i)).getLine());
                listOfLabels[j++].setBounds(xCor+10, yCor+10+k, dx, dy);
                k += 10;
            }
            //panelArray[i].add()
        }


        for (int i = 0; i < size; i++){
            panelArray[i] = new JPanel();
            mainPanel.add(collection.get(i).getBrand(), panelArray[i]);
        }


        for (int i = 0; i < size*6; i++) {
            panelArray[i / 6].add(listOfLabels[i]);
        }



        //------------------------------------------------------------------------------


        mainFrame.setSize(400, 400);

        mainPanel.setBounds((mainFrame.getWidth()-panelWidth)/2, (mainFrame.getHeight()-panelWidth)/3, panelWidth, panelWidth);

        mainFrame.add(mainPanel);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);




    }

}
