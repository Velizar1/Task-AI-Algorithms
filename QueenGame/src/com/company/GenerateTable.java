package com.company;

import java.util.Scanner;

public class GenerateTable {

    public static void main(String[] args) {
        // write your code here

// ...


        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        long start = System.currentTimeMillis();
        Table generateTable=new Table(size);
        generateTable.createTable();

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}
