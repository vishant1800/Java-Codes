public class EvenSum {
    public static void main(String[] args) {

        int sum = 0, count = 0;
        int val;
        for (val = 0; count < 10; val++) {
            while ((val & 1) == 0) {
                sum += val;
                count++;
                break;
            }
        }
        System.out.println("The sum of 10 even numbers is " + sum);
    }
}
