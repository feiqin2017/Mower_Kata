package com.xebia.mower.bean;

public class CoordinateBuilder {
    Integer x;
    Integer y;
    String direction;

    public static CoordinateBuilder aCoordinate(){
        return new CoordinateBuilder();
    }

    public CoordinateBuilder withX(Integer x){
        this.x = x;
        return this;
    }

    public CoordinateBuilder withY(Integer y){
        this.y = y;
        return this;
    }

    public CoordinateBuilder withDirection(String direction){
        this.direction = direction;
        return this;
    }

    public Coordinate build(){
        Coordinate coordinate = new Coordinate(x,y,direction);
        return coordinate;
    }
}
