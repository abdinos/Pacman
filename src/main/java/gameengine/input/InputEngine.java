package gameengine.input;

import gameengine.gamecore.CorePositions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputEngine implements KeyListener {
    private CorePositions corePositions;
    public InputEngine(){
        this.corePositions.getGraphicEngineSwing().getFrame().addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
