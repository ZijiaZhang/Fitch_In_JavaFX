package Controllers;

import UI.InputBar;
import UI.ProofPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;


public class InputBarController {

    private String rule = "none";
    public Label ruleSelection;
    public ContextMenu ruleMenu;
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
        ProofPanel.getInstance().setMode(ProofPanel.INPUT);
        ProofPanel.getInstance().changeFocus(inputBar);
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

    public void ShowRuleSelection(MouseEvent mouseEvent) {
        ruleMenu.show(ruleSelection,mouseEvent.getScreenX(),mouseEvent.getScreenY());
        selectText();
    }

    public void ruleCheck(ActionEvent actionEvent) {
        String name = ((MenuItem)actionEvent.getSource()).getText();
        setRule(name);
        ProofPanel.getInstance().setMode(ProofPanel.RULE);
        selectText();
    }

    private void setRule(String s){
        rule = s;
        ruleSelection.setText(s);
    }

    public void selectText() {
        ProofPanel.getInstance().selectText(inputBar);
    }
}
