package ru.hse.sd.mob.strategy;

import ru.hse.sd.Direction;
import ru.hse.sd.Game;
import ru.hse.sd.mob.AbstractMob;
import ru.hse.sd.mob.action.MobAction;

public class AggroStrategy extends PassiveStrategy {
    public AggroStrategy(AbstractMob actor) {
        super(actor);
    }

    @Override
    public MobAction decideAction(Game game) {
        if(actor.canAttack(game.getPlayerCoords())) {
            return actor.attackPlayerAction();
        }
        if(actor.canAggro(game.getPlayerCoords())) {
            // TODO: get direction to approach player
            return actor.moveAction(Direction.random());
        }
        return super.decideAction(game);
    }
}
