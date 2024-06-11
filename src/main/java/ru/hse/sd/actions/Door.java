package ru.hse.sd.actions;

import ru.hse.sd.Coords;
import ru.hse.sd.Player;
import ru.hse.sd.Room;
import ru.hse.sd.actions.interfaces.Action;

public class Door implements Action {
    private final Room destRoom;
    private final int destX;
    private final int destY;

    public Door(Room destRoom, int destX, int destY) {
        this.destRoom = destRoom;
        this.destX = destX;
        this.destY = destY;
    }

    @Override
    public void execute(Player player) {
        player.setCoordinates(new Coords(destRoom, destX, destY));
    }
}
