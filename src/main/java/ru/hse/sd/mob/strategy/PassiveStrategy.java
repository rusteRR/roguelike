package ru.hse.sd.mob.strategy;

import ru.hse.sd.Direction;
import ru.hse.sd.Game;
import ru.hse.sd.mob.AbstractMob;
import ru.hse.sd.mob.action.MobAction;

public class PassiveStrategy implements BehaviorStrategy {
    protected final AbstractMob actor;

    public PassiveStrategy(AbstractMob actor) {
        this.actor = actor;
    }
    @Override
    public MobAction decideAction(Game game) {
        return (g) -> actor.moveAction(Direction.random());
    }
}
