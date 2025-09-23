
class Person {
    int age;
    String firstName;
    String lastName;

    Person() {
        age = 18;
        firstName = "abc";
        lastName = "xyz";
    }

    Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(Person p) {
        this.age = p.age;
        this.firstName = p.firstName;
        this.lastName = p.lastName;
    }

    public void getData() {
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
    }
}

public class Constructor {
    public static void main(String[] args) {

        Person p1 = new Person();
        System.out.println("Default Constructor Called");
        p1.getData();

        Person p2 = new Person(27, "Rahul", "Kapoor");
        System.out.println("\nParameterised Constructor called");
        p2.getData();

        Person p3 = new Person(p2);
        System.out.println("\nCopy constructor called");
        p3.getData();
    }
}
