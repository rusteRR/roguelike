package ru.hse.sd.config;

import com.fasterxml.jackson.annotation.JsonSetter;

public class RoomConfig {
    @JsonSetter("min_bound_size")
    private int MinBound;
    @JsonSetter("max_bound_size")
    private int MaxBound;

    public int getMinBound() {
        return MinBound;
    }

    public int getMaxBound() {
        return MaxBound;
    }

    public void setMinBound(int MinBound) {
        this.MinBound = MinBound;
    }

    public void setMaxBound(int MaxBound) {
        this.MaxBound = MaxBound;
    }
}
