package com.xebia.mower.bean;

import com.xebia.mower.exception.InvalidCommandException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.xebia.mower.bean.CoordinateBuilder.aCoordinate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MowerShould {

    @Mock
    private Coordinate coordinate;
    private Mower mower;

    @Before
    public void setUp() throws Exception{
        mower = new Mower(coordinate);
    }

    @Test
    public void start_with_initiate_position() throws Exception{
        Coordinate init = aCoordinate().withX(3).withY(5).withDirection("N").build();
        Mower mower = new Mower(init);
        assertThat(mower.positionAt(), is("3 5 N"));
    }

    @Test (expected = InvalidCommandException.class)
    public void throws_exception_when_receive_invalid_command() throws Exception{
        mower.receiveCommands("C");
    }

    @Test
    public void turn_right_when_receive_command_D() throws Exception {
        mower.receiveCommands("D");
        verify(coordinate, times (1)).turnRight();
    }

    @Test
    public void turn_left_when_receive_command_G() throws Exception {
        mower.receiveCommands("G");
        verify(coordinate, times (1)).turnLeft();
    }

    @Test
    public void forward_when_receive_command_A() throws Exception {
        mower.receiveCommands("A");
        verify(coordinate, times (1)).forward();
    }
}
