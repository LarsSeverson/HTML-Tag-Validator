import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Testing with integers

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(4);

        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
    }
}