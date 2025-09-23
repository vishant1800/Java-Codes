import java.util.Scanner;

class MathOperations {
    public int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public void fibonacci(int num1) {
        int ele1 = 0, ele2 = 1;
        int nextElement = 0;
        for (int i = 0; i < num1; i++) {
            System.out.print(nextElement + " ");

            ele1 = ele2;
            ele2 = nextElement;
            nextElement = ele1 + ele2;
        }
    }

    public void armstrong(int num2) {

        if (num2 <= 0) {
            System.out.println("Enter number greater than 0");
            return;
        }

        int len = String.valueOf(num2).length();

        int origNum = num2;
        int armStrong = 0, rem;

        while (num2 != 0) {
            rem = num2 % 10;
            armStrong += Math.pow(rem, len);
            num2 = num2 / 10;
        }

        if (armStrong == origNum) {
            System.out.println(origNum + " is an Armstrong number");
        } else {
            System.out.println(origNum + " is not an Armstrong Number");
        }
    }

    public void Palindrome(int num) {
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

public class FunctionSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MathOperations math = new MathOperations();
        String ans;

        do {
            System.out.println("Select the option");
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. Armstrong");
            System.out.println("4. Palindrome");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter a number");
                    int num = sc.nextInt();
                    int fact = math.factorial(num);
                    System.out.println("Factorial of " + num + " is " + fact);
                }

                case 2 -> {
                    System.out.println("Enter till where you want to see the fibonacci series");
                    int num1 = sc.nextInt();
                    math.fibonacci(num1);
                    System.out.println();
                }

                case 3 -> {
                    System.out.println("Enter a number");
                    int num2 = sc.nextInt();
                    math.armstrong(num2);
                }

                case 4 -> {
                    System.out.println("Enter a number");
                    int num3 = sc.nextInt();
                    math.Palindrome(num3);
                }

                default -> System.out.println("Invalid case");
            }

            System.out.println("\nDo you wish to continue: Yes or No");
            ans = sc.next();
        } while (ans.equalsIgnoreCase("yes"));
    }
}