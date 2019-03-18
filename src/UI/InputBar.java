package UI;

import Controllers.InputBarController;
import DataStructures.Proof.DisplaySentences;
import DataStructures.Proof.Sentence;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InputBar {
    final String FXML = "resources/ProofSentenceBar.fxml";
    private HBox target;
//    private TextField text;
//    private CheckBox checkBox;
//    private ComboBox comboBox;
//    private Region region;
    private InputBarController inputBarController;
    private ArrayList<DisplaySentences> selectedLinks = new ArrayList<>();


    public InputBar(){
        try {
            File fxmlFile = new File(FXML);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile.toURI().toURL());
            target = fxmlLoader.load();
            inputBarController = fxmlLoader.getController();
            inputBarController.setInputBar(this);

        }catch (IOException e){

        }
    }

    public void receiveInput(String s){
        getTextfield().setText(getTextfield().getText() + s);
    }

    public HBox getTarget() {
        return target;
    }

    public String getSentence(){return getTextfield().getText();}

    public void focus(){
        getCheckBox().setSelected(true);
        getTextfield().requestFocus();
    }

    public void defoucus(){
        getCheckBox().setSelected(false);
    }

    public Region getRegion() {
        return inputBarController.getRegion();
    }

    public TextField getTextfield() {
        return inputBarController.getTextfield();
    }

    public CheckBox getCheckBox(){
        return inputBarController.getCheckBox();
    }

    public void addRuleLink(DisplaySentences s){
        selectedLinks.add(s);
        s.setSelected();

    }

    public void setSelected(){
        getTextfield().setText("Selected");
        target.setBackground(new Background(new BackgroundFill(Color.RED,new CornerRadii(0),new Insets(0))));
    }
}
