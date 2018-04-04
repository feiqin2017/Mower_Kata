package com.xebia.mower.bean;

public class Coordinate {
    Integer x;
    Integer y;
    String direction;

    public Coordinate(Integer x, Integer y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String toString(){
        return x + " "+ y + " "+direction;
    }

    public void turnRight() {
    }

    public void turnLeft() {
    }

    public void forward() {
    }
}
