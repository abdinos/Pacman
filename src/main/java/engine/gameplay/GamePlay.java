package engine.gameplay;

import engine.gamecore.GameCore;
import engine.gamecore.GenericEntity;
import engine.graphicEngine.GraphicEntity;
import engine.physicsengine.Direction;
import engine.physicsengine.MovablePhysicEntity;
import engine.physicsengine.StaticPhysicEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class GamePlay implements IGamePlay {
    private int entitiesRowCounter;
    private int entitiesColumnCounter;
    private int entitiesNumber;
    private int entitySize;
    private String[][] mapData;
    private final GameCore gameCore;

    public GamePlay(int entitiesRowCounter, int entitiesColumnCounter, int staticEntitySize, GameCore gamecore) {
        this.entitiesRowCounter = entitiesRowCounter;
        this.entitiesColumnCounter = entitiesColumnCounter;
        this.entitySize = staticEntitySize;
        this.mapData = new String[entitiesRowCounter][entitiesColumnCounter];
        this.gameCore = gamecore;
    }


    @Override
    public int getEntitiesRowCounter() {
        return entitiesRowCounter;
    }

    @Override
    public void setEntitiesRowCounter(int entitiesRowCounter) {
        this.entitiesRowCounter = entitiesRowCounter;
    }

    @Override
    public int getEntitiesColumnCounter() {
        return entitiesColumnCounter;
    }

    @Override
    public void setEntitiesColumnCounter(int entitiesColumnCounter) {
        this.entitiesColumnCounter = entitiesColumnCounter;
    }

    @Override
    public int getEntitiesNumber() {
        return entitiesNumber;
    }

    @Override
    public void setEntitiesNumber(int entitiesNumber) {
        this.entitiesNumber = entitiesNumber;
    }

    @Override
    public int getStaticEntitySize() {
        return entitySize;
    }

    @Override
    public void setStaticEntitySize(int staticEntitySize) {
        this.entitySize = staticEntitySize;
    }

    @Override
    public String[][] getMapData() {
        return mapData;
    }

    @Override
    public void setMapData(String[][] mapData) {
        this.mapData = mapData;
    }


    @Override
    public void generateMap(String fileName)  {

        try (Scanner fileScanner = new Scanner(Objects.requireNonNull(GamePlay.class.getClassLoader().getResourceAsStream(fileName)))) {
            for (int i = 0; i < entitiesRowCounter; i++) {
                String line = fileScanner.nextLine();
                String[] elements = line.split(" ");
                for (int j = 0; j < entitiesColumnCounter; j++) {
                    mapData[i][j] = elements[j];
                }
            }
        }

    }

    @Override
    public void resolveMap() throws IOException {
        for (int i = 0; i < getMapData().length; i++) {
            for (int j = 0; j < getMapData()[i].length; j++) {
                String element = getMapData()[i][j];
                switch (element) {
                    case "W":
                        Image img = ImageIO.read(Objects.requireNonNull(GamePlay.class.getClassLoader().getResourceAsStream("WALL.png")));
                        int width = gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length;
                        int height = gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length;
                        int x = i * gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length;
                        int y = j * gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length;
                        GenericEntity entity = new GenericEntity(new StaticPhysicEntity(x, y, width, height), new GraphicEntity(x, y, img, width, height));
                        //           GraphicEntity entity= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,ImageIO.read(new File("src\\main\\resources\\Images\\WALL.png")));
                        gameCore.addGenericEntity(entity);
                        break;
                    case "B":
                        Image img1 = ImageIO.read(Objects.requireNonNull(GamePlay.class.getClassLoader().getResourceAsStream("BLOCK.png")));
                        int width1 = gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length - 5;
                        int height1 = gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length - 5;
                        int x1 = i * gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length;
                        int y1 = j * gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length;
                        GenericEntity entity1 = new GenericEntity(new StaticPhysicEntity(x1, y1, width1, height1), new GraphicEntity(x1, y1, img1, width1, height1));
                        gameCore.addGenericEntity(entity1);
                        break;
                    case "F":
                        int x2 = i * gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length;
                        int y2 = j * gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length;
                        int width2 = gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length - 5;
                        int height2 = gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length - 5;
                        Image img2 = ImageIO.read(Objects.requireNonNull(GamePlay.class.getClassLoader().getResourceAsStream("MELON.png")));
                        GenericEntity entity2 = new GenericEntity(new StaticPhysicEntity(x2, y2, width2, height2), new GraphicEntity(x2, y2, img2, width2, height2));
                        entity2.getPhysicEntity().setSolid(false);
                        gameCore.addGenericEntity(entity2);
                        break;
                    case "P":
                        Image img3 = ImageIO.read(Objects.requireNonNull(GamePlay.class.getClassLoader().getResourceAsStream("PAC1.png")));
                        int width3 = gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length - 5;
                        int height3 = gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length - 5;
                        int x3 = i * gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length;
                        int y3 = j * gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length;
                        int velocity = (gameCore.getGraphicEngine().getBasePanel().getWidth() / getMapData()[0].length + gameCore.getGraphicEngine().getBasePanel().getHeight() / getMapData().length) / 2;
                        GenericEntity entity3 = new GenericEntity(new MovablePhysicEntity(x3, y3, width3, height3, velocity, Direction.RIGHT, false), new GraphicEntity(x3, y3, img3, width3, height3));
                        entity3.setId(1991);
                        gameCore.addGenericEntity(entity3);
                        break;
                    default:
                        break;
                }
            }

        }
        gameCore.getGraphicEngine().getBasePanel().repaint();


    }


}
