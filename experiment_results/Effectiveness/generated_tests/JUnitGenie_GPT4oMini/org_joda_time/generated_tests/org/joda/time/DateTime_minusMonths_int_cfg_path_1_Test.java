package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_minusMonths_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusMonths_NonZeroMonths() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        DateTime result = dateTime.minusMonths(2);
        DateTime expected = new DateTime(2023, 8, 1, 0, 0);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMonths_ZeroMonths() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        DateTime result = dateTime.minusMonths(0);
        assertEquals(dateTime, result);
    }

    @Test(timeout = 4000)
    public void testMinusMonths_NegativeMonths() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        DateTime result = dateTime.minusMonths(-1);
        DateTime expected = new DateTime(2023, 11, 1, 0, 0);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMonths_LargeMonths() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        DateTime result = dateTime.minusMonths(100);
        DateTime expected = new DateTime(2013, 10, 1, 0, 0);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMonths_SubtractMaxInt() {
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0);
        try {
            dateTime.minusMonths(Integer.MAX_VALUE);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}