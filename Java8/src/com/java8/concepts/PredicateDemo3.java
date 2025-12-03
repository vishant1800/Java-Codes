package com.java8.concepts;

import java.util.function.Predicate;

public class PredicateDemo3 {
    public static void main(String[] args) {
        // and()
        Predicate<String> nameInitial = name -> name.toLowerCase().charAt(0) == 'v';
        Predicate<String> nameEnds = name -> name.toLowerCase().endsWith("t");
        Predicate<String> andRes = nameInitial.and(nameEnds);
        System.out.println(andRes.test("Vishant")); // true
        System.out.println(andRes.test("Rishabh")); // false

        // or()
        Predicate<String> orRes = nameInitial.or(nameEnds);
        System.out.println(orRes.test("Nishant")); // true
        System.out.println(orRes.test("Nishank")); // false

        // negate()
        Predicate<String> negateRes = nameInitial.negate();
        System.out.println(negateRes.test("Ravi")); // false -> true

        // isEqual
        Predicate<Object> equalityCheck = Predicate.isEqual(12);
        System.out.println(equalityCheck.test(12));

        Predicate<Object> equalityCheck1 = Predicate.isEqual(12);
        System.out.println(equalityCheck.test(15)); // false

        Predicate<Object> equalityCheck2 = Predicate.isEqual("Venom");
        System.out.println(equalityCheck.test("Spiderman")); // false

    }
}
