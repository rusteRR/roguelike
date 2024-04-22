package ru.hse.sd.actions;

import ru.hse.sd.Player;
import ru.hse.sd.actions.interfaces.Action;

public class Wall implements Action {
    @Override
    public void execute(Player player) {
        player.kill();
    }
}
