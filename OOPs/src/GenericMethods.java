import java.lang.Number;

public class GenericMethods {
    public static void main(String[] args) {
        printData(123);
        printData("Hello");

        GenericMethods obj = new GenericMethods();
        obj.sampleData(123);

    }

    static <E> void printData(E data) { // After using generic methods now we do not need to do method overloading
        System.out.println("Data: " + data);
    }

    //Bounded Generic Types
    // If you want Generic Methods to accept only particular type of data then we can use bounded generic types
    // Now sampleData will only accept number
    <E extends Number> void sampleData(E data) {
        System.out.println("Sample Data: " + data);
    }
}
