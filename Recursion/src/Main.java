import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = recursiveFact(num);
        System.out.println(num + "!" + " = " + res);
    }

    public static int recursiveFact(int num) {
        if (num == 1 || num == 0) {
            return 1;
        } else {
            return (num * recursiveFact(num - 1));
        }
    }
}