package gameengine.graphicEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GraphicEngineSwing {
    private BasePanel basePanel ;
    private MenuPanel menuPanel;
    private JFrame frame;


    public GraphicEngineSwing(int width , int height) {
        this.frame = new JFrame();
        frame.setSize(width,height);
        frame.setTitle("PACMAN!");
        this.basePanel = new BasePanel();
        frame.setLayout(new BorderLayout());
        //frame.getContentPane().add(basePanel,BorderLayout.CENTER);
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

    public List<GraphicEntity> addEntity(GraphicEntity entity) throws IOException {
       //  this.basePanel.addEntity(entity);
       // JLabel pic = new JLabel(new ImageIcon(ImageIO.read(new File("src\\main\\resources\\Images\\Titre.png"))));
      //  JLabel label= new JLabel(new ImageIcon (entity.getImage()));
       // this.getBasePanel().add(label);
        this.getBasePanel().addEntity(entity);
      //  System.out.println("size "+this.getBasePanel().getGraphicEntities().size());

       // this.getBasePanel().updateUI();
       // basePanel.repaint();
       // this.getFrame().validate();

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
    public void getGameState() {
        basePanel.repaint();
    }












































}
