import java.io.*;
import java.util.Objects;

public class Main {
    public static final Tester theTest = new Tester();

    public static void main(String[] args) throws IOException {
        String fileName = "text1.txt";
        theTest.validation(new BufferedReader(new InputStreamReader(new FileInputStream(fileName))));
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

