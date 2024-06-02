package ru.hse.sd.mob.strategy;

import ru.hse.sd.Game;
import ru.hse.sd.mob.action.MobAction;

public interface BehaviorStrategy {
    MobAction decideAction(Game game);
}
