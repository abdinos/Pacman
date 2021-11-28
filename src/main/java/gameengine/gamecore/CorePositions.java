package gameengine.gamecore;

import gameengine.graphicEngine.GraphicEngineSwing;
import gameengine.physicsengine.PhysicEntity;
import gameengine.physicsengine.PhysicsEngine;

public class CorePositions {

    private GraphicEngineSwing graphicEngineSwing;
    private PhysicsEngine physicsEngine;

    public CorePositions(GraphicEngineSwing graphicEngineSwing, PhysicsEngine physicsEngine) {
        this.graphicEngineSwing = graphicEngineSwing;
        this.physicsEngine = physicsEngine;
    }

    public GraphicEngineSwing getGraphicEngineSwing() {
        return graphicEngineSwing;
    }

    public void setGraphicEngineSwing(GraphicEngineSwing graphicEngineSwing) {
        this.graphicEngineSwing = graphicEngineSwing;
    }

    public void setPhysicsEngine(PhysicsEngine physicsEngine) {
        this.physicsEngine = physicsEngine;
    }

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }


}
