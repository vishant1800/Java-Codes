package ExceptionIntro;

import java.util.Scanner;

class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

public class OddException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();

        try {
            checkOdd(num);
        } catch (OddNumberException o) {
            System.out.println(o.getMessage());
        }
    }

    public static void checkOdd(int num) throws OddNumberException {
        if ((num & 1) == 1) {
            throw new OddNumberException("Number is odd");
        } else {
            System.out.println("Number is even");
        }
    }
}
