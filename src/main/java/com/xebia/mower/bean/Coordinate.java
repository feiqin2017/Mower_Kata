package com.xebia.mower.bean;

public class Coordinate {
    private Integer x;
    private Integer y;
    private Direction direction;

    public Coordinate(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        return builder.append(x).append(" ")
                        .append(y).append(" ")
                        .append(direction)
                        .toString();
    }

    public void nextRightDirection() {
        direction = direction.getNextRightDirection()
                                .orElse(direction);
    }

    public void nextLeftDirection() {
        direction = direction.getNextLeftDirection()
                                .orElse(direction);
    }

    public void nextPosition(final Lawn lawn) {
        switch (direction){
            case North: increaseY(lawn.getLimitY());     break;
            case South: decreaseY();                     break;
            case East:  increaseX(lawn.getLimitX());     break;
            case West:  decreaseX();                     break;
        }
    }

    private void decreaseX() {
        if (x > 0) x-- ;
    }

    private void increaseX(final int limit) {
        if(x < limit) x++ ;
    }

    private void decreaseY() {
        if(y > 0) y --;
    }

    private void increaseY(final int limit) {
        if(y <limit) y ++ ;
    }

    public boolean outSideOf(final Lawn lawn) {
        return x < 0 || y < 0 || x > lawn.getLimitX() || y > lawn.getLimitY() ;
    }


    protected Coordinate clone() {
        return new Coordinate(this.x, this.y, this.direction);
    }
}
