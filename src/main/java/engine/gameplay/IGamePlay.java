package engine.gameplay;

import java.io.IOException;

public interface IGamePlay {
    int getEntitiesRowCounter();

    void setEntitiesRowCounter(int entitiesRowCounter);

    int getEntitiesColumnCounter();

    void setEntitiesColumnCounter(int entitiesColumnCounter);

    int getEntitiesNumber();

    void setEntitiesNumber(int entitiesNumber);

    int getStaticEntitySize();

    void setStaticEntitySize(int staticEntitySize);

    String[][] getMapData();

    void setMapData(String[][] mapData);

    void generateMap(String fileName) throws IOException;

    void resolveMap() throws IOException;
}
