import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = 1;
        while (i <= 5) {
            System.out.println("Enter principal amount");
            int P = in.nextInt();
            System.out.println("Enter rate");
            float R = in.nextFloat();
            System.out.println("Enter time period");
            int T = in.nextInt();

            float SI = (P * R * T) / 100;
            System.out.println("Simple Interest for customer " + i + " is " + SI);
            i++;
        }
    }
}
