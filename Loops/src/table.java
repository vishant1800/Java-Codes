import java.util.Scanner;

public class table {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of which you want to print the table");
        int tab = in.nextInt();

        int i = 1;
        while (i <= 10) {
            System.out.println(tab + " * " + i + " = " + tab * i);
            i++;
        }
    }
}
