package com.company;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {

        HashMap<String, Integer> values = new HashMap<String, Integer>();
        values.put("X", 4);
        values.put("Y", 2);

        //constructing ((10X) + 1)/ Y
        Expression e1 = new Variable("X", values);
        Expression e2 = new Numbers(5);
        Expression e3 = new Operations("*", e1, e2);
        Expression e4 = new Numbers(4);
        Expression e5 = new Operations("+", e3, e4);
        Expression e6 = new Variable("Y", values);
        Expression e7 = new Operations("/", e5, e6);

        System.out.println("Expression looks like: ");
        System.out.println(e7);
        System.out.println("Evaluation of the expression: " + e7.evaluate());



    }
}
