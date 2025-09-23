package ExceptionIntro;

public class ExceptionClass {
    public static void main(String[] args) {
        try {
            int c = 10 / 0;
            int[] arr = {1, 2, 3, 4};
            System.out.println(arr[5]);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception class error");
        }
    }
}