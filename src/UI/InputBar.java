package UI;

import Controllers.InputBarController;
import DataStructures.Proof.DisplaySentences;
import DataStructures.Proof.Sentence;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    //The corresponding Sentence
    private Sentence sentence;


    public InputBar(){
        try {
            File fxmlFile = new File(FXML);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile.toURI().toURL());
            target = fxmlLoader.load();
            inputBarController = fxmlLoader.getController();
            inputBarController.setInputBar(this);
            target.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(0),new Insets(0))));
        }catch (IOException e){

        }
    }

    public void receiveInput(String s){
        getTextfield().setText(getTextfield().getText() + s);
    }

    public HBox getTarget() {
        return target;
    }

    public String getText(){return getTextfield().getText();}

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

    public Label getRuleSelection(){
        return inputBarController.getRuleSelection();
    }

    public void addRuleLink(DisplaySentences s){
        selectedLinks.add(s);
        s.setSelected();

    }

    public void setSelected(){
        //getTextfield().setText("Selected");
        getCheckBox().setDisable(false);
        getCheckBox().setSelected(true);
        target.setBackground(new Background(new BackgroundFill(Color.RED,new CornerRadii(0),new Insets(0))));
    }

    public void setUnselected(){
        getCheckBox().setDisable(false);
        getCheckBox().setSelected(false);
        target.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(0),new Insets(0))));

    }

    public void setCurrent(){
        getCheckBox().setDisable(true);
        getCheckBox().setSelected(false);
        target.setBackground(new Background(new BackgroundFill(Color.GREEN,new CornerRadii(0),new Insets(0))));
    }

    public void removeRuleLink(DisplaySentences s){
        selectedLinks.remove(s);
        s.setUnselected();
    }

    public ArrayList<DisplaySentences> getSelectedLinks() {
        return selectedLinks;
    }

    public void setSentence(Sentence sentence){
        this.sentence = sentence;
    }

    public Sentence getSentence(){
        return sentence;
    }

}
