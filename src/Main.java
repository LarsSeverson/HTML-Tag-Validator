import java.io.*;
import java.util.Objects;

public class Main {
    private static final Tester theTest = new Tester();
    private static boolean test;

    public static void main(String[] args) throws IOException {
        String fileName = "text3.txt";
        test = theTest.validation(new BufferedReader(new InputStreamReader(new FileInputStream(fileName))));
        correctOrIncorrect(test);
    }
    private static void correctOrIncorrect(boolean answer){
        if(answer){
            System.out.println("Congratulations... The given HTML file meets all the tag rules.. ");
            System.exit(1);
        }
        System.out.println("Oops... There is a problem..");
        System.out.println("The " + theTest.getStack().top() +
                " tag at line # " + theTest.getIndex() +
                " does not meet the tag rules...");
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

