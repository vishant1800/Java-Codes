// Base class
class Person1 {
    void displayInfo() {
        System.out.println("I am a person.");
    }
}

class Teacher extends Person1 {
    void teach() {
        System.out.println("I teach students.");
    }
}

class Student1 extends Person1 {
    void study() {
        System.out.println("I study subjects.");
    }
}

class HeadTeacher extends Teacher {
    void manageSchool() {
        System.out.println("I manage the school.");
    }
}

// Main class to test
public class HybridInheritance {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        Teacher tr = new Teacher();
        HeadTeacher ht = new HeadTeacher();
        ht.displayInfo();
        ht.teach();
        ht.manageSchool();

        Student1 st = new Student1();
        st.study();

        System.out.println(ht instanceof Teacher);
        System.out.println(ht instanceof Person1);
        System.out.println(st instanceof Person1);
//        System.out.println(ht instanceof Student1); //this will throw error
    }
}
