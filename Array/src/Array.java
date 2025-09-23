import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5};

//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
        array();
    }

    public static void array() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.asList(1, 2));
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
    }
}
