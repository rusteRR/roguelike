package ru.hse.sd.config;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.IOException;

public class Config {
    @JsonSetter("player")
    private PlayerConfig playerConfig;
    @JsonSetter("map")
    private MapConfig mapConfig;
    @JsonSetter("room")
    private RoomConfig roomConfig;

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

    public PlayerConfig getPlayerConfig() {
        return playerConfig;
    }
}
