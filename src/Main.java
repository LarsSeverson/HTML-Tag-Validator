import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        Queue q = new Queue();
        q.enqueue(10);
        System.out.println("Q: " + q.front.key);
    }
}