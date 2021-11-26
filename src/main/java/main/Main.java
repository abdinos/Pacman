package main;

import gameengine.graphicEngine.GraphicEngine;
import gameengine.graphicEngine.Map;
import gameengine.physicsengine.Direction;;
import gameengine.physicsengine.Entity;

public class Main {
    public static void main(String[] args) {
        Entity entity1 = new Entity(3,3,5,5,20,null,true);
        Entity entity2 = new Entity(23,23,15,20,2,Direction.RIGHT,false);
        Map map = new Map(18,17,16);
        map.generateMap();
        GraphicEngine graphicEngine =  new GraphicEngine(map);
        graphicEngine.reloadWorldMap(map);



    }
}
