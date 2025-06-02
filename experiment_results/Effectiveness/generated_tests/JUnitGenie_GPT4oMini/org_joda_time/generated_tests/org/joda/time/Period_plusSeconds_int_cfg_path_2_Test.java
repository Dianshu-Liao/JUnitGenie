package org.joda.time;
import org.joda.time.Period;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Period_plusSeconds_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusSecondsWithZero() {
        Period period = new Period(1, 0, 0, 0); // Example instantiation
        Period result = period.plusSeconds(0);
        assertEquals(period, result);
    }

}