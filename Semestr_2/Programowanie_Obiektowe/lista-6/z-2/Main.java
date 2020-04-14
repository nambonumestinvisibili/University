package com.company;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Integer[] t1 = {10, 11, 12, 13, 14, 15};
        Integer[] t2 = {13, 14, 15};
        ArrayList<Integer> n1 = new ArrayList<Integer>(Arrays.asList(t1));
        ArrayList<Integer> n2 = new ArrayList<Integer>(Arrays.asList(t2));

        List<Integer> m1 = new List<>();
        List<Integer> m2 = new List<>();
        m1.addAll(n1);
        m2.addAll(n2);

        System.out.println("Implemented iterator:");
        System.out.print("[");
        for(int every : m1){
            System.out.print(every + ", ");
        };
        System.out.println("\b\b]");

        System.out.println("Implemented toString:");
        System.out.println(m2);

        System.out.println("Does m1 contain 10?" + m1.contains(10));

        System.out.println("Use of addAll: " + m1.addAll(m2));
        System.out.println(m1);
        System.out.println("Use of removeAll: " + m1.removeAll(m2));
        System.out.println(m1);
        Integer[] tab1 = {11,12};
        ArrayList<Integer> tab = new ArrayList<Integer>(Arrays.asList(tab1));
        System.out.println("Use of retainAll: " + m1.retainAll(tab));
        System.out.println(m1);
        System.out.println("Does m1 contain all elements of tab? " + m1.containsAll(tab));
        m2.clear();
        m1.add(20);
        m1.remove(10);
        System.out.println("m2 after clear()");
        System.out.println(m2);
        System.out.println("m1 after + 20 - 10: ");
        System.out.println(m1);
        m1.toArray();
        System.out.println("m1 to array:");
        m1.stream().forEach(e -> System.out.println(e + ", "));












    }
}
