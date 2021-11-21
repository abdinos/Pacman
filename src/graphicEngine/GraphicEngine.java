package src.graphicEngine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GraphicEngine {

    private Map map;
    private Stage stage;
    private AnchorPane window;
    private Text livesText;
    private Text scoreText;
    private Text timeText;
    private Group group;

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
        Button playButton = new Button("Play");
        Button rulesButton = new Button("Game Rules");

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //vas appeller la methode play du corps
            }
        });

        rulesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    //vas appeller la methode rules
                    rules(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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


    public AnchorPane rules() throws MalformedURLException {
        AnchorPane rules = new AnchorPane();
        Button back = new Button("RETURN");

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // retour a la page principal coreKernel.home(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Label labelCommands = new Label("Commands");
        Label labelTitle = new Label("Rules");
        Label labelObjectif = new Label("Win the game without being catch");


        Label labelRules = new Label(" * If you get caught 3 times you lose the game. \n" +
                " *  The player controls Pac-Man,,\n" +
                " who must eat all the dots inside an enclosed maze .\n" +
                " * while avoiding four colored ghosts. \n" +
                "Eating large \n" +
                "        flashing dots called \"Power Pellets\" causes the ghosts to.\n" +
                " * turn blue, allowing Pac-Man to eat them for bonus points.\n"
        );


        rules.getChildren().addAll(back, labelRules, labelObjectif, labelCommands, labelTitle);
        return rules;
    }

    public Scene start(Map map) throws FileNotFoundException {
        group = new Group();
        Scene scene = new Scene(group);

        livesText = new Text();
        scoreText = new Text();
        timeText = new Text();

        group.getChildren().add(window);
        group.getChildren().add(livesText);
        group.getChildren().add(scoreText);
        group.getChildren().add(timeText);
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
