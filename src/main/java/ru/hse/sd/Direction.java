package ru.hse.sd;

import java.util.Random;

public class Direction {

    private final int dx;
    private final int dy;

    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public final static Direction UP = new Direction(0, 1);
    public final static Direction DOWN = new Direction(0, -1);
    public final static Direction LEFT = new Direction(-1, 0);
    public final static Direction RIGHT = new Direction(1, 0);

    private static final Random rnd = new Random(48);
    public static Direction random() {
        int dirNum = rnd.nextInt(4);
        Direction direction = null;
        switch (dirNum) {
            case 0 -> direction = UP;
            case 1 -> direction = DOWN;
            case 2 -> direction = LEFT;
            case 3 -> direction = RIGHT;
        }
        return direction;
    }
}
