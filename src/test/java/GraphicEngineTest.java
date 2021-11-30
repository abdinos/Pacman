import gameengine.graphicEngine.GraphicEntity;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class GraphicEngineTest {
    int [][]data;
    GraphicEngineTest()throws IOException{
        this.data = new int[][]{{0,1,1,3,0,2},{3,1,0,0,1,2},{0,0,1,1,3,2}};

        Set<GraphicEntity> entities = new HashSet<>();

        int x= 0;
        int y=0;
        int height= 15;
        int witdh= 15;




        for(int i=0; i< data.length; i++) {

            for (int j = 0; j < data[j].length; j++) {

                 int currentType= data[i][j];
                 switch (currentType){
                     case 0: // pacman
                         entities.add(new GraphicEntity(x,y, ImageIO.read(new File("resources/Images/PAC1.png"))));
                         break;
                     case 1: // Mur
                         entities.add(new GraphicEntity(x,y, ImageIO.read(new File("resources/Images/Titre.png"))));
                         break;
                     case 2: // Monstre
                         entities.add(new GraphicEntity(x,y, ImageIO.read(new File("resources/Images/WHITE1.png"))));
                         break;
                     case 3: // Mur
                         entities.add(new GraphicEntity(x,y, ImageIO.read(new File("resources/Images/zqsd.png"))));
                         break;


                 }
                 x +=(witdh);

            }

            y +=(height);
            x = 0;
        }


    }
















}
