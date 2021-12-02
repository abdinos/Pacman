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
    private JFrame frame;
    private GameCore gameCore;
    public InputEngine(GenericEntity genericEntity, JFrame frame,GameCore gameCore){
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

        // si le PacMan ne bouge plus à  cause d'un Mur en face de lui, il peut changer de
        // direction et ne plus être bloqué
        //
        // si le PacMan ne bouge plus à  cause d'un Fantome, le Fantome en question le
        // REbloquera instantanément
      //  pacman.setBloque(false);

        switch(key) {
            case KeyEvent.VK_UP:
                //if (getSprite().getPhysicEntity().getY() - getSprite().getPhysicEntity().getVelocity()>=0)

                getSprite().getPhysicEntity().setDirection(Direction.UP);
                gameCore.refresh();
                if(gameCore.physicsEngine.getCollidedEntities().containsKey(getSprite().getPhysicEntity())){
                        for (PhysicEntity  fruit : gameCore.physicsEngine.getCollidedEntities().get(getSprite().getPhysicEntity())) {
                            if (!fruit.isSolid() )
                                gameCore.removeGenericEntity(gameCore.getGenericFromPhysic(fruit));
                        }

                }

                break;
            case KeyEvent.VK_DOWN:
                //if (getSprite().getPhysicEntity().getY() + getSprite().getPhysicEntity().getVelocity()<gameCore.getGraphicEngine().getBasePanel().getHeight()-(getSprite().getPhysicEntity().getHeight()+1))

                    getSprite().getPhysicEntity().setDirection(Direction.DOWN);
                gameCore.refresh();
                if(gameCore.physicsEngine.getCollidedEntities().containsKey(getSprite().getPhysicEntity())){
                        for (PhysicEntity  fruit : gameCore.physicsEngine.getCollidedEntities().get(getSprite().getPhysicEntity())) {
                            if (!fruit.isSolid() && fruit != null)
                                gameCore.removeGenericEntity(gameCore.getGenericFromPhysic(fruit));
                        }
                }
                break;

            case KeyEvent.VK_LEFT:
                //if ((getSprite().getPhysicEntity().getX() - getSprite().getPhysicEntity().getVelocity())>=0)

                    getSprite().getPhysicEntity().setDirection(Direction.LEFT);
                gameCore.refresh();
                if(gameCore.physicsEngine.getCollidedEntities().containsKey(getSprite().getPhysicEntity())){
                        for (PhysicEntity  fruit : gameCore.physicsEngine.getCollidedEntities().get(getSprite().getPhysicEntity())) {
                            if (!fruit.isSolid() && fruit != null)
                                gameCore.removeGenericEntity(gameCore.getGenericFromPhysic(fruit));
                    }

                }

                break;
            case KeyEvent.VK_RIGHT:
                //if ((getSprite().getPhysicEntity().getX() + getSprite().getPhysicEntity().getVelocity())<gameCore.getGraphicEngine().getBasePanel().getWidth()-(getSprite().getPhysicEntity().getWidth()))

                    getSprite().getPhysicEntity().setDirection(Direction.RIGHT);
                gameCore.refresh();
                if(gameCore.physicsEngine.getCollidedEntities().containsKey(getSprite().getPhysicEntity())){
                        for (PhysicEntity  fruit : gameCore.physicsEngine.getCollidedEntities().get(getSprite().getPhysicEntity())) {
                            if (!fruit.isSolid() && fruit != null)
                                gameCore.removeGenericEntity(gameCore.getGenericFromPhysic(fruit));
                        }

                }
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
