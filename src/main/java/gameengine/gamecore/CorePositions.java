package gameengine.gamecore;

import gameengine.graphicEngine.GraphicEngine;
import gameengine.physicsengine.PhysicsEngine;

public class CorePositions {

    private GraphicEngine graphicEngine;
    private PhysicsEngine physicsEngine;

    public CorePositions(GraphicEngine graphicEngine, PhysicsEngine physicsEngine) {
        this.graphicEngine = graphicEngine;
        this.physicsEngine = physicsEngine;
    }

    public GraphicEngine getGraphicEngineSwing() {
        return graphicEngine;
    }

    public void setGraphicEngineSwing(GraphicEngine graphicEngine) {
        this.graphicEngine = graphicEngine;
    }

    public void setPhysicsEngine(PhysicsEngine physicsEngine) {
        this.physicsEngine = physicsEngine;
    }

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }


}
