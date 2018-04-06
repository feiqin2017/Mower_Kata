package com.xebia.mower.bean;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CoordinateShould {

    @Test
    @Parameters({
            "3 , 5, 5, 5, false",
            "2 , 6, 5, 5, true" ,
            "0 , 3, 5, 5, false",
            "4, -1, 5, 5, true"
    })
    public void indicate_if_position_outSide( Integer x, Integer y,
                                              Integer limitX, Integer limitY,
                                              boolean result ) throws Exception{
        Coordinate coordinate = new Coordinate( x, y,Direction.North);
        Lawn lawn = new Lawn(limitX, limitY);
        assertThat(coordinate.outSideOf(lawn), is(result));
    }

    @Test
    @Parameters
    public void change_next_right_direction(Direction current, Direction next) throws Exception {
        Coordinate aCoordinate = new Coordinate( 3, 5, current);
        aCoordinate.nextRightDirection();
        assertThat(aCoordinate.getDirection(), is(next));
    }

    @Test
    @Parameters
    public void change_next_left_direction(Direction current, Direction next) throws Exception {
        Coordinate aCoordinate = new Coordinate( 3, 5, current);
        aCoordinate.nextLeftDirection();
        assertThat(aCoordinate.getDirection(), is(next));
    }


    @Test
    public void change_next_position_inside_lawn() throws Exception{
        Coordinate aCoordinate = new Coordinate( 3, 4, Direction.North);
        Lawn lawn = new Lawn(5, 5);
        aCoordinate.nextPosition(lawn);
        assertThat(aCoordinate.getX(), is(3));
        assertThat(aCoordinate.getY(), is(5));
    }

    @Test
    public void stay_same_position_outside_lawn() throws Exception{
        Coordinate aCoordinate = new Coordinate( 3, 5, Direction.North);
        Lawn lawn = new Lawn(5, 5);
        aCoordinate.nextPosition(lawn);
        assertThat(aCoordinate.getX(), is(3));
        assertThat(aCoordinate.getY(), is(5));

    }

    private Object[] parametersForChange_next_left_direction() {
        return new Object[] {
                new Object[] { Direction.North, Direction.West },
                new Object[] { Direction.East, Direction.North },
                new Object[] { Direction.South, Direction.East },
                new Object[] { Direction.West, Direction.South }
        };
    }
    private Object[] parametersForChange_next_right_direction() {
        return new Object[] {
                new Object[] { Direction.North, Direction.East },
                new Object[] { Direction.East, Direction.South },
                new Object[] { Direction.South, Direction.West },
                new Object[] { Direction.West, Direction.North }
        };
    }
}
