package Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atomic implements SentenceElement {
    private String content;
    private String fnName;
    private List<String> variables;
    public Atomic(String content){
        this.content = content;
        fnName = content.substring(0,content.indexOf("("));
        variables = Arrays.asList(content.substring(content.indexOf("(")+1,content.indexOf(")")).split(","));
    }
}
