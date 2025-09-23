import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
        animals.push("Dog");
        animals.push("Lion");
        animals.push("Racoon");
        animals.push("Elephant");

        System.out.println("Stack: " + animals);

        System.out.println(animals.peek()); //top element in the stack

        animals.pop();

        System.out.println(animals.peek());
    }
}
