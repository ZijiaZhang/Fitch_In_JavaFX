package UI;

import Controllers.InputButtonController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;

public class InputPanel extends GridPane {
    private final String[] inputs = {"∧", "∨", "¬", "→", "↔", "⊥", "a", "b", "c", "d"
            , "e", "f", "∀", "∃", "=", "≠", "(", ")", "x", "y", "z", "u", "v", "w"};
    private final double SIZE_X = 300;
    private final double SIZE_Y = 200;

    public InputPanel() throws IOException {
        super();
        for(int i =0; i<inputs.length;i++){
            final String FXML = "resources/Button.fxml";
            File fxmlFile = new File(FXML);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile.toURI().toURL());
            Button inputButton = fxmlLoader.load();
            inputButton.setId(inputs[i]);
            inputButton.setText(inputs[i]);
            InputButtonController inputButtonController = fxmlLoader.getController();
            inputButtonController.setName(inputs[i]);
            add(inputButton,i%6,i/6,1,1);
            inputButton.setPrefSize(SIZE_X/6,SIZE_Y/4);
        }
    }

}
