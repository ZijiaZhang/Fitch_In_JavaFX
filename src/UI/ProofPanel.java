package UI;

import DataStructures.Proof.DisplaySentences;
import DataStructures.Proof.Sentence;
import DataStructures.Proof.SentenceCollection;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ProofPanel extends VBox {

    public static final int INPUT = 0;
    public static final int RULE = 1;
    private static ProofPanel proofPanel;
    private static SentenceCollection sentenceCollection = new SentenceCollection(null,null);
    private static Sentence currentFocus;
    private static int mode = 0;

    public ProofPanel(){
        Sentence s = sentenceCollection.addSentence();
        //currentFocus = s.getFirstSentence();
        currentFocus = s;
        renderSentences();
        //.addSentence();
        //currentFocus.focus();

    }

    public static ProofPanel getInstance(){
        if(proofPanel ==null) proofPanel = new ProofPanel();
        return proofPanel;
    }

    public void receiveInput(String s){
        currentFocus.receiveInput(s);
    }

    public static void addSentence(){
        Sentence s;
        if(!currentFocus.isFirstSentenceOfCollection())
            s = currentFocus.getParent().addSentence();
        else
            s = currentFocus.getLeadingCollection().addSentence();

        //currentFocus = s;
        proofPanel.changeFocus(s);
        proofPanel.renderSentences();
    }

    private void renderSentences(){
        clear();
        this.getChildren().addAll(sentenceCollection.render(-1,false));
        currentFocus.focus();
    }

    private void clear(){
        this.getChildren().removeAll(this.getChildren());
    }

    public void changeFocus(InputBar inputBar){
        if(currentFocus!=null)
        currentFocus.defocus();
        currentFocus = inputBar.getSentence();
        if(currentFocus!=null)
        currentFocus.focus();
        this.renderSentences();
    }

    public void selectText(InputBar inputBar, boolean selected){
        if(mode == INPUT)
            changeFocus(inputBar);
        else if(mode == RULE)
            if(selected)
                currentFocus.addRuleLink(inputBar.getSentence());
            else
                currentFocus.removeRuleLink(inputBar.getSentence());

    }

    public void changeFocus(Sentence sentence){
        if(currentFocus!=null)
            currentFocus.defocus();
        currentFocus = sentence;
        if(currentFocus!=null)
            currentFocus.focus();
    }

    public static void addSubProof(){
        SentenceCollection s;
        if(!currentFocus.isFirstSentenceOfCollection()) {
             s = currentFocus.getParent().addSubProof();
        }else{
            s = currentFocus.getLeadingCollection().addSubProof();
        }
        //Sentence c = s.addSentence();

        proofPanel.changeFocus(s.getFirstSentence());
        proofPanel.renderSentences();
    }

    public static void endSubProof(){
        Sentence s;
        try {
            if (!currentFocus.isFirstSentenceOfCollection())
                s = currentFocus.getParent().getParent().addSentence();
            else
                s = currentFocus.getParent().addSentence();

            proofPanel.changeFocus(s);
            proofPanel.renderSentences();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setMode(int m){
        mode = m;
    }

    public static Sentence getCurrentFocus() {
        return currentFocus;
    }

    public static void addPremise(){
        Sentence s = sentenceCollection.addPremise();
        proofPanel.changeFocus(s);
        proofPanel.renderSentences();
    }
}
