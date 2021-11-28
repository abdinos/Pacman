package gameengine.graphicEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class Map {

    private int entitiesRowCounter ;
    private int entitiesColumnCounter;
    private  int entitiesNumber ;
    private int entitySize ;
    private String [][] mapData;
    private GraphicEngineSwing graphicEngineSwing;

    public Map(int entitiesRowCounter, int entitiesColumnCounter, int staticEntitySize) {
        this.entitiesRowCounter = entitiesRowCounter;
        this.entitiesColumnCounter = entitiesColumnCounter;
        this.entitySize = staticEntitySize;
        this.mapData = new String[entitiesRowCounter][entitiesColumnCounter];
        this.graphicEngineSwing= new GraphicEngineSwing(800,600);
    }

    public Map(GraphicEngineSwing graphicEngineSwing,String fileName) {
        this.graphicEngineSwing = graphicEngineSwing;
        this.entitiesColumnCounter=0;
        this.entitiesRowCounter=0;
        this.entitySize=2;
        this.entitiesNumber=0;
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

    public GraphicEngineSwing getGraphicEngineSwing() {
        return graphicEngineSwing;
    }

    public void generateMap(String fileName) throws IOException {

        try (Scanner fileScanner = new Scanner(Objects.requireNonNull(Map.class.getClassLoader().getResourceAsStream(fileName)))) {
            for (int i = 0; i< entitiesRowCounter;i++){
                String line = fileScanner.nextLine();
                String[] elements = line.split(" ");
                for (int j = 0 ; j< entitiesColumnCounter;j++){
                    mapData[i][j] =  elements[j];
                    System.out.println(getMapData()[i][j]+" "+i+ " "+j);
                }
            }
        }
        resolveMap();

    }
    public void resolveMap() throws IOException {
        for(int i =0;i<getMapData().length;i++){
            for (int j=0;j<getMapData()[i].length;j++){
                switch (getMapData()[i][j]){
                    case "W":
                        GraphicEntity entity= new GraphicEntity(100+i,100+j,ImageIO.read(new File("src\\main\\resources\\Images\\BELL.png")));
                        entity.setHeight(10);
                        entity.setWidth(10);
                        getGraphicEngineSwing().addEntity(entity);break;
                    case "B":
                        Image img1=ImageIO.read(new File("src\\main\\resources\\Images\\PAC1.png"));
                        GraphicEntity entity1= new GraphicEntity(100+i,150+j,img1);
                        entity1.setHeight(10);
                        entity1.setWidth(10);
                        getGraphicEngineSwing().addEntity(entity1);break;
                    case "F":
                        GraphicEntity entity2= new GraphicEntity(200+i,200+j,ImageIO.read(new File("src\\main\\resources\\Images\\WHITE1.png")));
                        entity2.setHeight(10);
                        entity2.setWidth(10);
                        getGraphicEngineSwing().addEntity(entity2);break;
                    default:
                        break;
                }
            }
        }
        getGraphicEngineSwing().getBasePanel().repaint();
    }


}
