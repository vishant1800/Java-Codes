package ExceptionIntro;

public class SingleCatchMultipleException {
    public static void main(String[] args) {
        try {
            int c = 10 / 0;
            int[] arr = {1, 2, 3, 4};
            System.out.println(arr[5]);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception can be ArithmeticException or ArrayIndexOutOfBoundsException");
        }
    }
}
