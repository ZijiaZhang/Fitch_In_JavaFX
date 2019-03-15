package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.List;

public interface DisplaySentences {
    public List<Node> render();
    DisplaySentences searchForSentence(String str);
    DisplaySentences searchForInputBar(InputBar inputBar);
    void receiveInput(String str);
    SentenceCollection getParent();
    void focus();
    void defocus();
}
