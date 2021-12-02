package gameplay;

import gameengine.gamecore.GenericEntity;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.PhysicEntity;

public class Ghost extends GenericEntity {

    int id;
    int status;
    public boolean exitedHouse;
    String OriginalColor;


    public Ghost(PhysicEntity physicEntity, GraphicEntity graphicEntity) {
        super(physicEntity, graphicEntity);
    }
}
