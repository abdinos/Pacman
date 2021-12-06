package gameengine.input;

import gameengine.gamecore.GameCore;
import gameengine.gamecore.GenericEntity;
import gameengine.physicsengine.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputEngine implements KeyListener {
    private GenericEntity sprite;
    private JFrame frame;
    private GameCore gameCore;
    public InputEngine(GenericEntity genericEntity, JFrame frame, GameCore gameCore){
        this.sprite=genericEntity;
        this.frame= frame;
        frame.addKeyListener(this);
        this.gameCore=gameCore;
    }

    public GenericEntity getSprite() {
        return sprite;
    }

    public void setSprite(GenericEntity sprite) {
        this.sprite = sprite;
        

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        switch(key) {
            case KeyEvent.VK_UP:

                getSprite().getPhysicEntity().setDirection(Direction.UP);
                gameCore.refresh();
                gameCore.resolveCollision(getSprite());

                break;
            case KeyEvent.VK_DOWN:

                    getSprite().getPhysicEntity().setDirection(Direction.DOWN);
                gameCore.refresh();
                gameCore.resolveCollision(getSprite());
                break;

            case KeyEvent.VK_LEFT:

                    getSprite().getPhysicEntity().setDirection(Direction.LEFT);
                gameCore.refresh();
                gameCore.resolveCollision(getSprite());

                break;
            case KeyEvent.VK_RIGHT:
                    getSprite().getPhysicEntity().setDirection(Direction.RIGHT);
                gameCore.refresh();
                gameCore.resolveCollision(getSprite());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
