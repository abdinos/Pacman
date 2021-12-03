package entity;


import engine.physicsengine.Hitbox;

public interface IEntity {

    void setSolid(boolean solid);

    Hitbox getHitbox();

    boolean isSolid();

    void setX(int previousX);

    void setY(int previousY);
}
