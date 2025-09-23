import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number");
        int num = in.nextInt();

        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("It is a prime number");
        } else {
            System.out.println("It is not a prime number");
        }
    }
}
