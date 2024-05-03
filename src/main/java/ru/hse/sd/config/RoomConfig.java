package ru.hse.sd.config;

import com.fasterxml.jackson.annotation.JsonSetter;

public class RoomConfig {
    @JsonSetter("max_x_size")
    private int XSizeLimit;
    @JsonSetter("max_y_size")
    private int YSizeLimit;

    public int getXSizeLimit() {
        return XSizeLimit;
    }

    public int getYSizeLimit() {
        return YSizeLimit;
    }

    public void setXSizeLimit(int XSizeLimit) {
        this.XSizeLimit = XSizeLimit;
    }

    public void setYSizeLimit(int YSizeLimit) {
        this.YSizeLimit = YSizeLimit;
    }
}
