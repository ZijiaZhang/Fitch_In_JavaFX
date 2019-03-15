package Controllers;

import UI.ProofPannel;
import javafx.fxml.FXML;

public class InputButtonController {
    @FXML
    private String name ="";
    @FXML
    private void ButtonPressed(){
        System.out.println("buttonPressed" + name);
        ProofPannel.getInstance().receiveInput(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
