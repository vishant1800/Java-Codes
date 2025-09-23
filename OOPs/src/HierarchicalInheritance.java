import java.util.Scanner;

class Shape {
    int base, height;

    Shape(int base, int height) {
        this.base = base;
        this.height = height;
    }
}

class Rectangle extends Shape {
    Rectangle(int b, int h) {
        super(b, h);
    }

    public int area() {
        return base * height;
    }
}

class Triangle extends Shape {
    Triangle(int b, int h) {
        super(b, h);
    }

    public float area() {
        return (0.5f * base * height);
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int b = sc.nextInt();
        System.out.print("Enter height: ");
        int h = sc.nextInt();
        Rectangle r = new Rectangle(b, h);
        int rectArea = r.area();
        System.out.println("Area of Rectangle is " + rectArea);

        Triangle t = new Triangle(b, h);
        float triArea = t.area();
        System.out.println("Area of Triangle is " + triArea);
    }
}
