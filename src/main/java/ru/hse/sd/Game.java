package ru.hse.sd;

import ru.hse.sd.actions.interfaces.Action;
import ru.hse.sd.config.Config;

import java.util.List;

public class Game {

    private Player player;
    private List<List<Action>> field;

    public Game(Config gameConfig) {
        player = new Player(gameConfig.getDefaultHp());
    }

    public int processMove() {
        return 0;
    }
}
