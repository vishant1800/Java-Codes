package com.java8.concepts;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        // Function does some operation and return the result
        // Function<InputObject, ResultObject> ex: Function<String, Integer> means giving string and result will come as integer
        // Check Even or Odd
        // 1st way
//        Function<Integer, String> checkNum = num -> {
//            if(num % 2 == 0)
//                return "Even";
//            else
//                return "Odd";
//        };

        //2nd way
        // Using ternary operator
        Function<Integer, String> checkNum2 = num1 -> num1 % 2 == 0 ? "Even" : "Odd";



    }
}


