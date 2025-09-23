package com.demo;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);

        System.out.println("Enter your percentage");
        float percent = Obj.nextFloat();

        if (percent > 80.00) {
            System.out.println("Grade A");
        } else if (percent > 60 && percent <= 80) {
            System.out.println("Grade B");
        } else if (percent > 40 && percent <= 60) {
            System.out.println("Grade C");
        } else if (percent > 20 && percent <= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade E");
        }
    }

    
}
