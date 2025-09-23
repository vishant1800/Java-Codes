import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter till where you want to see the fibonacci series");
        int num = in.nextInt();

        int ele1 = 0, ele2 = 1;
        int nextElement = 0;
        for (int i = 0; i < num; i++) {
            System.out.println(nextElement);

            ele1 = ele2;
            ele2 = nextElement;
            nextElement = ele1 + ele2;
        }
    }
}
