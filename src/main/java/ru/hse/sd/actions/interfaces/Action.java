package ru.hse.sd.actions.interfaces;

import ru.hse.sd.Player;
import ru.hse.sd.exceptions.InventoryIsFull;

/**
 * Provides an interface for any cell on the game field
 */
public interface Action {
    void execute(Player player) throws InventoryIsFull;
}
