package com.java8.streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {
    public static void main(String[] args) {
//        Collectors is a utility class
//        provides a set of methods to create common collectors
//        Collectors are used with the collect() terminal operation to convert streams into:
//
//        Lists
//        Sets
//        Maps
//        Strings
//        Groups (like SQL GROUP BY)
//        Partitions
//        Statistical summaries

        // 1. Collecting to a list
        System.out.println("Collecting to list");
        List<Integer> lList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collectList = lList.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collectList);

        // 2. Collecting to a set
        System.out.println("\nCollecting to a Set");
        List<Integer> sList = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2);
        Set<Integer> collectSet = sList.stream()
                .collect(Collectors.toSet());
        System.out.println(collectSet);

        // 3. Collecting to a specific Collection
        System.out.println("\nCollecting to a specific Collection");
        LinkedHashSet<Integer> cCollect = lList.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(cCollect);

        // 4. Joining Strings - Concatenates stream elements into a single String
        System.out.println("\nJoining Strings");
        List<String> names = Arrays.asList("Ajay", "Atul", "Vijay", "Pankaj");
        System.out.println(names.stream().collect(Collectors.joining("-"))); // Output - Ajay-Atul-Vijay-Pankaj

        // 5. Summarizing Data
//        Gives count, sum, average, min, max in one shot. Generates statistical summary
        System.out.println("\nSummarizing Data");

        IntSummaryStatistics summaryCollect = lList.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Max: " + summaryCollect.getMax());
        System.out.println("Average: " + summaryCollect.getAverage());
        System.out.println("Count: " + summaryCollect.getCount());
        System.out.println("Min: " + summaryCollect.getMin());
        System.out.println("Sum: " + summaryCollect.getSum());
        // getClass and getName can be performed with any object
        System.out.println("Class: " + summaryCollect.getClass().getName());

        // 6. Calculate Average
        System.out.println("\nCalculate Average");
        Double avg = lList.stream().collect(Collectors.averagingDouble(x -> x));
        System.out.println("Average: " + avg);

        // 7. Counting Elements
        System.out.println("\nCount Elements");
        Long count = lList.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // 8. GroupingBy = SQL GROUP BY in Java
        System.out.println("\nGroupingBy");
        List<String> words = Arrays.asList("hello", "java", "streams", "collecting", "groupingBy");
        // 1st way or signature
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length))); //grouping based on length
        // Output - {4=[java], 5=[hello], 7=[streams], 10=[collecting, groupingBy]}
        // 2nd way
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining("-"))));
        // Output - {4=java, 5=hello, 7=streams, 10=collecting-groupingBy}
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting())));
        // Output - {4=1, 5=1, 7=1, 10=2}

        // 3rd way - converting it to any other map
        TreeMap<Integer, Long> treeMap = words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap); // Output - {4=1, 5=1, 7=1, 10=2}

        // Example-1
        System.out.println("\nGrouping numbers by even/odd");
        Map<String, List<Integer>> evenOrOddCollect = lList.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println(evenOrOddCollect);

        // Example - 2
        System.out.println("\nGroup employees by department");
        Map<String, List<Employee>> deptMap= EmployeeMain.allEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept)); //output - {HR=[Employee{id=2, name='Ajay', dept='HR'}, Employee{id=3, name='Vijay', dept='HR'}], IT=[Employee{id=1, name='Vishant', dept='IT'}, Employee{id=4, name='Manish', dept='IT'}, Employee{id=5, name='Ashley', dept='IT'}]}

        // if you just want employee name instead of all details of employees, then
        Map<String, List<String>> deptMap1 = EmployeeMain.allEmployees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                )); // Output: {HR=[Ajay, Vijay], IT=[Vishant, Manish, Ashley]}

        // with names in sorted order
        Map<String, List<String>> deptMap2 = EmployeeMain.allEmployees().stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.collectingAndThen(Collectors.toList(),
                                                list -> {
                                                    Collections.sort(list);
                                                    return list;
                                                }
                                        ))
                        ));

        Map<String, Long> countByDept = EmployeeMain.allEmployees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.mapping(Employee::getName, Collectors.counting())
                ));
        System.out.println(deptMap);
        System.out.println(deptMap1);
        System.out.println(deptMap2);
        System.out.println(countByDept);

        // Example - 3
        System.out.println("\nConverting List to size automatically");
        int size = lList.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        List::size
                ));
        System.out.println(size);

        System.out.println("\nWrite code to group employees by dept but store only uppercase names.");
