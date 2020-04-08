package com.company;

public class Numbers extends Expression {
    int value;

    public Numbers(int val){
        this.value = val;
    }

    public int evaluate(){
        return value;
    }

    public String toString(){
        String result = "(Constant = " + value + ")";
        return result;
    }
}
