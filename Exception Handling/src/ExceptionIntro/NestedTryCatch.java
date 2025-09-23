package ExceptionIntro;

public class NestedTryCatch {
    public static void main(String[] args) {
        try {
            try {
                int c = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

            int[] arr = {1, 2, 3, 4};
            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
