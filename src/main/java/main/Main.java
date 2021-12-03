package main;

import gameengine.gamecore.GameCore;
import gameengine.graphicEngine.*;
;
import gameengine.physicsengine.PhysicEntity;
import gameplay.GamePlay;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameCore gameCore = new GameCore(588,588,20);
        GamePlay gamePlay = new GamePlay(20,20,1,gameCore);
        gamePlay.generateMap("FinalMap.txt");
        gamePlay.resolveMap();
        gameCore.computeCollisions();
        gameCore.getInput().setSprite(gameCore.getGenericEntities().get(0));
        gameCore.getInput().setSprite(gameCore.getPac());
        gameCore.refresh();
    }
}


