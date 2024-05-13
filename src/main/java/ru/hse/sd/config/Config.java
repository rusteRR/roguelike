package ru.hse.sd.config;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Config {
    @JsonSetter("player")
    private PlayerConfig playerConfig;
    @JsonSetter("map")
    private MapConfig mapConfig;
    @JsonSetter("room")
    private RoomConfig roomConfig;
//=======
//    private int defaultHp = 100;
//    private int mapSizeX = 5;
//    private int mapSizeY = 5;
//    private int minRoomSize = 11;
//    private int maxRoomSize = 17;
//    private final Random rand = new Random();
//>>>>>>> f63d880 (second version of map generation)

    public void setRoomConfig(RoomConfig roomConfig) {
        this.roomConfig = roomConfig;
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.playerConfig = playerConfig;
    }

    public void setMapConfig(MapConfig mapConfig) {
        this.mapConfig = mapConfig;
    }

    public RoomConfig getRoomConfig() {
        return roomConfig;
    }

    public MapConfig getMapConfig() {
        return mapConfig;
    }

    //<<<<<<< HEAD
    public PlayerConfig getPlayerConfig() {
        return playerConfig;
//=======
//    public int getRandomRoomSize() {
//        int size = rand.nextInt(getMaxRoomSize() - getMinRoomSize() + 1) + getMinRoomSize();
//        return size + 1 - size % 2;
//>>>>>>> f63d880 (second version of map generation)
    }
}
