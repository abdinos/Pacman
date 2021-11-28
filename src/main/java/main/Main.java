package main;

import gameengine.graphicEngine.*;
;
import gameengine.physicsengine.PhysicEntity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PhysicEntity physicEntity1 = new PhysicEntity(3,3,5,5,20,null,true);
        PhysicEntity physicEntity2 = new PhysicEntity(23,23,15,20,2,null,false);
        Map map = new Map(18,17,16);
        map.generateMap("Map");
    //    GraphicEngine graphicEngine =  new GraphicEngine(map);
    //    graphicEngine.reloadWorldMap(map);

        //JFrame frame = new JFrame();
       // frame.setTitle("PACMAN!");
       // frame.setSize(800, 500);
        BasePanel panel= new BasePanel();
        GraphicEntity ge= new GraphicEntity(150,20,ImageIO.read(new File("src\\main\\resources\\Images\\Titre.png")));
        GraphicEntity ghost= new GraphicEntity(200,200,ImageIO.read(new File("src\\main\\resources\\Images\\Pacman.gif")));
        GraphicEngine gs = new GraphicEngine(800,500);
        ghost.setHeight(80);
       // gs.setBasePanel(panel);
        gs.addEntity(ge);
        gs.addEntity(ghost);
        gs.repaint();
       // System.out.println(gs.getBasePanel().getComponent(0));
      /**  JLabel pic = new JLabel(new ImageIcon(ImageIO.read(new File("src\\main\\resources\\Images\\Titre.png"))));
        pic.setBackground(Color.PINK);
        pic.setVerticalAlignment(JLabel.BOTTOM);
        pic.setHorizontalAlignment(JLabel.CENTER);
        System.out.println(ge);
        panel.add(pic);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }
}
