package gameplay;

import gameengine.gamecore.GameCore;
import gameengine.graphicEngine.GraphicEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class GamePlay {
        private int entitiesRowCounter ;
        private int entitiesColumnCounter;
        private  int entitiesNumber ;
        private int entitySize ;
        private String [][] mapData;
        private GameCore gameCore;

        public GamePlay(int entitiesRowCounter, int entitiesColumnCounter, int staticEntitySize, int width, int height) {
            this.entitiesRowCounter = entitiesRowCounter;
            this.entitiesColumnCounter = entitiesColumnCounter;
            this.entitySize = staticEntitySize;
            this.mapData = new String[entitiesRowCounter][entitiesColumnCounter];
            this.gameCore = new GameCore(width,height,staticEntitySize);
        }


        public int getEntitiesRowCounter() {
            return entitiesRowCounter;
        }

        public void setEntitiesRowCounter(int entitiesRowCounter) {
            this.entitiesRowCounter = entitiesRowCounter;
        }

        public int getEntitiesColumnCounter() {
            return entitiesColumnCounter;
        }

        public void setEntitiesColumnCounter(int entitiesColumnCounter) {
            this.entitiesColumnCounter = entitiesColumnCounter;
        }

        public int getEntitiesNumber() {
            return entitiesNumber;
        }

        public void setEntitiesNumber(int entitiesNumber) {
            this.entitiesNumber = entitiesNumber;
        }

        public int getStaticEntitySize() {
            return entitySize;
        }

        public void setStaticEntitySize(int staticEntitySize) {
            this.entitySize = staticEntitySize;
        }

        public String[][] getMapData() {
            return mapData;
        }

        public void setMapData(String[][] mapData) {
            this.mapData = mapData;
        }


        public void generateMap(String fileName) throws IOException {

            try (Scanner fileScanner = new Scanner(Objects.requireNonNull(GamePlay.class.getClassLoader().getResourceAsStream(fileName)))) {
                for (int i = 0; i< entitiesRowCounter;i++){
                    String line = fileScanner.nextLine();
                    String[] elements = line.split(" ");
                    for (int j = 0 ; j< entitiesColumnCounter;j++){
                        mapData[i][j] =  elements[j];
                        System.out.println(getMapData()[i][j]+" "+i+ " "+j);
                    }
                }
            }

        }
        public void resolveMap() throws IOException {
            for(int i =0;i<getMapData().length;i++){
                for (int j=0;j<getMapData()[i].length;j++){
                    String element =getMapData()[i][j];
                    switch (element){
                        case "W":
                            GraphicEntity entity= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,ImageIO.read(new File("src\\main\\resources\\Images\\WALL.png")));
                            entity.setHeight(gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length+1);
                            entity.setWidth(gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length+1);
                            gameCore.graphicEngine.addEntity(entity);
                            break;
                        case "B":
                            Image img1=ImageIO.read(new File("src\\main\\resources\\Images\\BELL.png"));
                            GraphicEntity entity1= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,img1);
                            entity1.setWidth(gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5);
                            entity1.setHeight(gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5);
                            gameCore.graphicEngine.addEntity(entity1);
                            break;
                        case "F":
                            GraphicEntity entity2= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,ImageIO.read(new File("src\\main\\resources\\Images\\MELON.png")));
                            entity2.setWidth(gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5);
                            entity2.setHeight(gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5);
                            gameCore.graphicEngine.addEntity(entity2);
                            break;
                        default:
                            break;
                    }
                }

            }
            gameCore.graphicEngine.getBasePanel().repaint();



        }


    }
