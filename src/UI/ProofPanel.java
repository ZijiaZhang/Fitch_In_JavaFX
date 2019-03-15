package UI;

import DataStructures.Proof.DisplaySentences;
import DataStructures.Proof.Sentence;
import DataStructures.Proof.SentenceCollection;
import javafx.scene.layout.VBox;

public class ProofPanel extends VBox {

    private static ProofPanel proofPanel;
    private SentenceCollection sentenceCollection = new SentenceCollection(null,null);
    private DisplaySentences currentFocus;

    public ProofPanel(){
        Sentence s = sentenceCollection.addSentence();
        currentFocus = s;
        renderSentences();
        //.addSentence();
        currentFocus.focus();

    }

    public static ProofPanel getInstance(){
        if(proofPanel ==null) proofPanel = new ProofPanel();
        return proofPanel;
    }

    public void receiveInput(String s){
        currentFocus.receiveInput(s);
    }

    public void addSentence(){
        Sentence s = currentFocus.getParent().addSentence();
        renderSentences();
        currentFocus = s;
    }

    private void renderSentences(){
        clear();
        this.getChildren().addAll(sentenceCollection.render());
    }

    private void clear(){
        this.getChildren().removeAll(this.getChildren());
    }

    public void ChangeFocus(InputBar inputBar){
        if(currentFocus!=null)
        currentFocus.defocus();
        currentFocus = sentenceCollection.searchForInputBar(inputBar);
        if(currentFocus!=null)
        currentFocus.focus();
    }
}
