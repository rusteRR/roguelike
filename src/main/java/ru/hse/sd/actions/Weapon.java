package ru.hse.sd.actions;

import ru.hse.sd.Player;
import ru.hse.sd.actions.interfaces.Action;
import ru.hse.sd.actions.interfaces.InventoryArtifact;
import ru.hse.sd.exceptions.InventoryIsFull;
import ru.hse.sd.exceptions.PlayerIsAlreadyDead;

public class Weapon implements Action, InventoryArtifact {
    private final int damage;
    private final int attackRadius;
    public Weapon(int damage, int attackRadius) {

        this.damage = damage;
        this.attackRadius = attackRadius;
    }

    @Override
    public void execute(Player player) throws InventoryIsFull {
        player.takeArtifact(this);
    }

    @Override
    public boolean isPermanent() {
        return true;
    }

    @Override
    public void use(Player player) throws PlayerIsAlreadyDead {
        player.setDamage(damage);
        player.setAttackRadius(attackRadius);
    }
}
