
class Calculation { //Base or Super or Parent class

    public int Addition(int x, int y) {
        return x + y;
    }

    public int Subtraction(int x, int y) {
        return x + y;
    }
}

class Calculation2 extends Calculation {
    public int Multiplication(int x, int y) {
        return x * y;
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        //Single Inheritance
        Calculation2 cal = new Calculation2();
        int res = cal.Addition(2, 5);
        System.out.println("Sum is " + res);

        int res1 = cal.Subtraction(2, 5);
        System.out.println("Sum is " + res1);

        int res2 = cal.Multiplication(2, 5);
        System.out.println("Sum is " + res2);
    }
}
