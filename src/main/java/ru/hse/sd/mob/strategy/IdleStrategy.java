package ru.hse.sd.mob.strategy;

import ru.hse.sd.Game;
import ru.hse.sd.mob.action.MobAction;

public class IdleStrategy implements BehaviorStrategy {
    @Override
    public MobAction decideAction(Game game) {
        return g -> {};
    }
}
