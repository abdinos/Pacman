package gameplay;

import gameengine.gamecore.GameCore;
import gameengine.graphicEngine.BasePanel;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.PhysicEntity;

import java.util.ArrayList;
import java.util.logging.Level;

public class Game  {

  Pacman pacman;
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

        this.basePanel=basePanel;
    }

  public void setLevel(Level level)
  {
    this.level = level;

  }


    public static class GenericEntity {
        private static int id_count = 0;
        private int id;
        PhysicEntity physicEntity;
        GraphicEntity graphicEntity;

        public GenericEntity( PhysicEntity physicEntity, GraphicEntity graphicEntity) {
            this.id = id_count++;
            this.physicEntity = physicEntity;
            this.graphicEntity = graphicEntity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PhysicEntity getPhysicEntity() {
            return physicEntity;
        }

        public void setPhysicEntity(PhysicEntity physicEntity) {
            this.physicEntity = physicEntity;
        }

        public GraphicEntity getGraphicEntity() {
            return graphicEntity;
        }

        public void setGraphicEntity(GraphicEntity graphicEntity) {
            this.graphicEntity = graphicEntity;
        }
    }
}
