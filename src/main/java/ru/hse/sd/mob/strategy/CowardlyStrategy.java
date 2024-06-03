package ru.hse.sd.mob.strategy;

import ru.hse.sd.Direction;
import ru.hse.sd.Game;
import ru.hse.sd.mob.AbstractMob;
import ru.hse.sd.mob.action.MobAction;

public class CowardlyStrategy extends PassiveStrategy {
    public CowardlyStrategy(AbstractMob actor) {
        super(actor);
    }
    @Override
    public MobAction decideAction(Game game) {
        if(actor.canAggro(game.getPlayerCoords())) {
            // TODO: get direction to run away from player
            // if no such then attack player
            return actor.moveAction(Direction.random());
        }
        return super.decideAction(game);
    }
}
