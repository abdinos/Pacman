package gameengine.gamecore;


import gameengine.graphicEngine.GraphicEngine;
import gameengine.graphicEngine.Map;
import gameengine.physicsengine.PhysicsEngine;

import java.io.FileNotFoundException;

public class GameCore {
    public Map map;
    public GraphicEngine graphicEngine;
    public PhysicsEngine physicsEngine;

   public Map generateMap()throws FileNotFoundException{

        return map;
   }











}