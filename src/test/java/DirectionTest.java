import PhysicsEngine.Directions;
import PhysicsEngine.Entity;
import PhysicsEngine.Mouvements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    private Entity testEntity1 = new Entity(4, 3, 40,30);


    @Test
    public void rightMovementTest() {
        Mouvements right = new Mouvements(testEntity1, Directions.RIGHT);
        right.move();
        assertEquals(44, testEntity1.getX());

    }
    @Test
    public void leftMovementTest() {
        Mouvements left = new Mouvements(testEntity1, Directions.LEFT);
        left.move();
        assertEquals(-36, testEntity1.getX());
    }
    @Test
    public void upMovementTest() {
        Mouvements up = new Mouvements(testEntity1, Directions.UP);
        up.move();
        assertEquals(43, testEntity1.getY());
    }
    @Test
    public void downMovementTest() {
        Mouvements down = new Mouvements(testEntity1, Directions.DOWN);
        down.move();
        assertEquals(-37, testEntity1.getY());
    }


}