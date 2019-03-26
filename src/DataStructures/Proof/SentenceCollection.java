package DataStructures.Proof;

import UI.InputBar;
import UI.ProofPanel;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class SentenceCollection implements DisplaySentences {

    private List<Sentence> premises;
    private List<DisplaySentences> sentences = new ArrayList<>();
    private Sentence firstSentence;
    private SentenceCollection parent;

    public SentenceCollection(InputBar sentence , SentenceCollection parent){
        this.firstSentence = new Sentence(sentence,parent);
        firstSentence.setFirstSentenceOfCollection(true);
        firstSentence.setLeadingCollection(this);
        this.parent = parent;
    }

    //EFFECT: Add a Sentence in the Collection and return it.
    public Sentence addSentence(){
        Sentence sentence = new Sentence(new InputBar(),this);
        Sentence current = ProofPanel.getCurrentFocus();
        int index = sentences.indexOf(current);
        System.out.println(index);
        if(current!=null && index!=-1) {
            sentences.add(index + 1, sentence);
        }else
            sentences.add(sentence);
        return sentence;
    }


    //EFFECT: Render the Nodes with specific indent and if it is selected
    public List<Node> render(int layer, boolean selected){


        List<Node> r = new ArrayList<>();
        layer+=1;
        if(premises!=null)
            for(DisplaySentences s: premises){
                r.addAll(s.render(layer,selected));
            }

        if(ProofPanel.getCurrentFocus().getSentence().getSelectedLinks().contains(this))
            selected = true;

        if(firstSentence !=null)
            r.addAll(firstSentence.render(layer, selected));


        for(DisplaySentences s: sentences){
            r.addAll(s.render(layer,selected));
        }
        return r;
    }

    //EFFECT return the
   /* @Override
    public Sentence searchForInputBar(InputBar inputBar) {
        if(this.firstSentence.searchForInputBar(inputBar)!=null)
            return firstSentence;
        else
            for(DisplaySentences displaySentences: sentences){
                Sentence result = displaySentences.searchForInputBar(inputBar);
                if(result!=null){
                    return result;
                }
            }
            return null;

    }*/

    @Override
    public Sentence searchForSentence(String str) {
        if(this.firstSentence.searchForSentence(str)!=null)
            return firstSentence;
        else
        for(DisplaySentences displaySentences: sentences){
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
        Sentence current = ProofPanel.getCurrentFocus();
        int index = sentences.indexOf(current);
        if(current!=null && index!=-1) {
            sentences.add(index + 1, s);
        }else{
            sentences.add(s);
        }
        return s;
    }

//    public InputBar getText() {
//        return sentence;
//    }


    @Override
    public ArrayList<DisplaySentences> getPremises() {
        return null;
    }

    //Return All premises before s
    public ArrayList<DisplaySentences> findPremises(DisplaySentences s){
        ArrayList<DisplaySentences> result = new ArrayList<>();
        if(premises != null)
            result.addAll(premises);
        result.add(this);
        int index = sentences.indexOf(s);
        for(int i =0;i<index;i++)
            result.add(sentences.get(i));
        if(s!= firstSentence)
            result.add(firstSentence);
        if(parent!=null)
            result.addAll(getParent().findPremises(this));
        return result;
    }

    @Override
    public void setSelected() {
        firstSentence.setSelected();
        for(DisplaySentences displaySentences: sentences)
            displaySentences.setSelected();
    }

    public void setUnselected(){
        this.firstSentence.setUnselected();
        for(DisplaySentences displaySentences: sentences)
            displaySentences.setUnselected();
    }

    public Sentence getFirstSentence() {
        return firstSentence;
    }

    public Sentence addPremise(){
        try{
            if(premises==null)
                premises = new ArrayList<>();
            Sentence s = new Sentence(new InputBar(),this);
            s.setIsPremise(true);
            premises.add(s);
            return s;
        }catch (Exception e){
            System.out.println("Error in Adding Premise");
            return null;
        }
    }

}
