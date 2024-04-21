package ru.hse.sd.actions;

import ru.hse.sd.Player;

public class Wall implements Action {
    @Override
    public void execute(Player player) {
        player.kill();
    }
}
