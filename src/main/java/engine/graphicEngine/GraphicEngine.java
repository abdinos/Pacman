package engine.graphicEngine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphicEngine implements IGraphicEngine {
    private BasePanel basePanel;
    private MenuPanel menuPanel;
    private final JFrame frame;


    public GraphicEngine(int width, int height) {
        this.frame = new JFrame();
        frame.setSize(width, height);
        frame.setTitle("PACMAN!");
        this.basePanel = new BasePanel(width, height);
        frame.setLayout(new BorderLayout());
        //frame.getContentPane().add(basePanel,BorderLayout.CENTER);
        frame.add(basePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void setBasePanel(BasePanel basePanel) {
        this.basePanel = basePanel;
    }

    @Override
    public BasePanel getBasePanel() {
        return this.basePanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    @Override
    public List<GraphicEntity> getEntities() {
        return basePanel.getGraphicEntities();
    }

    @Override
    public void repaint() {
        basePanel.repaint();
    }

    @Override
    public void addEntity(GraphicEntity entity) {
        this.getBasePanel().addEntity(entity);
    }

    @Override
    public List<GraphicEntity> removeEntity(GraphicEntity entity) {
        basePanel.deleteEntity(entity);
        return basePanel.getGraphicEntities();
    }

    public void clearBasePanel() {
        basePanel.clearEntities();
    }

    public void removeEntities(List<GraphicEntity> graphicEntities) {
        for (GraphicEntity entity : graphicEntities) {
            basePanel.deleteEntity(entity);
        }
    }


}
