package main;

import gameengine.gamecore.GameCore;
import gameplay.GamePlay;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameCore gameCore = new GameCore(588,588,20);
        GamePlay gamePlay = new GamePlay(20,20,1,gameCore);
        gamePlay.generateMap("FinalMap.txt");
        gamePlay.resolveMap();
        gameCore.getInput().setSprite(gameCore.getPac());
        gameCore.refresh();


    }
}