//        Map<String, List<String>> groupEmpNames = EmployeeMain.allEmployees().stream()
//                .collect(Collectors.groupingBy(Employee::getDept,
//                        Collectors.mapping(Employee::getName,
//                                Collectors.collectingAndThen(Collectors.toList(),
//                                        list -> list.stream().map(String::toUpperCase).toList()
//                                        ))));
        // simpler version by just mapping
        Map<String, List<String>> groupEmpNames2 = EmployeeMain.allEmployees().stream()
                        .collect(Collectors.groupingBy(Employee::getDept,
                                Collectors.mapping(
                                        emp -> emp.getName().toUpperCase(),
                                        Collectors.toList()
                                )));
        System.out.println(groupEmpNames2);

        System.out.println("\nWrite code to get an unmodifiable list of employee names.");
        List<String> namesList = EmployeeMain.allEmployees().stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                Collections::unmodifiableList));
        System.out.println(namesList);

        System.out.println("\nWrite code to group employees by dept and get size of each dept (using collectingAndThen).");
        Map<String, Integer> deptSize = EmployeeMain.allEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                List::size // (lambda expression converted to method reference)
                        )));

        System.out.println(deptSize);

        // 9. PartitionBy
        // Partitions elements into two groups (true and false) based on a predicate
        System.out.println("\n PartitionBy()");
        Map<Boolean, List<String>> lengthGreaterThan5 = names.stream()
                .collect(Collectors.partitioningBy(x -> x.length() >= 5));
        System.out.println(lengthGreaterThan5);  // {false=[Ajay, Atul], true=[Vijay, Pankaj]}

        // 2nd version
        // with predicate and downstream collector(used to perform aggregate functions)
        Map<Boolean, Long> countNames = names.stream()
                .collect(Collectors.partitioningBy(x -> x.length() >= 5, Collectors.counting()));

        // 10. Mapping and Collecting
        // Applies a mapping function before collecting
        // Used inside groupingBy to transform values.

        List<String> collect = words.stream()
                .collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(collect);

        //Example-2
        System.out.println("\ngroup by dept and get only names");
        Map<String, List<String>> groupDeptAndGetNames =EmployeeMain.allEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.mapping(Employee::getName,
                                Collectors.toList())));
        System.out.println(groupDeptAndGetNames);

        // 10. toMap - Used to collect data into a Map.
        System.out.println("\ntoMap()");
        Map<Integer, String> toMap = EmployeeMain.allEmployees().stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(toMap);

        // Practice Questions
        System.out.println("\nPractice Questions");
        System.out.println("1. Collecting names by length");
        List<String> pNames = Arrays.asList("Anna", "Bob", "Alexandar", "Brian", "Alice");
        System.out.println(pNames.stream().collect(Collectors.groupingBy(String::length)));

        System.out.println("\n2. Counting Word Occurences");
        String sentence = "How much wood, wood a wood chuck if a wood chuck could chuck wood";
        // first we have to convert string to stream
        // sentence.split(" ") will give me array
        Map<String, Long> wordOccur = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(wordOccur);

        System.out.println("\n3. Partitioning Even and Odd Numbers");
        System.out.println(lList.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0)));

        System.out.println("\n4. Summing values in a map");
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Guava", 30);
        System.out.println(items.values().stream().reduce(Integer::sum).get()); // (x,y) -> x + y can be replaced with Integer::sum
        // 2nd way
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));
        // OR
        System.out.println((Integer) items.values().stream().mapToInt(x -> x).sum());
        // we don't need to do anything on every value but if i do x -> x + 2 then 2 will be added on each value

        System.out.println("\n5. Creating a Map from Stream Elements");
        List<String> fruits = Arrays.asList("Apple", "Banana", "Guava");
        System.out.println(fruits.stream()
                .collect(Collectors.toMap(x -> x, x -> x.length())));

        System.out.println("\n6 Creating map if ids are repeated");
        List<String> fruits2 = Arrays.asList("apple", "banana", "orange", "banana", "orange", "apple", "orange", "guava");
        // toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)
        // mergeFunction(a BinaryOperator) defines how to combine two values associated with the same key.
        // (oldValue, newValue) -> oldValue or anything you can perform
        // mapSupplier - it is used to specify which kind of map you want to use LinkedHashMap, TreeMap or any other.
        System.out.println(fruits2.stream()
                .collect(Collectors.toMap(x -> x,
                        v -> 1, // v is set to 1 because it is initial value of v
                        // as the key repeats v changes because of mergeFunction
                        (x, y) -> x + y)));

    }
}
