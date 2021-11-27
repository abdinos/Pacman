package gameengine.graphicEngine;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.*;

import java.awt.*;
import javafx.scene.control.*;

import java.awt.Label;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class GraphicEngine {
    private Map map;
    private Stage stage;
    private AnchorPane window;
    private Text livesText;
    private Text scoreText;
    private Text timeText;
    private Group group;

    public Map getMap() {
        return map;
    }

    public Stage getStage() {
        return stage;
    }

    public AnchorPane getWindow() {
        return window;
    }

    public Text getLivesText() {
        return livesText;
    }

    public Text getScoreText() {
        return scoreText;
    }

    public Text getTimeText() {
        return timeText;
    }

    public Group getGroup() {
        return group;
    }

    public GraphicEngine(Map map) {
        this.map = map;


        //on va ici construire une map , un core et une stage

    }

    public void loadWorldMap(Map map) {
        this.map = map;
        // on va ici set notre map
    }

    public void reloadWorldMap(Map map) {
        //cette fonction va recharger à chaque fois la map en fonction du score , du temps et du nombre de vie
        group = new Group();
        livesText = new Text();
        scoreText = new Text();
        timeText = new Text();
        loadWorldMap(map);
        Scene scene = new Scene(group);
        group.getChildren().addAll(livesText, scoreText, timeText);
        stage.setScene(scene);
        stage.show();

    }

    //Cette methode lance la page d'acceuil
    public AnchorPane homePage() {

        AnchorPane homePage = new AnchorPane();
        homePage.setPrefSize(448, 576);
        Button playButton = new javafx.scene.control.Button("Play");
        Button rulesButton = new Button("Game Rules");

       playButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
           @Override
           public void handle(javafx.event.ActionEvent event) {

           }
       });


        rulesButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {

            }
        });


        homePage.getChildren().addAll(playButton, playButton);

        return homePage;
    }

    public void rules(Stage d) throws MalformedURLException {
        AnchorPane rules = new AnchorPane();
        Scene scene = new Scene(rules, 448, 576);
        stage.setScene(scene);
        stage.show();
    }


    public void home(Stage stage) throws Exception {
        AnchorPane home = new AnchorPane();
        Scene scene = new Scene(home, 448, 576);
        stage.setScene(scene);
        stage.show();
    }


    public void gameOver(Stage stage) throws MalformedURLException {
        AnchorPane gameOver = new AnchorPane();
        Scene scene = new Scene(gameOver, 448, 576);
        stage.setScene(scene);
        stage.show();
    }




    public Scene start(Map map) throws FileNotFoundException {
        group = new Group();
        Scene scene = new Scene(group);

        livesText = new Text();
        scoreText =  new Text();
        timeText = new Text();

        group.getChildren().add(window);
        group.getChildren().add((Node) livesText);
        group.getChildren().add((Node) scoreText);
        group.getChildren().add((Node) timeText);
        return scene;
    }

    public void updateTimeText(int time) {
        this.timeText.setText("Time : " + time);

    }

    public void updateScoreText(int score) {


        this.scoreText.setText("Score : " + score);
    }

    public void updateLivesText(int lives) {
        this.livesText.setText("Lives : " + lives);

    }
}
