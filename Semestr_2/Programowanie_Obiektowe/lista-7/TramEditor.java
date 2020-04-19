package com.company;

import java.awt.event.ActionEvent;

public class TramEditor extends TramForm {

    int editTramIndex;

    TramEditor(VehiclesCollection v1, int index){
        super(v1);
        editTramIndex = index;
    }

    @Override
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

        if(collection.get(editTramIndex) instanceof Tram){
            collection.get(editTramIndex).setBrand(brd);
            collection.get(editTramIndex).setMileage(ml);
            collection.get(editTramIndex).setHybrid(hib);
            ((Tram) collection.get(editTramIndex)).setLine(linInt);
            ((Tram) collection.get(editTramIndex)).setColour(col);
            ((Tram) collection.get(editTramIndex)).setCapacity(capInt);
        }

        mainFrame.dispose();

    }
}
