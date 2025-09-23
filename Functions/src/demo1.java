import java.util.Scanner;

class Display {
    public void show() {
        System.out.println("This is a show function");
    }
}

class Area {
    public double circle(double r) {
        return Math.PI * r * r;
    }

    public int square(int s) {
        return 4 * s;
    }

    public int rectangle(int l, int b) {
        return l * b;
    }

}

public class demo1 {
    public static void main(String[] args) {
//        Display obj = new Display();
//        obj.show();
        Scanner sc = new Scanner(System.in);

        Area obj1 = new Area();

        System.out.print("Enter radius of a circle: ");
        double radius = sc.nextDouble();
        System.out.println("Area of circle is " + obj1.circle(radius));

        System.out.print("\nEnter side of a square: ");
        int side = sc.nextInt();
        System.out.println("Area of square is " + obj1.square(side));

        System.out.print("\nEnter length of rectangle: ");
        int length = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int breadth = sc.nextInt();
        System.out.println("Area of rectangle is " + obj1.rectangle(length, breadth));
    }
}
