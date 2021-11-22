package gameengine.graphicEngine;

import gameengine.physicsengine.Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    private ArrayList<Entity> entities = new ArrayList<>();
    private int entitiesRowCounter = 18;
    private int entitiesColumnCounter = 17;
    private static int entitiesNumber = 306;
    private int staticEntitySize = 16;
    private String [][] mapData = new String[entitiesRowCounter][entitiesColumnCounter];


    public void mapScan() {

        try (Scanner fileScanner = new Scanner(Map.class.getClassLoader().getResourceAsStream("Map"))) {
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

    }

public Entity getEntity(int nbr) {

    return entities.get(nbr);

}

    public int getEntitiesRowCounter() {
        return entitiesRowCounter;
    }


    public int getEntitiesColumnCounter() {
        return entitiesColumnCounter;
    }



    public int getStaticEntitySize() {
        return staticEntitySize;
    }


    public int getEntitiesNumber(){
        return  entitiesNumber;
    }


    public void ClearEntity(Entity entity){
        entities.add(entity);
        entitiesNumber++;
    }
    public void removeEntity(Entity entity){
        entities.remove(entity);
        entitiesNumber--;
    }









}
