import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = "text1.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {

            // Creating new stack with our custom double Queue stack
            Stack stack = new Stack();

            // Reading the file and entering it into the stack line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stack.push(line);
            }

            // Pop the values from the stack and print them
            while (stack.top() != null) {
                System.out.println(stack.top());
                stack.pop();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    /*
    Correct output
    System.out.println("Congratulations... The given HTML file meets all the tag rules.. ");
     */

    /*
    Incorrect output
        System.out.println("Oops... There is a problem..")
        System.out.println(s.ErrorLine());
     */

