package ru.hse.sd;

import ru.hse.sd.config.Config;
import ru.hse.sd.config.PlayerConfig;

public class Game {

    private Player player;
    private GameMap map;

    public Game(Config gameConfig) {
        PlayerConfig playerConfig = gameConfig.getPlayerConfig();
        player = new Player(playerConfig.getHp());
        map = new GameMap(gameConfig);
    }

    public int processMove() {
        return 0;
    }
}
