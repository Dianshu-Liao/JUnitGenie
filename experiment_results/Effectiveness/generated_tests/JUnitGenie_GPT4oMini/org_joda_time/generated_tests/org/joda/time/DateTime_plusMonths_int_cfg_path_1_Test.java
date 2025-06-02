package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusMonths_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusMonths_NonZeroMonths() {
        DateTime dateTime = new DateTime(2021, 1, 1, 0, 0);
        DateTime result = dateTime.plusMonths(2);
        DateTime expected = new DateTime(2021, 3, 1, 0, 0);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusMonths_ZeroMonths() {
        DateTime dateTime = new DateTime(2021, 1, 1, 0, 0);
        DateTime result = dateTime.plusMonths(0);
        assertEquals(dateTime, result);
    }

}