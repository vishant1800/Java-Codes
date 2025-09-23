package com.demo;

import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        int value = myObj.nextInt();

        if (value > 0) {
            System.out.println("Given number is a positive number");
        } else if (value < 0) {
            System.out.println("Given number is a negative number");
        } else
            System.out.println("Given number is zero");
    }
}
