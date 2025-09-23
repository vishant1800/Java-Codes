interface Coder {
    void writeCode();

    static void disp() {
        System.out.println("Static method from Coder Interface");
    }
}

interface Tester {
    void testCode();
}

class DevOpsEngineer implements Coder, Tester {
    @Override
    public void writeCode() {
        System.out.println("From Coder interface");
    }

    @Override
    public void testCode() {
        System.out.println("From Tester interface");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        DevOpsEngineer d = new DevOpsEngineer();
        d.writeCode();
        d.testCode();
        Coder.disp();

    }
}
