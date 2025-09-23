import java.util.Scanner;

public class UserSI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int P, T;
        float R, SI;
        String ans;

        do {
            System.out.println("Enter principal amount");
            P = in.nextInt();
            System.out.println("Enter rate");
            R = in.nextFloat();
            System.out.println("Enter time period");
            T = in.nextInt();

            SI = (P * R * T) / 100;
            System.out.println("Simple Interest is " + SI);
            System.out.println("Do you want to continue calculating the Simple Interest?");
            System.out.println("Write Y for Yes and N for No");

            in.nextLine();
            ans = in.next();
            //ans = in.next().trim.charAt(0); // if 'Y' or 'N' character is used
            // trim method remove the whitespaces and charAt converts to char and extract the char at any given index
        } while (ans.equalsIgnoreCase("Yes"));

        in.close();
    }
}
