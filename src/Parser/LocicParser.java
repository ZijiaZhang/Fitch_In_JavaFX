package Parser;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class LocicParser {
    public static final Map<Character,LogicConnector> ReflectionTable = new HashMap<Character, LogicConnector>() {{
        put('∧', LogicConnector.And);
        put('∨', LogicConnector.Or);
        //etc
    }};
    public static LogicSentence parseLogic(String sentence){
        ArrayList<SentenceElement> logicSentences = new ArrayList<>();
        boolean inPredicates = false;
        LogicConnector connector = LogicConnector.None;

        StringBuilder buffer = new StringBuilder(sentence.length());
        int currentDepth = 0;
        for(char c: sentence.toCharArray()){
            if(c==' ')
                continue;
            if(ReflectionTable.containsKey(c)&& currentDepth==0){
                //TODO:HANDLE KEY
                if (connector == LogicConnector.None) {
                    connector = ReflectionTable.get(c);
                } else {
                    if (connector != ReflectionTable.get(c)) {
                        throw new RuntimeException("Error When Parding Sentnce");
                    }
                }
                if(buffer.length()!=0) {
                    logicSentences.add(new Atomic(buffer.toString()));
                    buffer.delete(0, buffer.length());
                }
            }else if(c == '('){



                //When Brackets are used to Separate variables.
                if(!buffer.toString().contains("(")){
                    currentDepth++;
                    buffer.append(c);
                    inPredicates = true;
                }
                //If Buffer is Empty then the brackets are used to seperate the logical Sentences.

                else{/*TODO: Parse Sub-Sentences*/
                    currentDepth++;
                    buffer.append(c);
                }


            }else if(c == ')'){
                if(inPredicates) {
                    inPredicates = false;
                    currentDepth--;
                    buffer.append(c);
                    if(currentDepth==0) {
                        logicSentences.add(new Atomic(buffer.toString()));
                        buffer.delete(0,buffer.length());
                    }
                }else {
                    currentDepth--;
                    buffer.append(c);
                    if (currentDepth == 0) {
                        logicSentences.add(parseLogic(buffer.substring(1, buffer.length() - 1)));
                        buffer.delete(0, buffer.length());
                    }
                }
            }else{
                buffer.append(c);
            }
        }
        return new LogicSentence(connector,logicSentences);
    }
}
