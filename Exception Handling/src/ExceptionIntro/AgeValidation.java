package ExceptionIntro;

import java.util.Scanner;

public class AgeValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age - ");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be greater than 0 and less than 150");
        }
    }
}
