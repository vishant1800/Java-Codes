package ExceptionIntro;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class ThrowAndThrows {
    public static void main(String[] args) {
        try {
            checkValue(0);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkValue(int val) throws MyException {
        if (val == 0) {
            throw new MyException("Value cannot be zero");
        }
    }
}
