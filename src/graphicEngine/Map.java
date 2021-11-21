package src.graphicEngine;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import src.main.java.PhysicsEngine.Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    private ArrayList<Entity> entities = new ArrayList<>();
    private int entitiesRowCounter = 0;
    private int entitiesColumnCounter = 0;
    private static int entitiesNumber = 0;
    private int staticEntitySize = 16;



    public static String generate() throws FileNotFoundException {

        try (Scanner fileScanner = new Scanner(Map.class.getClassLoader().getResourceAsStream("Map"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                             while (lineScanner.hasNext()) {
                    entitiesNumber++;
                    String[] elements = lineScanner.next().split("(?!^)");
                    switch (elements[0]) {
                        case "W":
                            if (elements.length >= 2 && elements[0].equals("W")) {
                                String wall = "wall";
                                System.out.println(wall);
                            }
                            break;
                        case "F":
                            String fruit =".";
                            System.out.println(fruit);
                         break;
                        case "B":
                            String bloc = "*";
                            System.out.println(bloc);
                    }
                }
                lineScanner.close();

            }

        }
        return "j";
    }

    public static void main (String []args) throws FileNotFoundException {
        System.out.println(Map.generate());
    }
}
