package com.xebia.mower.bean;

import com.xebia.mower.exception.InvalidCommandException;
import com.xebia.mower.exception.InvalidStartPositionException;

public class Mower {
    private Coordinate coordinate;

    private Lawn lawn;

    public Mower(final Coordinate coordinate, final Lawn lawn) throws InvalidStartPositionException {
        requireValidateStartPosition(coordinate, lawn);
        this.coordinate = coordinate;
        this.lawn = lawn;
    }

    private void requireValidateStartPosition(Coordinate coordinate, Lawn lawn) throws InvalidStartPositionException {
        if(coordinate.outSideOf(lawn)){
            throw new InvalidStartPositionException();
        }
    }

    public void receiveCommands(final String commands) throws InvalidCommandException{
        char[] command = commands.toCharArray();
        for(char c : command) {
            moveForCommand(c);
        }
    }

    private void moveForCommand(final char command) throws InvalidCommandException {
        switch (command) {
            case 'G': coordinate.nextLeftDirection();    break;
            case 'D': coordinate.nextRightDirection();   break;
            case 'A': coordinate.nextPosition(lawn);         break;
            default: throw new InvalidCommandException();
        }
    }


    public String positionAt(){
        return coordinate.toString();
    }
}
