package gameplay;

import gameengine.gamecore.GameCore;
import gameengine.graphicEngine.BasePanel;

import java.util.ArrayList;
import java.util.logging.Level;

public class Game {

    Sprite sprite;
    ArrayList<Ghost> ghosts;
    Ghost blinky;
    Ghost inky;
    Ghost clyde;
    Ghost pinky;
    BasePanel basePanel;
    GameCore gameCore;
    public int nbOfLives;
    public int score;
    public int time;
    public int spawn;
    public Level level;


    public void start(BasePanel basePanel) throws Exception {

        this.basePanel = basePanel;
    }

    public void setLevel(Level level) {
        this.level = level;

    }
}
