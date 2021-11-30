package gameengine.input;

import gameengine.gamecore.GameCore;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class InputEngine implements KeyListener {
    private GameCore gameCore = new GameCore(400,400,16);
    public InputEngine(){
        this.gameCore.graphicEngine.getFrame().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        PhysicEntity sprite= this.gameCore.getPhysicsEngine().getSprite();
        // si le PacMan ne bouge plus à  cause d'un Mur en face de lui, il peut changer de
        // direction et ne plus être bloqué
        //
        // si le PacMan ne bouge plus à  cause d'un Fantome, le Fantome en question le
        // REbloquera instantanément
      //  pacman.setBloque(false);

        switch(key) {
            case KeyEvent.VK_UP:
                sprite.setDirection(Direction.DOWN);
                sprite.move();
                try {
                    gameCore.getGraphicEngine().addEntity(gameCore.physicToGraphic(sprite));
                } catch (IOException ex) {
                ex.printStackTrace();
                 }
                gameCore.refresh();
                break;
            case KeyEvent.VK_DOWN:
                sprite.setDirection(Direction.UP);
                sprite.move();
                try {
                    gameCore.getGraphicEngine().addEntity(gameCore.physicToGraphic(sprite));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                gameCore.refresh();
                break;

            case KeyEvent.VK_LEFT:
                sprite.setDirection(Direction.LEFT);
                sprite.move();
                try {
                    gameCore.getGraphicEngine().addEntity(gameCore.physicToGraphic(sprite));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                gameCore.refresh();
                break;
            case KeyEvent.VK_RIGHT:
                sprite.setDirection(Direction.RIGHT);
                sprite.move();
                try {
                    gameCore.getGraphicEngine().addEntity(gameCore.physicToGraphic(sprite));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
