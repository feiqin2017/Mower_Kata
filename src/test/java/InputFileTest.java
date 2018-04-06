import com.xebia.mower.bean.Coordinate;
import com.xebia.mower.bean.Direction;
import com.xebia.mower.bean.Lawn;
import com.xebia.mower.bean.Mower;
import com.xebia.mower.exception.InvalidStartPositionException;
import cucumber.api.java.ca.I;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.IdentityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.Reader;
import java.util.LinkedList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


@RunWith(JUnitParamsRunner.class)
public class InputFileTest {

    @Test
    @FileParameters(value = "src/test/resources/inputData.txt", mapper = CustomMapper.class)
    public void inputDataTest(Mower mower, String commands, String coordinate) throws Exception {
        mower.receiveCommands(commands);
        String position = mower.positionAt();
        assertThat(position, is(coordinate.toString()));
    }

    public static class CustomMapper extends IdentityMapper {
        @Override
        public Object[] map(Reader reader) {
            Object[] map = super.map(reader);
            List<Object> result = new LinkedList<Object>();

            Lawn lawns = convertToLawn(map[0].toString());
            int i = 1;
            while (i < map.length ) {
                try {
                    Coordinate coordinate = convertToCoordinate(map[i++].toString());
                    Mower mower = new Mower(coordinate, lawns);
                    String commands = map[i++].toString();
                    Coordinate endCoordinate = convertToCoordinate(map[i++].toString());
                    result.add(new Object[]{mower, commands, endCoordinate});

                } catch(InvalidStartPositionException e){
                    assertFalse(true);
                }
            }

            return result.toArray();
        }

        private Coordinate convertToCoordinate(String line) {
            String[] coordinate = line.split(" ");
            Integer x = Integer.valueOf(coordinate[0]);
            Integer y = Integer.valueOf(coordinate[1]);
            Direction direction = Direction.valueOf(coordinate[2]);
            return new Coordinate(x,y,direction);
        }

        private Lawn convertToLawn(String line) {
            String[] limits = line.split(" ");
            return new Lawn(Integer.valueOf(limits[0]), Integer.valueOf(limits[1]));
        }
    }
}
