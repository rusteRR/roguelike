package ru.hse.sd.actions;

import ru.hse.sd.Player;
import ru.hse.sd.actions.interfaces.Action;
import ru.hse.sd.actions.interfaces.InventoryArtifact;
import ru.hse.sd.exceptions.InventoryIsFull;
import ru.hse.sd.exceptions.PlayerIsAlreadyDead;

public class HealingBottle implements Action, InventoryArtifact {
    private final int hp;
    public HealingBottle(int hp) {
        this.hp = hp;
    }

    @Override
    public void execute(Player player) throws InventoryIsFull {
        player.takeArtifact(this);
    }

    @Override
    public boolean isPermanent() {
        return false;
    }

    @Override
    public void use(Player player) throws PlayerIsAlreadyDead {
        player.increaseHp(hp);
    }
}
