public class Main {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        Student s2 = new Student().setValue(33);
        Student s3 = new Student();
        System.out.println(s3.rollNo);
//        System.out.println(s3.rollNo);
//        System.out.println(s1.test);
    }
}

class Student {
    int rollNo = 10;
    String Name;
    int age;

//    public Student setValue(int rollNo) {
//        this.rollNo = rollNo;
//        return this;
//    }
}