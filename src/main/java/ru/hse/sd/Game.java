package ru.hse.sd;

import ru.hse.sd.config.Config;

public class Game {

    private Player player;
    private GameMap map;

    public Game(Config gameConfig) {
        player = new Player(gameConfig.getDefaultHp());
        map = new GameMap(gameConfig);
    }

    public int processMove() {
        return 0;
    }
}
