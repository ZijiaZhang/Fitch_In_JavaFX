package Controllers;

import UI.InputBar;
import UI.ProofPanel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;


public class InputBarController {

    @FXML
    private Region region;
    @FXML
    private HBox Hbox;

    @FXML
    private TextField textfield;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ComboBox comboBox;

    private InputBar inputBar;

    public TextField getTextfield(){
        return textfield;
    }

    @FXML
    private void FocusOnText(){
        ProofPanel.getInstance().ChangeFocus(inputBar);
    }

    public Region getRegion() {
        return region;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public ComboBox getComboBox() {
        return comboBox;
    }

    public void setInputBar(InputBar inputBar){
        this.inputBar = inputBar;
    }
}
