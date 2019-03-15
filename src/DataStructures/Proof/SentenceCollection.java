package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class SentenceCollection implements DisplaySentences {
    private List<DisplaySentences> Sentences = new ArrayList<>();
    //private InputBar sentence;
    private SentenceCollection parent;

    public SentenceCollection(InputBar sentence , SentenceCollection parent){
        //this.sentence = sentence;
        this.parent = parent;
    }


   /* public void receiveInput(String s){
        sentence.receiveInput(s);
    }*/

    public Sentence addSentence(){
        Sentence sentence = new Sentence(new InputBar(),this);
        Sentences.add(sentence);
        return sentence;
    }

    public List<Node> render(int layer){
        List<Node> r = new ArrayList<>();
        layer+=1;
//        if(sentence!=null) {
//            sentence.getRegion().setPrefSize(layer*50,10);
//            sentence.getRegion().setMinSize(layer*50,10);
//            sentence.getText().setText(String.valueOf(layer));
//            r.add(sentence.getTarget());
//        }
        for(DisplaySentences s: Sentences){
            r.addAll(s.render(layer));
        }
        return r;
    }

    @Override
    public Sentence searchForInputBar(InputBar inputBar) {
//        if(this.sentence==inputBar)
//            return this;
//        else
            for(DisplaySentences displaySentences: Sentences){
                Sentence result = displaySentences.searchForInputBar(inputBar);
                if(result!=null){
                    return result;
                }
            }
            return null;

    }

    @Override
    public Sentence searchForSentence(String str) {
//        if(this.sentence.getSentence().equals(str))
//            return this;
//        else
        for(DisplaySentences displaySentences: Sentences){
            Sentence result = displaySentences.searchForSentence(str);
            if(result!=null){
                return result;
            }
        }
        return null;
    }

    public SentenceCollection getParent() {
        return parent;
    }

//    public void focus() {
//        sentence.focus();
//    }
//
//    public void defocus(){
//        sentence.defoucus();
//    }

    public SentenceCollection addSubProof() {
        SentenceCollection s = new SentenceCollection(new InputBar(),this);
        Sentences.add(s);
        return s;
    }

//    public InputBar getSentence() {
//        return sentence;
//    }
}
