package com.collection.learn;

import java.util.HashMap;
import java.util.Map;

public class LearnHashMap {
    public static void main(String[] args) {
        //hashmap stores in key, value pair
        Map<Integer, String> mpp = new HashMap<>();

        mpp.put(1, "US");
        mpp.put(2, "India");
        mpp.put(3, "China");
        mpp.put(4, "Russia");

//        mpp.put(3, "China"); // doesn't store duplicate keys

        System.out.println(mpp);

        if (!mpp.containsKey("China")) { // if China is not present then it will add China in mpp
            mpp.put(3, "China");
        }
        // or there is a built-in method
        mpp.putIfAbsent(3, "China");
        System.out.println("get method" + mpp.get(1));

        System.out.println(mpp);

        // Iterate over Hashmap
        for (Map.Entry<Integer, String> e : mpp.entrySet()) {
            System.out.println(e);
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
        }
    }
}
