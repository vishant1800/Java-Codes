package ExceptionIntro;

import java.util.Scanner;

class InvalidInputException extends Exception {
    String message;

    public InvalidInputException(String message) {
//        super(message);
        this.message = message;
    }

    //We can override getMessage()
    @Override
    public String getMessage() {
        return message;
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        try {
            checkInt(v);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkInt(int val) throws InvalidInputException {
        if (val < 0) {
            throw new InvalidInputException("Value cannot be negative");
        }
    }
}
