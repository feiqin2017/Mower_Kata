package com.xebia.mower.bean;

import com.xebia.mower.exception.InvalidCommandException;

public class Mower {
    private Coordinate coordinate;

    public Mower(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void receiveCommands(String commands) throws InvalidCommandException{
        char[] command = commands.toCharArray();
        for(char c : command) {
            processCommand(c);
        }
    }

    private void processCommand(char command) throws InvalidCommandException {
        switch (command) {
            case 'G': coordinate.turnLeft();    break;
            case 'D': coordinate.turnRight();   break;
            case 'A': coordinate.forward();     break;
            default: throw new InvalidCommandException();
        }
    }


    public String positionAt(){
        return coordinate.toString();
    }
}
