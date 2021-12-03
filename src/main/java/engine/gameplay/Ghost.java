package engine.gameplay;

import engine.gamecore.GenericEntity;
import engine.graphicEngine.GraphicEntity;
import engine.physicsengine.StaticPhysicEntity;

public class Ghost extends GenericEntity {

    int id;
    int status;
    public boolean exitedHouse;
    String OriginalColor;


    public Ghost(StaticPhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }
}
