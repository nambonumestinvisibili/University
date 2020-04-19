package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Form {
    JFrame mainFrame;
    JLabel instructions;
    JLabel brandLabel;
    JLabel mileageLabel;
    JLabel hybridLabel;
    JTextField brand, mileage;
    JRadioButton yesHybrid;
    JRadioButton noHybrid;
    JButton save;

    final int xlabels = 10;
    final int ylabels2 = 30;
    final int dxlabels = 100;
    final int dylabels = 15;

    Form(){
        ArrayList<JLabel> listOfLabels;
        ArrayList<JTextField> listOfFields;

        //initializing
        mainFrame = new JFrame();
        instructions = new JLabel("Fill in the form");
        brandLabel = new JLabel("Brand");
        mileageLabel = new JLabel("Mileage:");
        hybridLabel = new JLabel("is Hybrid?");

        brand = new JTextField("undefinced");
        mileage = new JTextField("0");

        yesHybrid = new JRadioButton("yes");
        noHybrid = new JRadioButton("no");

        save = new JButton("save");

        listOfLabels = new ArrayList<>();
        listOfLabels.add(instructions);
        listOfLabels.add(brandLabel);
        listOfLabels.add(mileageLabel);
        listOfLabels.add(hybridLabel);

        listOfFields = new ArrayList<>();
        listOfFields.add(brand);
        listOfFields.add(mileage);


        //placing
        int i = 0;
        for(JLabel lab : listOfLabels){
            lab.setBounds(xlabels, ylabels2 +2*i*dylabels, dxlabels, dylabels);
            mainFrame.add(lab);
            i++;
        }

        int j = 1;
        for(JTextField field : listOfFields){
            field.setBounds(xlabels + dxlabels + 10, ylabels2 +2*j*dylabels, dxlabels, dylabels);
            mainFrame.add(field);
            j++;
        }

        yesHybrid.setBounds(xlabels+dxlabels+10, ylabels2 +2*j*dylabels, dxlabels/2, dylabels);
        noHybrid.setBounds(xlabels+dxlabels+10+dxlabels/2, ylabels2 +dylabels*2*j, dxlabels/2, dylabels);
        mainFrame.add(yesHybrid);
        mainFrame.add(noHybrid);

        ButtonGroup gruop = new ButtonGroup();
        gruop.add(yesHybrid);
        gruop.add(noHybrid);

        mainFrame.setSize(250, 350);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);


    }

}
