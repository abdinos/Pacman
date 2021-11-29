package gameplay;

import gameengine.gamecore.GenericEntity;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.PhysicEntity;

import java.awt.*;

public class Pacman extends GenericEntity {
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    private Image image;

    public Pacman(PhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }
}


