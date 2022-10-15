import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String htmlSnippet = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Href Attribute Example</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>Href Attribute Example</h1>\n" +
                "    <p>\n" +
                "      <a href=\"https://go.okstate.edu/undergraduate-academics/majors/computer-science.html\">Computer Science Page</a> gives you a brief introduction of Computer Science and why Computer Science program at Oklahoam State University. In addition to that, you can explore the program details by clicking the department website.\n" +
                "    </p>\n" +
                "  </body>\n" +
                "</html>";


        Stack s = new Stack();
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");

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