package ru.hse.sd;

public class Coords {
    private int x;
    private int y;
    private Room room;

    public Coords(Room room, int x, int y) {
        this.room = room;
        this.x = x;
        this.y = y;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Coords moveByDelta(int xDelta, int yDelta) {
        return new Coords(room, x + xDelta, y + yDelta);
    }
    public int distanceTo(Coords coords) {
        // if coords.room != this.room ...
        return Math.abs(this.x - coords.x) + Math.abs(this.y - coords.y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
