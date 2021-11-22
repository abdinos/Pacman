import gameengine.physicsengine.Direction;
import gameengine.physicsengine.Entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    private Entity testEntity1 = new Entity(4, 3, 40,20,15,null);


    @Test
    public void rightMovementTest() {
        testEntity1.moveToWantedDirection(Direction.RIGHT);
        assertEquals(19, testEntity1.getX());

    }
    @Test
    public void leftMovementTest() {
        testEntity1.moveToWantedDirection(Direction.LEFT);
        assertEquals(-11, testEntity1.getX());
    }
    @Test
    public void upMovementTest() {
        testEntity1.moveToWantedDirection(Direction.UP);
        assertEquals(18, testEntity1.getY());
    }
    @Test
    public void downMovementTest() {
        testEntity1.moveToWantedDirection(Direction.DOWN);
        assertEquals(-12, testEntity1.getY());
    }


}