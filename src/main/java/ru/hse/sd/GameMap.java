package ru.hse.sd;

import ru.hse.sd.config.Config;
import ru.hse.sd.config.MapConfig;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private final List<List<Room>> rooms;

    public List<List<Room>> getRooms() { return rooms; }

    public GameMap(Config gameConfig) {
        MapConfig mapConfig = gameConfig.getMapConfig();
        rooms = new ArrayList<>(mapConfig.getYSizeLimit());
        for (int y = 0; y < mapConfig.getYSizeLimit(); ++y) {
            List<Room> row = new ArrayList<>(mapConfig.getXSizeLimit());
            for (int x = 0; x < mapConfig.getXSizeLimit(); ++x) {
                row.add(new Room(gameConfig, y * mapConfig.getYSizeLimit() + x, this));
            }
            rooms.add(row);
        }
    }

    public void initialize() {
        for (List<Room> row : rooms) {
            for (Room room : row) {
                room.initialize();
            }
        }
    }
}
