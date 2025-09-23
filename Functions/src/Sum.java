import java.util.Scanner;

class Demo {
    int pr = 10;

    public int getPr() {
        return pr;
    }
}

public class Sum {
    public static void main(String[] args) {
        int ans = sum();
        System.out.println(ans);

        String str = myGreet();
        System.out.println(str);

        Demo obj = new Demo();
        int res = obj.getPr();
        System.out.println(res);
    }

    static String myGreet() {
        String greeting = "Hello chap";
        return greeting;
    }

    static int sum() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter first number");
        int num1 = in.nextInt();

        System.out.println("Enter second number");
        int num2 = in.nextInt();

        System.out.print("Sum of two numbers is ");
        int res = num1 + num2;
        return res;
    }
}
