import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    private PhysicEntity testPhysicEntity1 = new PhysicEntity(4, 3, 40,20,15,null,true,true);


    @Test
    public void rightMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.RIGHT);
        assertEquals(19, testPhysicEntity1.getX());

    }
    @Test
    public void leftMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.LEFT);
        assertEquals(-11, testPhysicEntity1.getX());
    }
    @Test
    public void upMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.UP);
        assertEquals(18, testPhysicEntity1.getY());
    }
    @Test
    public void downMovementTest() {
        testPhysicEntity1.moveToWantedDirection(Direction.DOWN);
        assertEquals(-12, testPhysicEntity1.getY());
    }


}