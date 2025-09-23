
import java.util.Scanner;

public class Armstrong2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter starting range");
        int start = in.nextInt();
        System.out.println("Enter ending range");
        int end = in.nextInt();
        if (start <= 0 && end <= 0) {
            System.out.println("Enter number greater than 0");
            return;
        }

        int len, origNum, armStrong = 0, rem;
        int count = 0;
        for (int i = start; i <= end; i++) {
            len = String.valueOf(i).length();

            origNum = i;
            armStrong = 0;
            while (origNum != 0) {
                rem = origNum % 10;
                armStrong += Math.pow(rem, len);
                origNum = origNum / 10;
            }
            if (armStrong == i) {
                System.out.println(i);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("None");
        }

    }

}
