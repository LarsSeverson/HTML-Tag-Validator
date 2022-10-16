import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Tester {
    private final Stack<String> stack = new Stack();
    private final String[] openingTags = new String[]
            {"<!DOCTYPEhtml>","<html>","<body>", "<h1>","<p>", "<front>", "<head>","<title>"};
    private final String[] closingTags = new String[]
            {"</html>","</body>","</front>","</h1>","</p>", "</title>", "</head>"};
    Tester(){

    }
    public void validation(BufferedReader theFile){
        String line;
        try{
            while((line = theFile.readLine())!=null){
                test(line.replaceAll(" ", ""));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
       stack.show();
    }
    private void test(String theLine){
        String test;
        StringBuffer sb;
        if (Objects.equals(stack.top(), openingTags[0])){
            stack.pop();
        }
        if(theLine.contains(test = anOpeningTag(theLine))){
            stack.push(test);
        }
        if(theLine.contains(test = aClosingTag(theLine))){
            sb = new StringBuffer(stack.top()).insert(1, '/');
            if (sb.toString().equals(test)){
                stack.pop();
            }
        }
    }

    private String aClosingTag(String test) {
        for(String i : closingTags){
            if (test.contains(i)){
                return i;
            }
        }
        return "null";
    }

    private String anOpeningTag(String test){
        for(String i : openingTags){
            if (test.contains(i)){
                return i;
            }
        }
        return "null";
    }

}
