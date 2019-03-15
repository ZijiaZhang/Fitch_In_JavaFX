package UI;

import DataStructures.Proof.SentenceCollection;
import javafx.scene.layout.VBox;

public class ProofPannel extends VBox {

    private static ProofPannel proofPannel;
    private SentenceCollection sentenceCollection = new SentenceCollection(new InputBar());
    private SentenceCollection currentFocus = sentenceCollection;

    public ProofPannel(){
        this.addSentence();

    }

    public static ProofPannel getInstance(){
        if(proofPannel==null) proofPannel = new ProofPannel();
        return proofPannel;
    }

    public void receiveInput(String s){
        currentFocus.receiveInput(s);
    }

    public void addSentence(){
        currentFocus.addSentence();
        renderSentences();
    }

    public void renderSentences(){
        clear();
        this.getChildren().addAll(sentenceCollection.render());
    }

    public void clear(){
        this.getChildren().removeAll(this.getChildren());
    }
}
