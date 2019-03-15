package DataStructures.Proof;

import UI.InputBar;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class SentenceCollection implements Renderable {
    private List<Renderable> Sentences = new ArrayList<>();
    private InputBar sentence;
    public SentenceCollection(InputBar sentence){
        this.sentence = sentence;
    }


    public void receiveInput(String s){
        sentence.receiveInput(s);
    }

    public void addSentence(){
        Sentences.add(new Sentence(new InputBar()));
    }

    public List<Node> render(){
        List<Node> r = new ArrayList<>();
        r.add(sentence.getTarget());
        for(Renderable s: Sentences){
            r.addAll(s.render());
        }
        return r;
    }
}
