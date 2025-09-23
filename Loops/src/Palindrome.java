import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number");
        int num = in.nextInt();

        int origNum = num;
        int rem, rev = 0;

        for (; num != 0; num /= 10) {
            rem = num % 10;
            rev = rev * 10 + rem;
        }

        if (rev == origNum) {
            System.out.println(origNum + " is a palindrome");
        } else {
            System.out.println(origNum + " is not a palindrome");
        }
    }
}
