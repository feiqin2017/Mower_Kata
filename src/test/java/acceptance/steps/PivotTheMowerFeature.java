package acceptance.steps;

import com.xebia.mower.bean.Coordinate;
import com.xebia.mower.bean.Direction;
import com.xebia.mower.bean.Lawn;
import com.xebia.mower.bean.Mower;
import com.xebia.mower.exception.InvalidCommandException;
import com.xebia.mower.exception.InvalidStartPositionException;
import cucumber.api.java8.En;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PivotTheMowerFeature implements En {
    private Lawn lawn;
    private Mower mower;

    public PivotTheMowerFeature(){

        Given("^a lawn with coordinate of highest right side (\\d+),(\\d+)$", (Integer limitX, Integer limitY) -> {
            lawn = new Lawn(limitX, limitY);

        });


        Given("^I place the mower inside of the lawn with coordinate (\\d+),(\\d+),(\\w+)$", (Integer x, Integer y, Direction direction) -> {
            Coordinate coordinate = new Coordinate(x,y, direction);
            try {
                mower = new Mower(coordinate, lawn);
            } catch (InvalidStartPositionException e) {

            }
        });


        When("^I pivot the mower with a serie of instruments (\\w+)$" , (String command) ->{
            try {
                mower.receiveCommands(command);
            } catch (InvalidCommandException e) {

            }
        });

        Then("mover communicate his coordinate at the end of instruments (\\d+),(\\d+),(\\w+)$", (Integer endX, Integer endY, String endDirection) -> {
            Coordinate endCoordiate = new Coordinate(endX, endY, Direction.valueOf(endDirection));
            assertThat(mower.positionAt(), is(endCoordiate.toString()));
        });

    }


}
