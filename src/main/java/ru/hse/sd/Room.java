package ru.hse.sd;

import ru.hse.sd.actions.*;
import ru.hse.sd.actions.interfaces.Action;
import ru.hse.sd.config.Config;
import ru.hse.sd.config.RoomConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Room {
    private final int roomId;
    private final GameMap gameMap;
    private static final Random rand = new Random();
    private boolean[][] dfsVisited;

    private final int dimX;
    private final int dimY;

    private int oneDoorX;
    private int oneDoorY;

    private List<List<Action>> field;

    private int getRandomBoundSize(int min, int max) {
        int randNumber;
        if (max == min) {
            randNumber = min;
        } else {
            randNumber = rand.nextInt(max - min) + min;
        }
        return randNumber - randNumber % 2 + 1;
    }

    public Room(Config gameConfig, int id, GameMap map) {
        RoomConfig roomConfig = gameConfig.getRoomConfig();
        roomId = id;
        gameMap = map;
        dimX = getRandomBoundSize(roomConfig.getMinBound(), roomConfig.getMaxBound());
        dimY = getRandomBoundSize(roomConfig.getMinBound(), roomConfig.getMaxBound());
    }

    public void initialize() {
        field = new ArrayList<>(dimY);
        for (int y = 0; y < dimY; ++y) {
            List<Action> row = new ArrayList<>(dimX);
            for (int x = 0; x < dimX; ++x) {
                if (y == 0 || y == dimY - 1 || x == 0 || x == dimX - 1) {
                    row.add(new Wall());
                } else {
                    row.add(new Empty());
                }
            }
            field.add(row);
        }
        generateField();
    }

    private void generateField() {
        generateDoors();
        generateActions(new Wall(), 0.3);
        generateActions(new HealingBottle(), 0.05);
        generateActions(new Weapon(), 0.05);
    }

    private void generateDoors() {
        try {
            var rooms = gameMap.getRooms();
            int roomCoordY = roomId / rooms.size();
            int roomCoordX = roomId % rooms.size();
            if (roomCoordY > 0) {
                Room destRoom = rooms.get(roomCoordY - 1).get(roomCoordX);
                int destX = destRoom.dimX / 2;
                int destY = destRoom.dimY - 2;
                field.get(0).set(dimX / 2, new Door(destRoom, destX, destY));
                oneDoorY = 0;
                oneDoorX = dimX / 2;
            }
            if (roomCoordX > 0) {
                Room destRoom = rooms.get(roomCoordY).get(roomCoordX - 1);
                int destX = destRoom.dimX - 2;
                int destY = destRoom.dimY / 2;
                field.get(dimY / 2).set(0, new Door(destRoom, destX, destY));
                oneDoorY = dimY / 2;
                oneDoorX = 0;
            }
            if (roomCoordY + 1 < rooms.size()) {
                Room destRoom = rooms.get(roomCoordY + 1).get(roomCoordX);
                int destX = destRoom.dimX / 2;
                int destY = 1;
                field.get(dimY - 1).set(dimX / 2, new Door(destRoom, destX, destY));
                oneDoorY = dimY - 1;
                oneDoorX = dimX / 2;
            }
            if (roomCoordX + 1 < rooms.get(0).size()) {
                Room destRoom = rooms.get(roomCoordY).get(roomCoordX + 1);
                int destX = 1;
                int destY = destRoom.dimY / 2;
                field.get(dimY / 2).set(dimX - 1, new Door(destRoom, destX, destY));
                oneDoorY = dimY / 2;
                oneDoorX = dimX - 1;
            }
        } catch (Exception ignored) {
        }
    }

    private void generateActions(Action a, double rate) {
        boolean valid = false;
        List<List<Action>> testField = field.stream().map(ArrayList::new).collect(Collectors.toList());
        while (!valid) {
            testField = field.stream().map(ArrayList::new).collect(Collectors.toList());
            for (List<Action> actions : testField) {
                for (int j = 0; j < dimX; ++j) {
                    if (actions.get(j).getClass() == Empty.class && rand.nextDouble() < rate) {
                        try {
                            actions.set(j, a.getClass().getConstructor().newInstance());
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
            valid = validate(a, testField);
        }
        field = testField.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    private boolean validate(Action a, List<List<Action>> testField) {
        if (a.getClass() != Wall.class) {
            return true;
        }
        dfsVisited = new boolean[dimY][dimX];

        dfs(testField, oneDoorY, oneDoorX);

        for (int y = 0; y < dimY; ++y) {
            for (int x = 0; x < dimX; ++x) {
                if (!dfsVisited[y][x] && testField.get(y).get(x).getClass() != Wall.class) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(List<List<Action>> testField, int y, int x) {
        if (dfsVisited[y][x]) {
            return;
        }
        dfsVisited[y][x] = true;
        if (testField.get(y).get(x).getClass() != Wall.class) {
            if (y > 0) {
                dfs(testField, y - 1, x);
            }
            if (y < dimY - 1) {
                dfs(testField, y + 1, x);
            }
            if (x > 0) {
                dfs(testField, y, x - 1);
            }
            if (x < dimX - 1) {
                dfs(testField, y, x + 1);
            }
        }
    }

    public List<List<Action>> getField() { return field; }
    public Action getAction(int x, int y) {
        return field.get(y).get(x);
    }
    public int getRoomId() { return roomId; }
    public boolean validate(int x, int y) {
        return y >= 0 && y < field.size() && x >= 0 && x < field.get(0).size();
    }
}
