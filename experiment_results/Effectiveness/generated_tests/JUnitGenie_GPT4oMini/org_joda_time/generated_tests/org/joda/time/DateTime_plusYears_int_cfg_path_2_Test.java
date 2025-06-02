package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusYears_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusYearsWithZero() {
        DateTime dateTime = new DateTime(2020, 1, 1, 0, 0);
        DateTime result = dateTime.plusYears(0);
        assertEquals(dateTime, result);
    }

}