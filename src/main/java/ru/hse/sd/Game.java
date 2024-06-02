package ru.hse.sd;

import ru.hse.sd.config.Config;
import ru.hse.sd.config.PlayerConfig;
import ru.hse.sd.exceptions.PlayerIsAlreadyDead;

public class Game {

    private final Player player;
    private final GameMap map;

    public Game(Config gameConfig) {
        PlayerConfig playerConfig = gameConfig.getPlayerConfig();
        player = new Player(playerConfig.getHp());
        map = new GameMap(gameConfig);
    }

    public int processMove() {
        return 0;
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
