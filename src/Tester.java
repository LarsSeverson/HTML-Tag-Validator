import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Tester {
    private final Stack<String> stack = new Stack();
    private final String[] openingTags = new String[]
            {"<!DOCTYPEhtml>","<html","<body", "<h1", "<h2","<p", "<front",
                    "<head","<title", "<a", "<center", "<b", "<i", "<u"};
    private final String[] closingTags = new String[]
            {"</html>","</body>","</front>","</h1>","</p>", "</title>",
                    "</head>", "</a>", "</center>", "</h2>", "</b>","</i>"
                    ,"</u>"};
    private ArrayList<String> tags = new ArrayList<>();
    Tester(){

    }
    public void validation(BufferedReader theFile){
        String line;
        try{
            while((line = theFile.readLine())!=null){
                getTags(line.replaceAll(" ", ""));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(tags);
       stack.show();
    }
    private void getTags(String theLine){
        char[] fileLine = theLine.toCharArray();
        for(int i = 0; i < fileLine.length; i++){
            StringBuilder str = new StringBuilder();
            if (fileLine[i] == '<'){
                int j = i;
                while(j < fileLine.length){
                    if(fileLine[j] == '>'){
                        str.append(fileLine[j]);
                        break;
                    }
                    str.append(fileLine[j]);
                    j++;
                }
                tags.add(str.toString());
            }
        }
    }
    private void test(String theLine){

        String test;
        StringBuilder sb;

        if (Objects.equals(stack.top(), openingTags[0])){
            stack.pop();
        }
        if(theLine.contains(test = anOpeningTag(theLine))){
            if(!test.contains(">")){
                char[] arr = theLine.toCharArray();
                test = misc(arr, test);
            }
            stack.push(test);
        }
        if(theLine.contains(test = aClosingTag(theLine))){
            sb = new StringBuilder(stack.top()).insert(1, '/');
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
    private String misc(char[] ch, String test){
        StringBuilder s = new StringBuilder();
        for(char i : ch){
            s.append(i);
            if(i == '>'){
                break;
            }
        }
        if(!s.toString().contains(">")){
            return "not valid";
        }
        return test + '>';
    }
}
