package org.joda.time;
import org.joda.time.Hours;
import org.joda.time.field.FieldUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Hours_plus_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusWithPositiveHours() {
        Hours initialHours = Hours.hours(5);
        Hours result = initialHours.plus(3);
        assertEquals(Hours.hours(8), result);
    }

    @Test(timeout = 4000)
    public void testPlusWithZeroHours() {
        Hours initialHours = Hours.hours(5);
        Hours result = initialHours.plus(0);
        assertEquals(initialHours, result);
    }

    @Test(timeout = 4000)
    public void testPlusWithNegativeHours() {
        Hours initialHours = Hours.hours(5);
        Hours result = initialHours.plus(-2);
        assertEquals(Hours.hours(3), result);
    }

    @Test(timeout = 4000)
    public void testPlusWithLargePositiveHours() {
        Hours initialHours = Hours.hours(Integer.MAX_VALUE);
        Hours result = initialHours.plus(1);
        assertEquals(Hours.hours(Integer.MAX_VALUE + 1), result);
    }

    @Test(timeout = 4000)
    public void testPlusWithLargeNegativeHours() {
        Hours initialHours = Hours.hours(Integer.MIN_VALUE);
        try {
            Hours result = initialHours.plus(-1);
            // If it does not throw an exception, we can assert the result
            assertEquals(Hours.hours(Integer.MIN_VALUE - 1), result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}