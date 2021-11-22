package main;

import gameengine.physicsengine.Direction;;
import gameengine.physicsengine.Entity;

public class Main {
    public static void main(String[] args) {
        Entity entity1 = new Entity(3,3,5,5,20,null);
        Entity entity2 = new Entity(23,23,15,20,0,null);
        entity1.moveToWantedDirection(Direction.RIGHT);
        System.out.println(entity1.toString());
        entity1.moveToWantedDirection(Direction.UP);
        System.out.println(entity1.toString());
        System.out.println(entity2.toString());
        System.out.println(entity1.getHitbox().intersects(entity2.getHitbox()));

    }
}
