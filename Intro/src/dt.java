
class DataTypesDemo {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // toString() method to display object info
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        // Primitive Data Types
        byte b = 100;
        short s = 32000;
        int i = 100000;
        long l = 10000000000L;

        float f = 3.14f;
        double d = 99.9999;

        char c = 'A';
        boolean flag = true;

        // Non-Primitive Data Types
        String str = "Hello, Java!";
        Person person = new Person("Vishant", 24); // object of Person class

        // Printing values
        System.out.println("=== Primitive Data Types ===");
        System.out.println("Byte value: " + b);
        System.out.println("Short value: " + s);
        System.out.println("Int value: " + i);
        System.out.println("Long value: " + l);
        System.out.println("Float value: " + f);
        System.out.println("Double value: " + d);
        System.out.println("Char value: " + c);
        System.out.println("Boolean value: " + flag);

        System.out.println("\n=== Non-Primitive Data Types ===");
        System.out.println("String value: " + str);
        System.out.println("Object value: " + person); // calls toString()
    }
}
