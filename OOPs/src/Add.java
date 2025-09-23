import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        Number n1 = new Number();
        n1.setData(num1, num2);
        n1.getData();
        n1.sum();
        n1.swap();

        System.out.println("\nNumber after swapping");
        n1.getData();
    }
}

class Number {
    int num1;
    int num2;

    public void setData(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void getData() {
        System.out.println("First number = " + num1);
        System.out.println("Second number = " + num2);
    }

    public void sum() {
        System.out.println("Sum of two numbers is " + (num1 + num2));
    }

    public void swap() {
        int num3 = num1;
        num1 = num2;
        num2 = num3;
    }
}