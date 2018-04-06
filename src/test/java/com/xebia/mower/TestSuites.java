package com.xebia.mower;

import com.xebia.mower.bean.CoordinateShould;
import com.xebia.mower.bean.DirectionShould;
import com.xebia.mower.bean.MowerShould;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
        CoordinateShould.class,
        DirectionShould.class,
        MowerShould.class
})
public class TestSuites {
}
