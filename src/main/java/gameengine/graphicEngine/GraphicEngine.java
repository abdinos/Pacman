package gameengine.graphicEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GraphicEngine {
    private BasePanel basePanel ;
    private MenuPanel menuPanel;
    private JFrame frame;


    public GraphicEngine(int width , int height) {
        this.frame = new JFrame();
        frame.setSize(width,height);
        frame.setTitle("PACMAN!");
        this.basePanel = new BasePanel(width,height);
        frame.setLayout(null);
        basePanel.setBounds(0,0,width,height);
        frame.add(basePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setBasePanel(BasePanel basePanel) {
        this.basePanel = basePanel;
    }

    public BasePanel getBasePanel(){
        return this.basePanel;
    }

    public MenuPanel getMenuPanel(){
        return menuPanel;
    }
    public List<GraphicEntity> getEntities(){
        return basePanel.getGraphicEntities();
    }

    public void repaint(){
        basePanel.repaint();
    }

    public void addEntity(GraphicEntity entity)  {
        this.getBasePanel().addEntity(entity);
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
