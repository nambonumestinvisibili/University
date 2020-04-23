package com.company;

import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TramForm extends Form {

    JLabel lineLabel, capacityLabel, colourLabel;
    JTextField lineField, capacityField, colourField;
    VehiclesCollection collection;

    TramForm(VehiclesCollection v) {
        collection = v;

        lineLabel = new JLabel("Number of line: ");
        capacityLabel = new JLabel("Number of seats: ");
        colourLabel = new JLabel("Type of colour: ");

        lineField = new JTextField("0");
        capacityField = new JTextField("0");
        colourField = new JTextField("none");

        ArrayList<JLabel> secondListOfLabels = new ArrayList<>();
        secondListOfLabels.add(lineLabel);
        secondListOfLabels.add(capacityLabel);
        secondListOfLabels.add(colourLabel);

        ArrayList<Container> secondListOfFields = new ArrayList<>();
        secondListOfFields.add(lineField);
        secondListOfFields.add(capacityField);
        secondListOfFields.add(colourField);

        int ylabels2  = hybridLabel.getY();
        int i = 1;
        for (JLabel lab: secondListOfLabels) {
            lab.setBounds(xlabels,ylabels2 + 2*i*dylabels, dxlabels, dylabels);
            mainFrame.add(lab);
            i++;

        }
        int j = 1;
        for(Container field : secondListOfFields) {
            field.setBounds(xlabels + dxlabels + 10, ylabels2 +2*j*dylabels, dxlabels, dylabels);
            mainFrame.add(field);
            j++;
        }
        save.setBounds(yesHybrid.getX(), colourLabel.getY()+30, dxlabels, 2*dylabels);
        save.addActionListener(this::actionPerformed);

        mainFrame.add(save);
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String brd = brand.getText();
        String mlg = mileage.getText();
        boolean hib = yesHybrid.isSelected();

        String lin = lineField.getText();
        String cap = capacityField.getText();
        String col = colourField.getText();

        int ml = Integer.parseInt(mlg);
        int linInt = Integer.parseInt(lin);
        int capInt = Integer.parseInt(cap);

        Tram newTram = new Tram(brd, ml, hib, linInt, capInt, col);


        collection.add(newTram);
        mainFrame.dispose();

    }
}
