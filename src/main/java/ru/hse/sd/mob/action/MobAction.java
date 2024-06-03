package ru.hse.sd.mob.action;

import ru.hse.sd.Game;

@FunctionalInterface
public interface MobAction {
    void apply(Game game);
}
