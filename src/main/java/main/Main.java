package main;

import gameengine.graphicEngine.GraphicEngine;
import gameengine.graphicEngine.Map;
import gameengine.physicsengine.Direction;;
import gameengine.physicsengine.PhysicEntity;

public class Main {
    public static void main(String[] args) {
        PhysicEntity physicEntity1 = new PhysicEntity(3,3,5,5,20,null,true);
        PhysicEntity physicEntity2 = new PhysicEntity(23,23,15,20,2,null,false);
        Map map = new Map(18,17,16);
        map.generateMap();
        GraphicEngine graphicEngine =  new GraphicEngine(map);
        graphicEngine.reloadWorldMap(map);



    }
}
