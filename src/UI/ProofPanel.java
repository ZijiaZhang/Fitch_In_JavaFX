package UI;

import DataStructures.Proof.DisplaySentences;
import DataStructures.Proof.Sentence;
import DataStructures.Proof.SentenceCollection;
import javafx.scene.layout.VBox;

public class ProofPanel extends VBox {

    private static ProofPanel proofPanel;
    private static SentenceCollection sentenceCollection = new SentenceCollection(null,null);
    private static Sentence currentFocus;

    public ProofPanel(){
        Sentence s = sentenceCollection.addSentence();
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
        Sentence s = currentFocus.getParent().addSentence();
        proofPanel.renderSentences();
        //currentFocus = s;
        proofPanel.changeFocus(s);
    }

    private void renderSentences(){
        clear();
        this.getChildren().addAll(sentenceCollection.render(-1));
    }

    private void clear(){
        this.getChildren().removeAll(this.getChildren());
    }

    public void changeFocus(InputBar inputBar){
        if(currentFocus!=null)
        currentFocus.defocus();
        currentFocus = sentenceCollection.searchForInputBar(inputBar);
        if(currentFocus!=null)
        currentFocus.focus();
    }

    public void changeFocus(Sentence sentence){
        if(currentFocus!=null)
            currentFocus.defocus();
        currentFocus = sentence;
        if(currentFocus!=null)
            currentFocus.focus();
    }

    public static void addSubProof(){
        SentenceCollection s = currentFocus.getParent().addSubProof();
        Sentence c = s.addSentence();
        proofPanel.renderSentences();
        proofPanel.changeFocus(c);
    }

    public static void endSubProof(){
        Sentence s = currentFocus.getParent().getParent().addSentence();
        proofPanel.renderSentences();
        proofPanel.changeFocus(s);
    }
}
