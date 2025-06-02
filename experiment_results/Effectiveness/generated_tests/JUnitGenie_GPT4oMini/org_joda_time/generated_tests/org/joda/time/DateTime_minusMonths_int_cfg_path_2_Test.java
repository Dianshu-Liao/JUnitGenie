package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_minusMonths_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusMonthsWithZeroMonths() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        DateTime result = dateTime.minusMonths(0);
        // Since we are subtracting 0 months, the result should be the same as the original dateTime
        assertEquals(dateTime, result);
    }

}