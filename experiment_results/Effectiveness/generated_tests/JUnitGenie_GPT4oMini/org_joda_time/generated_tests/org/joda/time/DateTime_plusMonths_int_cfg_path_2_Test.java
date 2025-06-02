package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusMonths_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusMonthsWithZero() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        DateTime result = dateTime.plusMonths(0);
        assertEquals(dateTime, result);
    }

}