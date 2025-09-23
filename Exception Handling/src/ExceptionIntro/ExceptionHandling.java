package ExceptionIntro;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int c = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block will always executed");
        }
    }
}
