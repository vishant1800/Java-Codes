package com.demo;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter principal amount");
        int P = in.nextInt();
        System.out.println("Enter rate");
        float R = in.nextFloat();
        System.out.println("Enter time period");
        int T = in.nextInt();

        float SI = (P * R * T) / 100;
        System.out.println("Simple Interest is " + SI);
    }
}
