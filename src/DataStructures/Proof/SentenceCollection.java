package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class SentenceCollection implements DisplaySentences {
    private List<DisplaySentences> Sentences = new ArrayList<>();
    private InputBar sentence;
    private SentenceCollection parent;

    public SentenceCollection(InputBar sentence , SentenceCollection parent){
        this.sentence = sentence;
        this.parent = parent;
    }


    public void receiveInput(String s){
        sentence.receiveInput(s);
    }

    public Sentence addSentence(){
        Sentence sentence = new Sentence(new InputBar(),this);
        Sentences.add(sentence);
        return sentence;
    }

    public List<Node> render(){
        List<Node> r = new ArrayList<>();
        if(sentence!=null)
        r.add(sentence.getTarget());
        for(DisplaySentences s: Sentences){
            r.addAll(s.render());
        }
        return r;
    }

    @Override
    public DisplaySentences searchForInputBar(InputBar inputBar) {
        if(this.sentence==inputBar)
            return this;
        else
            for(DisplaySentences displaySentences: Sentences){
                DisplaySentences result = displaySentences.searchForInputBar(inputBar);
                if(result!=null){
                    return result;
                }
            }
            return null;

    }

    @Override
    public DisplaySentences searchForSentence(String str) {
        if(this.sentence.getSentence().equals(str))
            return this;
        else
            for(DisplaySentences displaySentences: Sentences){
            DisplaySentences result = displaySentences.searchForSentence(str);
            if(result!=null){
                return result;
            }
        }
        return null;
    }

    public SentenceCollection getParent() {
        return parent;
    }

    public void focus() {
        sentence.focus();
    }

    public void defocus(){
        sentence.defoucus();
    }

}
