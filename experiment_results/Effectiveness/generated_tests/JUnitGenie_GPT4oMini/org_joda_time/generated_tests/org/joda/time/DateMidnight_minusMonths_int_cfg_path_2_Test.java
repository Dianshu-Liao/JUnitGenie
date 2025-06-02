package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_minusMonths_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusMonths_WithZeroMonths() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1);
        DateMidnight result = dateMidnight.minusMonths(0);
        assertEquals(dateMidnight, result);
    }

}