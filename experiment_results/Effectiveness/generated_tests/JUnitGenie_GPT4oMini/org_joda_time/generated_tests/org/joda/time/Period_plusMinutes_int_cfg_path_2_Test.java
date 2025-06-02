package org.joda.time;
import org.joda.time.Period;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Period_plusMinutes_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusMinutesWithZero() {
        Period period = new Period(1, 0, 0, 0); // Example instantiation
        Period result = period.plusMinutes(0);
        assertEquals(period, result);
    }

}