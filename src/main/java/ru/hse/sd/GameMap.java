package ru.hse.sd;

import ru.hse.sd.config.Config;
import ru.hse.sd.config.MapConfig;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    // TODO: can we store only List<Rooms>. We dont even need to know how
    // TODO: rooms actually connected
    private List<List<Room>> rooms;

    public List<List<Room>> getRooms() { return rooms; }

    public GameMap(Config gameConfig) {
        MapConfig mapConfig = gameConfig.getMapConfig();
        rooms = new ArrayList<>(mapConfig.getYSizeLimit());
        for (int y = 0; y < mapConfig.getYSizeLimit(); ++y) {
            var column = new ArrayList<Room>(mapConfig.getXSizeLimit());
            for (int x = 0; x < mapConfig.getXSizeLimit(); ++x) {
                column.add(new Room(gameConfig, y * mapConfig.getYSizeLimit() + x));
            }
            rooms.add(column);
        }
    }
}
