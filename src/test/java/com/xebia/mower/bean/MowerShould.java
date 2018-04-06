package com.xebia.mower.bean;

import com.xebia.mower.exception.InvalidCommandException;
import com.xebia.mower.exception.InvalidStartPositionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import static com.xebia.mower.bean.CoordinateBuilder.aCoordinate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MowerShould {

    @Mock
    private Coordinate coordinate;
    @Mock
    private Lawn lawn;
    private Mower mower;

    @Before
    public void setUp() throws Exception{
        mower = new Mower(coordinate, lawn);
    }

    @Test (expected = InvalidStartPositionException.class)
    public void throws_exception_start_with_invalid_position() throws Exception{
        Coordinate aCoordinate = aCoordinate().withX(7).withY(5).withDirection(Direction.North).build();
        Lawn aLawn = new Lawn(5,5);
        Mower aMower = new Mower(aCoordinate, aLawn);
    }

    @Test
    public void start_with_initiate_position() throws Exception{
        Coordinate aCoordinate = aCoordinate().withX(3).withY(5).withDirection(Direction.North).build();
        Lawn aLawn = new Lawn(5,5);
        Mower aMower = new Mower(aCoordinate, aLawn);
        assertThat(aMower.positionAt(), is("3 5 " + Direction.North));
    }

    @Test (expected = InvalidCommandException.class)
    public void throws_exception_when_receive_invalid_command() throws Exception{
        mower.receiveCommands("C");
    }

    @Test
    public void turn_right_when_receive_command_D() throws Exception {
        mower.receiveCommands("D");
        verify(coordinate, times (1)).nextRightDirection();
    }

    @Test
    public void turn_left_when_receive_command_G() throws Exception {
        mower.receiveCommands("G");
        verify(coordinate, times (1)).nextLeftDirection();
    }

    @Test
    public void forward_when_receive_command_A() throws Exception {
        mower.receiveCommands("A");
        verify(coordinate, times (1)).nextPosition(lawn);
    }

}
