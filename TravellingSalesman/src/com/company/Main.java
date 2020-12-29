package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter number of cities: ");
        GenericAlgorithm genericAlgorithm=new GenericAlgorithm(new Scanner(System.in).nextInt());
        genericAlgorithm.createGeneration();
    }
}
