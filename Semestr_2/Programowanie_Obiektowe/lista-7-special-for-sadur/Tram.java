package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Tram extends Vehicle implements Serializable {
    int line;
    int capacity;
    String colour;

    Tram(String brand, int mileage, boolean hybrid, int line, int capacity, String colour){
        this.brand = brand;
        this.mileage = mileage;
        this.hybrid = hybrid;
        this.line = line;
        this.capacity = capacity;
        this.colour = colour;
    }

    Tram(String brand, int mileage, boolean hybrid){
        super(brand, mileage, hybrid);
    }

    public int getLine() {
        return line;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getColour() {
        return colour;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setLine(int line) {
        this.line = line;
    }


    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeUTF(brand);
        stream.writeInt(mileage);
        stream.writeBoolean(hybrid);
        stream.writeInt(line);
        stream.writeInt(capacity);
        stream.writeUTF(colour);

    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        brand = stream.readUTF();
        mileage = stream.readInt();
        hybrid = stream.readBoolean();
        line = stream.readInt();
        capacity = stream.readInt();
        colour = stream.readUTF();
    }

}
