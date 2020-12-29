package com.company;

import java.util.Scanner;

public class Main {
    static double getValue(Double dob1,Double dob2,Double dob3){
       return Double.parseDouble(String.format("%.3f",dob1/(dob1+dob2+dob3)).replace(",","."));
    }

    public static void main(String[] args) {
        SetGenerator setGenerator=new SetGenerator();
        setGenerator.generateNSets();
        setGenerator.printList();
        while(true) {
            System.out.println("Enter attribute:");
            Scanner scanner = new Scanner(System.in);
            Attribute attribute = new Attribute(null, scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean(), scanner.nextBoolean());
            System.out.println(setGenerator.classification(attribute,0));
            //System.out.println(getValue(2.0,4.0,13.0));
        }
    }
}
