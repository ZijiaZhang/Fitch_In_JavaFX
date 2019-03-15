package UI;

import Controllers.InputBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;

public class InputBar {
    final String FXML = "resources/ProofSentenceBar.fxml";
    private HBox target;
    private TextField text;
    private CheckBox checkBox;
    private ComboBox comboBox;

    public InputBar(){
        try {
            File fxmlFile = new File(FXML);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile.toURI().toURL());
            target = fxmlLoader.load();
            InputBarController inputBarController = fxmlLoader.getController();
            text = inputBarController.getTextfield();
            checkBox = inputBarController.getCheckBox();
            inputBarController.setInputBar(this);

        }catch (IOException e){

        }
    }

    public void receiveInput(String s){
        text.setText(text.getText() + s);
    }

    public HBox getTarget() {
        return target;
    }

    public String getSentence(){return text.getText();}

    public void focus(){
        checkBox.setSelected(true);
        text.requestFocus();
    }

    public void defoucus(){
        checkBox.setSelected(false);
    }
}
