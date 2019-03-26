package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public interface DisplaySentences {
    public List<Node> render(int layer,boolean selected);
    Sentence searchForSentence(String str);
    //Sentence searchForInputBar(InputBar inputBar);
    //void receiveInput(String str);
    SentenceCollection getParent();

    ArrayList<DisplaySentences> getPremises();
    void setSelected();
    void setUnselected();
    //void focus();
    //void defocus();
}
