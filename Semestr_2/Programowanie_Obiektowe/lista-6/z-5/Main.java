package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] tab = {10, 2, 11, 5, 3, 1, 90, 0, 45, 77};

        MergeSort sort = new MergeSort(tab);
        sort.start();

        try { sort.join(); }
        catch(Exception except) {}

        System.out.print("[");
        Arrays.stream(tab).forEach(e -> System.out.print(e + ", "));
        System.out.println("\b\b]");

    }


}

