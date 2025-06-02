package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusYears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusYears_NonZeroYears() {
        DateTime dateTime = new DateTime(2020, 1, 1, 0, 0);
        DateTime result = dateTime.plusYears(2);
        DateTime expected = new DateTime(2022, 1, 1, 0, 0);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusYears_ZeroYears() {
        DateTime dateTime = new DateTime(2020, 1, 1, 0, 0);
        DateTime result = dateTime.plusYears(0);
        assertEquals(dateTime, result);
    }

    @Test(timeout = 4000)
    public void testPlusYears_NegativeYears() {
        DateTime dateTime = new DateTime(2020, 1, 1, 0, 0);
        DateTime result = dateTime.plusYears(-1);
        DateTime expected = new DateTime(2019, 1, 1, 0, 0);
        assertEquals(expected, result);
    }

}