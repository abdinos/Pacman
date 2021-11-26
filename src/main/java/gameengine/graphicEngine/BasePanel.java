package gameengine.graphicEngine;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasePanel extends JPanel {
    List<GraphicEntity> graphicEntities;

    public BasePanel(){
        graphicEntities = new ArrayList<>();
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
        super.paintComponent(graphic);
    }
    void paintGraphicEntity(Graphics graphic){
        graphic.setColor(Color.PINK);
        for (GraphicEntity graphicEntity : graphicEntities){
            graphic.drawImage(graphicEntity.getImage(), (int)graphicEntity.getX(),(int)graphicEntity.getY(),graphicEntity.getWidth(),graphicEntity.getHeight(),null);
        }
    }
}
