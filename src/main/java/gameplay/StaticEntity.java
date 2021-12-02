package gameplay;

import java.awt.*;

public interface StaticEntity extends Entity{

    public BoxCollider boxCollider();

    public boolean isColliding(Entity other);

    public void setColor(Color color);


}
