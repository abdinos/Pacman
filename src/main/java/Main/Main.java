package Main;

import PhysicsEngine.Directions;;
import PhysicsEngine.Entity;

public class Main {
    public static void main(String[] args) {
        Entity entity1 = new Entity(3,3,5,5,18,null);
        Entity entity2 = new Entity(23,23,15,20,0,null);
        entity1.moveToWantedDirection(entity1.getWantedDirection(Directions.RIGHT));
        System.out.println(entity1.toString());
        entity1.moveToWantedDirection(entity1.getWantedDirection(Directions.UP));
        System.out.println(entity1.toString());
        System.out.println(entity2.toString());
        System.out.println(entity1.collisionDetecter(entity2));

    }
}
