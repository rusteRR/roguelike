package ru.hse.sd.actions;

import ru.hse.sd.Player;
import ru.hse.sd.exceptions.InventoryIsFull;

public class Door implements Action {
    private final int srcRoomId; // TODO: Probably replace int to a Room class, this allows us to safely change the Player's room and current coords
    private final int destRoomId;

    public Door(int srcRoomId, int destRoomId) {
        this.srcRoomId = srcRoomId;
        this.destRoomId = destRoomId;
    }

    @Override
    public void execute(Player player) throws InventoryIsFull {

    }
}
