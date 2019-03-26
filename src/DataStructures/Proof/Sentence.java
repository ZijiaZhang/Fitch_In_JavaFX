package DataStructures.Proof;

import UI.InputBar;
import UI.ProofPanel;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements DisplaySentences {
    private InputBar sentence;
    private SentenceCollection parent;
    private boolean firstSentenceOfCollection = false;
    private SentenceCollection leadingCollection;
    private boolean isPremise = false;

    public Sentence(InputBar sentence, SentenceCollection parent){
        this.sentence = sentence;
        this.parent = parent;
        if(sentence!=null)
        sentence.setSentence(this);
    }

    public List<Node> render(int layer, boolean selected){

        List<Node> r = new ArrayList<>();
        int width = layer*50;
        int MinWidth = 400;
        if(sentence!=null) {
            sentence.getRegion().setPrefSize(width, 10);
            sentence.getRegion().setMinSize(width, 10);
            //sentence.getTextfield().setPrefSize(sentence.getTextfield().getWidth()-width,sentence.getTextfield().getHeight());
            sentence.getTextfield().setMinSize(MinWidth - width, sentence.getTextfield().getHeight());
            if(this.isFirstSentenceOfCollection()||isPremise)
                sentence.getRuleSelection().setVisible(false);
            if(this == ProofPanel.getCurrentFocus()){
                sentence.setCurrent();
            }else
            {
                if(selected || ProofPanel.getCurrentFocus().sentence.getSelectedLinks().contains(this))
                    this.setSelected();
                else
                    this.setUnselected();
            }


            this.getSentence().getCheckBox().setDisable(ProofPanel.getCurrentFocus().isPremise ||
                    ProofPanel.getCurrentFocus().isFirstSentenceOfCollection()  );

            //sentence.getTextfield().setText(String.valueOf(layer));
            r.add(sentence.getTarget());

        }
        return r;
    }

    public void receiveInput(String s){
        sentence.receiveInput(s);
    }

    @Override
    public Sentence searchForSentence(String str) {
        if(this.sentence.getText().equals(str))
            return this;
        else
            return null;
    }
/*
    @Override
    public Sentence searchForInputBar(InputBar inputBar) {
        if(this.sentence==inputBar)
            return this;
        else
            return null;
    }*/

    public SentenceCollection getParent() {
        return parent;
    }

    public void focus() {
        sentence.focus();
    }

    public void defocus(){
        sentence.defoucus();
    }

    public void addRuleLink(Sentence sentences){
        if(isFirstSentenceOfCollection())
            return;

            if(isPrev(sentences))
                sentence.addRuleLink(sentences);
            else if(sentences.isFirstSentenceOfCollection()) {
                if (isPrev(sentences.getLeadingCollection()))
                    sentence.addRuleLink(sentences.leadingCollection);
                else
                    sentences.sentence.getCheckBox().setSelected(false);
            }else
                sentences.sentence.getCheckBox().setSelected(false);



    }

    //Return true if s is a valid premise for current sentence;
    private boolean isPrev(DisplaySentences s){
        ArrayList<DisplaySentences> premises = getPremises();
        return premises.contains(s);
    }

    @Override
    public ArrayList<DisplaySentences> getPremises() {
        return parent.findPremises(this);
    }

    @Override
    public void setSelected() {
        sentence.setSelected();
    }

    public void setFirstSentenceOfCollection(boolean firstSentenceOfCollection) {
        this.firstSentenceOfCollection = firstSentenceOfCollection;
    }

    public boolean isFirstSentenceOfCollection() {
        return firstSentenceOfCollection;
    }

    public void setLeadingCollection(SentenceCollection leadingCollection) {
        this.leadingCollection = leadingCollection;
    }

    public SentenceCollection getLeadingCollection() {
        return leadingCollection;
    }

    @Override
    public void setUnselected() {
        sentence.setUnselected();
    }

    public void removeRuleLink(Sentence s){
        if(isPrev(s))
            sentence.removeRuleLink(s);
        else if(s.isFirstSentenceOfCollection()){
            if(isPrev(s.getParent()))
                sentence.removeRuleLink(s.leadingCollection);
        }
    }

    public InputBar getSentence() {
        return sentence;
    }

    public boolean isPremise(){
        return isPremise;
    }

    public void setIsPremise(boolean premise){
        isPremise = premise;
    }
}
