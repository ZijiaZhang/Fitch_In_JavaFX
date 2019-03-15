package sample;

import UI.InputPannel;
import UI.ProofPannel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        VBox root = new VBox();
        Scene mainScene = new Scene(root,600,1000);

        root.getChildren().add(new InputPannel());
        root.getChildren().add(ProofPannel.getInstance());


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
