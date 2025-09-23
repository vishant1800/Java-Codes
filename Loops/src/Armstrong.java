
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        if (num <= 0) {
            System.out.println("Enter number greater than 0");
            return;
        }

        int len = String.valueOf(num).length();

        int origNum = num;
        int armStrong = 0, rem;
        while (num != 0) {
            rem = num % 10;
            armStrong += Math.pow(rem, len);
            num = num / 10;
        }

        if (armStrong == origNum) {
            System.out.println(origNum + " is an Armstrong number");
        } else {
            System.out.println(origNum + " is not an Armstrong Number");
        }
    }

}
