
class ObjectCount {
    static int count = 0;

    ObjectCount() {
        objCount();
    }

    public static void objCount() {
        count++;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        ObjectCount obj1 = new ObjectCount();
        ObjectCount obj2 = new ObjectCount();
        ObjectCount obj3 = new ObjectCount();
        ObjectCount obj4 = new ObjectCount();

        System.out.println(ObjectCount.count);
    }
}
