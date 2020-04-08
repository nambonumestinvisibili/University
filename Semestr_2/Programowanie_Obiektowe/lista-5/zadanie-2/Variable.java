package com.company;

import java.util.HashMap;

public class Variable extends Expression{
    String name;
    int value;

    Variable(String id, HashMap<String, Integer> val) throws NoSuchFieldException {
        name = id;
        if (val.containsKey(id)){
            value = val.get(id);
        }
        else throw new NoSuchFieldException("There's no valuation in hashmap");
    }

    public int evaluate(){
        return value;
    }

    public String toString() { return "(" + name + " = " + value + ")";

    }




}
