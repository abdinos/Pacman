package gameengine.input;

import gameengine.gamecore.GameCore;
import gameengine.gamecore.GenericEntity;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class InputEngine implements KeyListener {
    private GenericEntity sprite;
    private final GameCore gameCore;
    public InputEngine(GenericEntity genericEntity,GameCore gameCore){
        this.sprite=genericEntity;
        gameCore.getGraphicEngine().getFrame().addKeyListener(this);
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

        // si le PacMan ne bouge plus à  cause d'un Mur en face de lui, il peut changer de
        // direction et ne plus être bloqué
        //
        // si le PacMan ne bouge plus à  cause d'un Fantome, le Fantome en question le
        // REbloquera instantanément
      //  pacman.setBloque(false);

        switch(key) {
            case KeyEvent.VK_UP:
                if (getSprite().getPhysicEntity().getY() - getSprite().getPhysicEntity().getVelocity()>=0)

                    getSprite().getPhysicEntity().setDirection(Direction.UP);

                gameCore.refresh();
                break;
            case KeyEvent.VK_DOWN:
                if (getSprite().getPhysicEntity().getY() + getSprite().getPhysicEntity().getVelocity()<gameCore.getGraphicEngine().getFrame().getHeight()-(getSprite().getPhysicEntity().getHeight()+1))

                    getSprite().getPhysicEntity().setDirection(Direction.DOWN);

                gameCore.refresh();
                break;

            case KeyEvent.VK_LEFT:
                if ((getSprite().getPhysicEntity().getX() - getSprite().getPhysicEntity().getVelocity())>=0)

                    getSprite().getPhysicEntity().setDirection(Direction.LEFT);

                gameCore.refresh();
                break;
            case KeyEvent.VK_RIGHT:
                if ((getSprite().getPhysicEntity().getX() + getSprite().getPhysicEntity().getVelocity())<gameCore.getGraphicEngine().getFrame().getWidth()-(getSprite().getPhysicEntity().getWidth()))

                    getSprite().getPhysicEntity().setDirection(Direction.RIGHT);



            /**    sprite.setDirection(Direction.RIGHT);
                sprite.move();
                try {
                    gameCore.getGraphicEngine().addEntity(gameCore.physicToGraphic(sprite));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
                gameCore.refresh();
                break;
            /**    case KeyEvent.VK_M:
             // couper la musique
             break;
             case KeyEvent.VK_Q:
             Jeu.arretImmediat = true;
             Jeu.finDuJeu = true*/
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
