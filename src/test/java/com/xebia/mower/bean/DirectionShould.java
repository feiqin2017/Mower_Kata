package com.xebia.mower.bean;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DirectionShould {
    @Test
    @Parameters
    public void give_next_left_direction(Direction current, Direction next) throws Exception{
        assertThat(current.getNextLeftDirection(), is(Optional.of(next)));
    }

    @Test
    @Parameters
    public void give_next_right_direction(Direction current, Direction next) throws Exception{
        assertThat(current.getNextRightDirection(), is(Optional.of(next)));
    }

    private Object[] parametersForGive_next_left_direction() {
        return new Object[] {
                new Object[] { Direction.North, Direction.West },
                new Object[] { Direction.East, Direction.North },
                new Object[] { Direction.South, Direction.East },
                new Object[] { Direction.West, Direction.South }
        };
    }
    private Object[] parametersForGive_next_right_direction() {
        return new Object[] {
                new Object[] { Direction.North, Direction.East },
                new Object[] { Direction.East, Direction.South },
                new Object[] { Direction.South, Direction.West },
                new Object[] { Direction.West, Direction.North }
        };
    }
}
