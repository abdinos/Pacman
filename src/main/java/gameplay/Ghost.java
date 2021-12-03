package gameplay;

import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.PhysicEntity;

public class Ghost extends Game.GenericEntity {

    int id;
    int status;
    public boolean exitedHouse;
    String OriginalColor;


    public Ghost(PhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }
}
