public class Exit {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.exit(1);
            }
            System.out.println(i);
        }
    }
}
