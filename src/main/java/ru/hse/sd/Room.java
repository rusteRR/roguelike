package ru.hse.sd;

import ru.hse.sd.actions.Empty;
import ru.hse.sd.actions.HealingBottle;
import ru.hse.sd.actions.Wall;
import ru.hse.sd.actions.Weapon;
import ru.hse.sd.actions.interfaces.Action;
import ru.hse.sd.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private int roomId;
    private boolean exists = false;
    private final Random rand = new Random();
    private boolean[][] dfsVisited;

    private int dimX;
    private int dimY;

    private List<List<Action>> field;

    public Room() {}

    public Room(Config gameConfig, int id) {
        roomId = id;
        exists = true;
        dimX = 5; // TODO: random generator was removed from config
        dimY = 5;
        field = new ArrayList<>(dimY);
        for (int y = 0; y < dimY; ++y) {
            List<Action> row = new ArrayList<>(dimX);
            for (int x = 0; x < dimX; ++x) {
                row.add(new Empty());
            }
            field.add(row);
        }
        generateField();
    }

    private void generateField() {
        generateActions(new Wall(), 0.4);
        generateActions(new HealingBottle(), 0.1);
        generateActions(new Weapon(), 0.1);
    }

    private void generateActions(Action a, double rate) {
        while (!validate(a)) {
            for (List<Action> actions : field) {
                for (int j = 0; j < dimX; ++j) {
                    if (rand.nextDouble() < rate) {
                        try {
                            actions.set(j, a.getClass().getConstructor().newInstance());
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
    }

    private boolean validate(Action a) {
        if (a.getClass() != Wall.class) {
            return true;
        }
        dfsVisited = new boolean[dimY][dimX];
        dfs(dimX / 2, 0); // left door coordinates
        for (int y = 0; y < dimY; ++y) {
            for (int x = 0; x < dimX; ++x) {
                if (!dfsVisited[y][x]) { // isolated zone found
                    return false;
                }
            }
        }
        // checking doors
        return checkSquare((dimY - 1) / 2, (dimY + 1) / 2, 0, 0) &&
                checkSquare((dimY - 1) / 2, (dimY + 1) / 2, dimX - 1, dimX - 1) &&
                checkSquare(0, 0, (dimX - 1) / 2, (dimX + 1) / 2) &&
                checkSquare(dimY - 1, dimY - 1, (dimX - 1) / 2, (dimX + 1) / 2);
    }

    private void dfs(int y, int x) {
        if (dfsVisited[y][x]) {
            return;
        }
        dfsVisited[y][x] = true;
        var place = field.get(y).get(x);
        if (place.getClass() != Wall.class) {
            if (y > 0) {
               dfs(y - 1, x);
            }
            if (y < dimY - 1) {
                dfs(y + 1, x);
            }
            if (x > 0) {
                dfs(y, x - 1);
            }
            if (x < dimX - 1) {
                dfs(y, x + 1);
            }
        }
    }

    private boolean checkSquare(int y1, int y2, int x1, int x2) {
        for (int i = y1; i <= y2; ++i) {
            for (int j = x1; j <= x2; ++j) {
                if (field.get(i).get(j).getClass() == Wall.class) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<Action>> getField() { return field; }
    public boolean isExists() { return exists; }
    public int getRoomId() { return roomId; }
}
