package com.xebia.mower.bean;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    North("N", "W", "E"),
    South("S", "E", "W"),
    West("W", "S", "N"),
    East("E", "N", "S");

    private final String current;
    private final String left;
    private final String right;

    private Direction(final String current,final String left,final String right) {
        this.current = current;
        this.left = left;
        this.right = right;
    }

    public String getCurrent() {
        return current;
    }

    public Optional<Direction> getNextLeftDirection(){
        return getDirectionFor(left);
    }

    public Optional<Direction> getNextRightDirection(){
        return getDirectionFor(right);
    }

    private static Optional<Direction> getDirectionFor(String next) {
        return Arrays.stream(Direction.values())
                        .filter( i -> i.getCurrent().equals(next))
                        .findFirst();

    }
}
