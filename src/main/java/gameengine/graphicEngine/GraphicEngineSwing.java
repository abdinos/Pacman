package gameengine.graphicEngine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphicEngineSwing {
    BasePanel basePanel ;



    public GraphicEngineSwing(int width , int height) {
        JFrame frame = new JFrame();
        frame.setSize(width,height);
        basePanel = new BasePanel();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(basePanel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public BasePanel getBasePanel(){
        return this.basePanel;
    }
    public List<GraphicEntity> getEntities(){
        return basePanel.getGraphicEntities();
    }

    public void repaint(){
        basePanel.repaint();
    }

    public List<GraphicEntity> addEntity(GraphicEntity entity){
         basePanel.addEntity(entity);
         return basePanel.getGraphicEntities();
    }
    public List<GraphicEntity> removeEntity(GraphicEntity entity){
        basePanel.deleteEntity(entity);
        return basePanel.getGraphicEntities();
    }
    public void clearBasePanel(){
        basePanel.clearEntities();
    }
    public void removeEntities(List<GraphicEntity> graphicEntities){
        for (GraphicEntity entity : graphicEntities){
            basePanel.deleteEntity(entity);
        }
    }










































}
