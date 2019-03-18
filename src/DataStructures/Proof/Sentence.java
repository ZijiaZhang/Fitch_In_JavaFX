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

    public List<Node> render(int layer){
        List<Node> r = new ArrayList<>();
        int width = layer*50;
        int MinWidth = 400;
        sentence.getRegion().setPrefSize(width,10);
        sentence.getRegion().setMinSize(width,10);
        //sentence.getTextfield().setPrefSize(sentence.getTextfield().getWidth()-width,sentence.getTextfield().getHeight());
        sentence.getTextfield().setMinSize(MinWidth-width,sentence.getTextfield().getHeight());
        sentence.getTextfield().setText(String.valueOf(layer));
        r.add(sentence.getTarget());
        return r;
    }

    public void receiveInput(String s){
        sentence.receiveInput(s);
    }

    @Override
    public Sentence searchForSentence(String str) {
        if(this.sentence.getSentence().equals(str))
            return this;
        else
            return null;
    }

    @Override
    public Sentence searchForInputBar(InputBar inputBar) {
        if(this.sentence==inputBar)
            return this;
        else
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

    public void addRuleLink(DisplaySentences sentences){
            if(isPrev(sentences))
                sentence.addRuleLink(sentences);
            else{
                //TODO: SELECT SUBPROOF
            }


    }

    //Return true if s is a valid premise for current sentence;
    boolean isPrev(DisplaySentences s){
        ArrayList<DisplaySentences> premises = getPremises();
        return premises.contains(s);
    }

    @Override
    public ArrayList<DisplaySentences> getPremises() {
        return parent.findpremises(this);
    }

    @Override
    public void setSelected() {
        sentence.setSelected();
    }
}
