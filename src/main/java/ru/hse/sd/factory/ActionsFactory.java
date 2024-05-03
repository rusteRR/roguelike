package ru.hse.sd.factory;

import ru.hse.sd.actions.interfaces.Action;
import ru.hse.sd.actions.Empty;
import ru.hse.sd.actions.HealingBottle;
import ru.hse.sd.actions.Wall;

public class ActionsFactory {
    private Action makeEmptyAction() {
        return new Empty();
    }

    private Action makeHealingBottle(int hp) {
        return new HealingBottle(hp);
    }

    private Action makeWall() {
        return new Wall();
    }
}
