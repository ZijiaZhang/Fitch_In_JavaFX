package sample;

import UI.InputPanel;
import UI.ProofPanel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        VBox root = new VBox();
        Scene mainScene = new Scene(root,600,1000);


        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");

        MenuItem add = new MenuItem("Add Sentence");
        add.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                ProofPanel.addSentence();
            }
        });

        MenuItem addSub = new MenuItem("Add SubProof");
        addSub.setAccelerator(KeyCombination.keyCombination("Ctrl+K"));
        addSub.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                ProofPanel.addSubProof();
            }
        });

        MenuItem endSub = new MenuItem("End SubProof");
        endSub.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        endSub.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                ProofPanel.endSubProof();
            }
        });

        menuEdit.getItems().addAll(add,addSub,endSub);


        ((VBox) mainScene.getRoot()).getChildren().addAll(menuBar);
        menuBar.getMenus().addAll(menuFile, menuEdit);

        root.getChildren().add(new InputPanel());
        root.getChildren().add(ProofPanel.getInstance());


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
