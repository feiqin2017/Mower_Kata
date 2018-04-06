package com.xebia.mower.bean;

public class Lawn {
    private final Integer limitX;
    private final Integer limitY;

    public Lawn(final Integer limitX, final Integer limitY) {
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public Integer getLimitX() {
        return limitX;
    }

    public Integer getLimitY() {
        return limitY;
    }
}
