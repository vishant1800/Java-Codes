package com.demo;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        int val = myObj.nextInt();

        if ((val & 1) == 1) {
            System.out.println(val + " is odd");
        } else {
            System.out.println(val + " is even");
        }

    }
}

