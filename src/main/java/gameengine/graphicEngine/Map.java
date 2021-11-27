package gameengine.graphicEngine;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
public class Map {

    private int entitiesRowCounter ;
    private int entitiesColumnCounter;
    private static int entitiesNumber ;
    private int staticEntitySize ;
    private String [][] mapData;

    public Map(int entitiesRowCounter, int entitiesColumnCounter, int staticEntitySize) {
        this.entitiesRowCounter = entitiesRowCounter;
        this.entitiesColumnCounter = entitiesColumnCounter;
        this.staticEntitySize = staticEntitySize;
        this.mapData = new String[entitiesRowCounter][entitiesColumnCounter];
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

    public static int getEntitiesNumber() {
        return entitiesNumber;
    }

    public static void setEntitiesNumber(int entitiesNumber) {
        Map.entitiesNumber = entitiesNumber;
    }

    public int getStaticEntitySize() {
        return staticEntitySize;
    }

    public void setStaticEntitySize(int staticEntitySize) {
        this.staticEntitySize = staticEntitySize;
    }

    public String[][] getMapData() {
        return mapData;
    }

    public void setMapData(String[][] mapData) {
        this.mapData = mapData;
    }

    public void generateMap() {

        try (Scanner fileScanner = new Scanner(Objects.requireNonNull(Map.class.getClassLoader().getResourceAsStream("Map")))) {
            for (int i = 0; i< entitiesRowCounter;i++){
                String line = fileScanner.nextLine();
                String[] elements = line.split(" ");
                for (int j = 0 ; j< entitiesColumnCounter;j++){
                    mapData[i][j] =  elements[j];
                }
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Map map = new Map(18,17,16);
        map.generateMap();
        System.out.println();
    }


}
