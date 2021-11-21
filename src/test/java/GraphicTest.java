package src.test.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GraphicTest extends Application {

    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello player");


        Button playButton = new Button();
        Button rulesButton = new Button();

        playButton.setText("Play");
        rulesButton.setText("Rules of the game");

        StackPane layout = new StackPane();
        layout.getChildren().addAll(playButton,rulesButton);
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
