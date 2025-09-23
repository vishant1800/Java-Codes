public class print {
    public static void main(String[] args) {
        // Using println() - adds a newline after printing
        System.out.println("=== Using println() ===");
        System.out.println("String: Hello, World!");
        System.out.println("Integer: " + 42);
        System.out.println("Double: " + 3.14159);
        System.out.println("Boolean: " + true);
        System.out.println("Character: " + 'A');
        System.out.println("Char Array: ");
        System.out.println(new char[]{'1', 'a', 'v', 'a'});

        // Using print() - does NOT add a newline
        System.out.println("\n=== Using print() ===");
        System.out.print("This ");
        System.out.print("is ");
        System.out.print("on ");
        System.out.print("one ");
        System.out.print("line.");
        System.out.println();  // move to next line

        // Using printf() - formatted printing
        System.out.println("\n=== Using printf() ===");
        int age = 24;
        double marks = 87.456;
        System.out.printf("Age: %d years\n", age);
        System.out.printf("Marks: %.2f out of 100\n", marks);
    }
}
