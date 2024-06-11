package ru.hse.sd;

import ru.hse.sd.config.Config;
import ru.hse.sd.config.PlayerConfig;
import ru.hse.sd.exceptions.InventoryIsFull;

import java.awt.event.KeyEvent;

public class Game {

    private final Player player;
    private final GameMap map;
    private final Controller controls;

    public Game(Config gameConfig) {
        PlayerConfig playerConfig = gameConfig.getPlayerConfig();
        player = new Player(playerConfig.getHp());
        map = new GameMap(gameConfig);
        controls = new Controller();
    }

    public void processMove(KeyEvent event) throws InventoryIsFull {
        System.out.println("Current input state: " + (event == null ? "null" : event.toString()));
        if (event != null) {
            Coords newCoords = getPlayerCoords();
            newCoords = switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT -> newCoords.moveByDelta(-1, 0);
                case KeyEvent.VK_RIGHT -> newCoords.moveByDelta(1, 0);
                case KeyEvent.VK_UP -> newCoords.moveByDelta(0, 1);
                case KeyEvent.VK_DOWN -> newCoords.moveByDelta(0, -1);
                default -> newCoords;
            };
            if (newCoords.isValid()) {
                player.setCoordinates(newCoords);
                newCoords.getAction().execute(player);
            }
        }
    }

    public boolean isFinished() {
        return false;
    }

    public Coords getPlayerCoords() {
        return player.getCoordinates();
    }

    public boolean availableToMoveCoords(Coords coords) {
        // TODO: add equals to Coords class
        return !player.getCoordinates().equals(coords);
    }

    public void attackPlayer(int damage) {
        player.increaseHp(-damage);
    }
}
