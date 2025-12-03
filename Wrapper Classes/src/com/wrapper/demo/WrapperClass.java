package com.wrapper.demo;

public class WrapperClass {

    public static void main(String[] args) {

        Integer val = Integer.valueOf(12);
        // OR
        Integer val1 = 15; //Auto Boxing

        //To check the type of the reference variable
        System.out.println(val.getClass().getName());
        // OR
        System.out.println(val instanceof Integer); //true
        System.out.println(val1);

        int a = Integer.valueOf(18); //Unboxing
        // OR
        int b = val; // Unboxing

        //we cannot directly check the type of primitive variables and to do so we need to convert it to the
        System.out.println(a);
        Integer num = a;

        System.out.println(num.getClass().getName());
        System.out.println(b);

        // Autoboxing on float and boolean
        Float fObj = Float.valueOf("12"); //valueOf also converts automatically String to Float
        Boolean y = Boolean.valueOf("false"); // Auto Boxing -> string to boolean
        System.out.println(fObj);
        System.out.println(y);
    }
}
