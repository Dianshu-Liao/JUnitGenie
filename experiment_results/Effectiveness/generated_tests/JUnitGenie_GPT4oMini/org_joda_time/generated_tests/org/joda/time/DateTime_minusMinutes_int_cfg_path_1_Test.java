package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_minusMinutes_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusMinutes_NonZeroMinutes() {
        DateTime dateTime = new DateTime(1625097600000L); // Example: July 1, 2021
        DateTime result = dateTime.minusMinutes(10);
        DateTime expected = new DateTime(1625097540000L); // Expected result after subtracting 10 minutes
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMinutes_ZeroMinutes() {
        DateTime dateTime = new DateTime(1625097600000L); // Example: July 1, 2021
        DateTime result = dateTime.minusMinutes(0);
        assertEquals(dateTime, result); // Should return the same DateTime instance
    }

    @Test(timeout = 4000)
    public void testMinusMinutes_NegativeMinutes() {
        // Test with negative minutes; should still work, adding 10 minutes
        DateTime dateTime = new DateTime(1625097600000L); // Example: July 1, 2021
        DateTime result = dateTime.minusMinutes(-10);
        DateTime expected = new DateTime(1625097660000L); // Expected result after adding 10 minutes
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMinutes_MinIntBoundary() {
        DateTime dateTime = new DateTime(1625097600000L); // Example: July 1, 2021
        try {
            dateTime.minusMinutes(Integer.MIN_VALUE);
        } catch (Exception e) {
            // Handle the expected exception if it occurs
            // This test will pass if an exception is thrown; specifics depend on implementation choice
        }
    }

}