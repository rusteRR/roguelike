package ru.hse.sd;

import ru.hse.sd.config.Config;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private List<List<Room>> rooms;

    public List<List<Room>> getRooms() { return rooms; }

    public GameMap(Config gameConfig) {
        rooms = new ArrayList<>(gameConfig.getMapSizeY());
        for (int y = 0; y < gameConfig.getMapSizeY(); ++y) {
            rooms.set(y, new ArrayList<>(gameConfig.getMapSizeX()));
            for (int x = 0; x < gameConfig.getMapSizeX(); ++x) {
                rooms.get(y).set(x, new Room(gameConfig, y * gameConfig.getMapSizeY() + x));
            }
        }
    }
}
