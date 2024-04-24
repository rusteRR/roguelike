package ru.hse.sd.config;

import java.util.Random;

public class Config {
    private int defaultHp = 100;
    private int mapSizeX = 5;
    private int mapSizeY = 5;
    private int minRoomSize = 8;
    private int maxRoomSize = 12;
    private final Random rand = new Random();

    public int getDefaultHp() {
        return defaultHp;
    }
    public void setDefaultHp(int defaultHp) {
        this.defaultHp = defaultHp;
    }

    public int getMapSizeX() {
        return mapSizeX; }
    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public int getMapSizeY() {
        return mapSizeY; }
    public void setMapSizeY(int mapSizeY) {
        this.mapSizeY = mapSizeY;
    }

    public int getMinRoomSize() {
        return minRoomSize; }
    public void setMinRoomSize(int minRoomSize) {
        this.minRoomSize = minRoomSize;
    }

    public int getMaxRoomSize() {
        return maxRoomSize; }
    public void setMaxRoomSize(int maxRoomSize) {
        this.maxRoomSize = maxRoomSize;
    }

    public int getRandomRoomSize() {
        return rand.nextInt(getMaxRoomSize() - getMinRoomSize()) + getMinRoomSize();
    }
}
