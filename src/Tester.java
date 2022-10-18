import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Tester {
    private int index = 0;
    private final Stack<String> stack = new Stack();
    private final String[] openingTags = new String[]
            {"<!DOCTYPEhtml>","<html","<body", "<h1", "<h2","<p", "<front",
                    "<head","<title", "<a", "<center", "<b", "<i", "<u"};
    private final String[] closingTags = new String[]
            {"</html>","</body>","</front>","</h1>","</p>", "</title>",
                    "</head>", "</a>", "</center>", "</h2>", "</b>","</i>"
                    ,"</u>"};

    Tester(){

    }
    public boolean validation(BufferedReader theFile){
        String line;
        boolean exit;
        try{
            while((line = theFile.readLine())!=null){
                exit = test(line.replaceAll(" ", ""));
                if (exit){
                    return false;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }
    private ArrayList<String> getTags(String theLine){
        char[] fileLine = theLine.toCharArray();
        ArrayList<String> ans = new ArrayList<>();

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
                if (str.toString().contains("<!--") ||
                    str.toString().equals("<hr>") ||
                    str.toString().equals("<br>")){
                    continue;
                }
                ans.add(str.toString());
            }
        }
        return ans;
    }
    private boolean test(String theLine){
        index++;
        ArrayList<String> tags = getTags(theLine);
        String test;
        StringBuilder sb;

        if (Objects.equals(stack.top(), openingTags[0])){
            stack.pop();
        }
        for(String i : tags){
            if(i.contains(test = anOpeningTag(i))){
                if(!test.contains(">")){
                    char[] arr = i.toCharArray();
                    test = misc(arr, test);
                }
                stack.push(test);
            }
            if(i.contains(test = aClosingTag(i))){
                sb = new StringBuilder(stack.top()).insert(1, '/');
                if (sb.toString().equals(test)){
                    stack.pop();
                }
                else{
                    // Then it must be the tag before
                    stack.pop();
                    // exit
                    return true;
                }
            }
        }
        return false;
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
    public int getIndex() {
        return index;
    }

    public Stack<String> getStack() {
        return stack;
    }
}
