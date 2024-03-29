package gameengine.graphicEngine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasePanel extends JPanel {
    private List<GraphicEntity> graphicEntities;

    public BasePanel(int width , int height){
        graphicEntities = new ArrayList<>();
        setSize(width,height);
    }

    public List<GraphicEntity> getGraphicEntities() {
        return graphicEntities;
    }

    public void setGraphicEntities(List<GraphicEntity> graphicEntities) {
        this.graphicEntities = graphicEntities;
    }

    public void deleteEntity(GraphicEntity entity){
        int x = graphicEntities.indexOf(entity);
        graphicEntities.remove(x);
    }
    public void deleteEntity(int index){
        graphicEntities.remove(index);
    }
    public void clearEntities(){
        graphicEntities.clear();
    }
    public void addEntity(GraphicEntity entity){

        graphicEntities.add(entity);

    }
    public GraphicEntity getEntity(int index){
      return   graphicEntities.get(index);
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        this.paintGraphicEntity(graphic);
    }

    void paintGraphicEntity(Graphics graphic){
        graphic.setColor(Color.black);
        graphic.fillRect(0,0,this.getWidth(),this.getHeight());
        for (GraphicEntity genericEntity:graphicEntities){
            graphic.drawImage(genericEntity.getImage(),genericEntity.getX(),
                    genericEntity.getY(),genericEntity.getWidth(),genericEntity.getHeight(),null);

        }
    }
}
