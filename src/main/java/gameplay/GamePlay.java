package gameplay;

import gameengine.gamecore.GameCore;
import gameengine.gamecore.GenericEntity;
import gameengine.graphicEngine.GraphicEntity;
import gameengine.physicsengine.Direction;
import gameengine.physicsengine.PhysicEntity;

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

        public GamePlay(int entitiesRowCounter, int entitiesColumnCounter, int staticEntitySize,GameCore gamecore) {
            this.entitiesRowCounter = entitiesRowCounter;
            this.entitiesColumnCounter = entitiesColumnCounter;
            this.entitySize = staticEntitySize;
            this.mapData = new String[entitiesRowCounter][entitiesColumnCounter];
            this.gameCore = gamecore;
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
                            Image img=ImageIO.read(new File("src\\main\\resources\\Images\\WALL.png"));
                            int width=gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length+1;
                            int height=gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length+1;
                            int x= i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length;
                            int y=j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length;
                            GenericEntity entity= new GenericEntity(new PhysicEntity(x,y,width,height,0,null,false,true),new GraphicEntity(x,y,img,width,height));
                 //           GraphicEntity entity= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,ImageIO.read(new File("src\\main\\resources\\Images\\WALL.png")));
                            gameCore.addGenericEntity(entity);
                            break;
                        case "B":
                            Image img1=ImageIO.read(new File("src\\main\\resources\\Images\\BELL.png"));
                            int width1=gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5;
                            int height1=gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5;
                            int x1=i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length;
                            int y1=j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length;
         //                   GraphicEntity entity1= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,img1);
                            GenericEntity entity1= new GenericEntity(new PhysicEntity(x1,y1,width1,height1,0,null,false,true),new GraphicEntity(x1,y1,img1,width1,height1));
        //                    entity1.setWidth(gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5);
         //                   entity1.setHeight(gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5);
                            gameCore.addGenericEntity(entity1);
                            break;
                        case "F":
        //                    GraphicEntity entity2= new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,ImageIO.read(new File("src\\main\\resources\\Images\\MELON.png")));
                            GenericEntity entity2 = new GenericEntity(new PhysicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5,gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5,20,null,false,false),new GraphicEntity(i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length,j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length,ImageIO.read(new File("src\\main\\resources\\Images\\MELON.png")),gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5,gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5));
        //                    entity2.setWidth(gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5);
        //                    entity2.setHeight(gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5);
                            gameCore.addGenericEntity(entity2);
                            break;
                        case "P":
                            Image img3=ImageIO.read(new File("src\\main\\resources\\Images\\APPLE.png"));
                            int width3=gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length-5;
                            int height3=gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length-5;
                            int x3=i*gameCore.graphicEngine.getBasePanel().getWidth()/getMapData()[0].length;
                            int y3=j*gameCore.graphicEngine.getBasePanel().getHeight()/getMapData().length;
                            GenericEntity entity3= new GenericEntity(new PhysicEntity(x3,y3,width3,height3,5, Direction.RIGHT,true,false),new GraphicEntity(x3,y3,img3,width3,height3));
                            entity3.setId(1991);
                            gameCore.addGenericEntity(entity3);
                            break;
                        default:
                            break;
                    }
                }

            }
            gameCore.graphicEngine.getBasePanel().repaint();



        }


    }
