package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements DisplaySentences {
    private InputBar sentence;
    private SentenceCollection parent;

    public Sentence(InputBar sentence, SentenceCollection parent){
        this.sentence = sentence;
        this.parent = parent;
    }

    public List<Node> render(){
        List<Node> r = new ArrayList<>();
        r.add(sentence.getTarget());
        return r;
    }

    public void receiveInput(String s){
        sentence.receiveInput(s);
    }

    @Override
    public DisplaySentences searchForSentence(String str) {
        if(this.sentence.getSentence().equals(str))
            return this;
        else
            return null;
    }

    @Override
    public DisplaySentences searchForInputBar(InputBar inputBar) {
        if(this.sentence==inputBar)
            return this;
        else
            return null;
    }

    public SentenceCollection getParent() {
        return parent;
    }

    @Override
    public void focus() {
        sentence.focus();
    }

    public void defocus(){
        sentence.defoucus();
    }
}
