package src.graphicEngine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.MalformedURLException;

public class graphicEngine extends Application {


    private Stage stage;
    private AnchorPane window;
    private Text livesText;
    private Text scoreText;
    private Text timeText;

    public graphicEngine(){
        //on va ici construire une map , un core et un stage

    }

    public void loadWorldMap(){
        // on va ici set notre map
    }

    public void reloadWorldMap(){
        //cette fonction va recharger à chaque fois la map en fonction du score , du temps et du nombre de vie

    }

    //Cette methode lance la page d'acceuil
    public AnchorPane homePage() {

        AnchorPane homePage = new AnchorPane();
        homePage.setPrefSize(448, 576);
        homePage.setStyle("-fx-background-color: BLack; -fx-border-color: Orange;");

        Button playButton = new Button("Play");
        Button rulesButton = new Button("Game Rules");

        playButton.setLayoutX(125);
        playButton.setLayoutY(313);
        playButton.setPrefHeight(50);
        playButton.setPrefWidth(197);
        playButton.setStyle("-fx-background-color: Orange;");

        homePage.getChildren().addAll(playButton, playButton);

        return homePage;
    }

    public void home(Stage stage) throws MalformedURLException {
        AnchorPane home = homePage();
        Scene scene = new Scene(home,448,576);
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello player");


        Button playButton = new Button();
        Button rulesButton = new Button();

        playButton.setText("Play");
        rulesButton.setText("Rules of the game");
        /*
        playButton.setLayoutX(125);
        playButton.setLayoutY(313);
        playButton.setPrefHeight(50);
        playButton.setPrefWidth(197);
        playButton.setStyle("-fx-background-color: Orange;");

         */

        StackPane layout = new StackPane();
        layout.getChildren().addAll(playButton,rulesButton);
        Scene scene = new Scene(layout,900,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
