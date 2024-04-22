package ru.hse.sd.actions.interfaces;

import ru.hse.sd.Player;
import ru.hse.sd.exceptions.PlayerIsAlreadyDead;

public interface InventoryArtifact {
    boolean isPermanent(); // allows to check if artifact will be destroyed after usage
    void use(Player player) throws PlayerIsAlreadyDead;
}
