package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_plusYears_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusYears_WithZeroYears() {
        DateMidnight dateMidnight = new DateMidnight(2020, 1, 1);
        DateMidnight result = dateMidnight.plusYears(0);
        assertEquals(dateMidnight, result);
    }

}