package engine.gameplay;

import engine.gamecore.GenericEntity;
import engine.graphicEngine.GraphicEntity;
import engine.physicsengine.StaticPhysicEntity;

import java.awt.*;

public class Pacman extends GenericEntity {
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    private Image image;
    private int speed;


    public Pacman(StaticPhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }



}






