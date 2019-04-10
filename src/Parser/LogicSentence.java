package Parser;

import java.util.ArrayList;

public class LogicSentence implements SentenceElement {
    private LogicConnector connection;
    private ArrayList<SentenceElement> sentenceElements = new ArrayList<>();

    public LogicSentence(){

    }
    public LogicSentence(LogicConnector connection, ArrayList<SentenceElement> sentenceElements){
        this.connection = connection;
        this.sentenceElements = sentenceElements;
    }

    public void setConnection(LogicConnector connection) {
        this.connection = connection;
    }

    public void setSentenceElements(ArrayList<SentenceElement> sentenceElements) {
        this.sentenceElements = sentenceElements;
    }
}
