abstract class ShapeA {
    int r;

    ShapeA(int r) {
        this.r = r;
    }

    abstract void getArea();

    public void disp() {
        System.out.println("ShapeA display");
    }
}

class Circle extends ShapeA {
    Circle(int a) {
        super(a);
    }

    @Override
    void getArea() {
        System.out.println(Math.PI * r * r);
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        c.getArea();
        c.disp();
    }
}
