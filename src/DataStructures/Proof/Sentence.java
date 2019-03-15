package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Renderable {
    private InputBar sentence;

    public Sentence(InputBar sentence){
        this.sentence = sentence;
    }

    public List<Node> render(){
        List<Node> r = new ArrayList<>();
        r.add(sentence.getTarget());
        return r;
    }

}
