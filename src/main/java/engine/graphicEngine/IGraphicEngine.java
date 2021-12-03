package engine.graphicEngine;

import javax.swing.*;
import java.util.List;

public interface IGraphicEngine {
    JFrame getFrame();

    void setBasePanel(BasePanel basePanel);

    BasePanel getBasePanel();

    List<GraphicEntity> getEntities();

    void repaint();

    void addEntity(GraphicEntity entity);

    List<GraphicEntity> removeEntity(GraphicEntity entity);
}
