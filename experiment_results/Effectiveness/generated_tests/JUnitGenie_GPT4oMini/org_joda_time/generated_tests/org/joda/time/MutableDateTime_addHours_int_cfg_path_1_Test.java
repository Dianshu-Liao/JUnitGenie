package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableDateTime_addHours_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddHours_NonZeroHours() {
        MutableDateTime dateTime = new MutableDateTime(0); // Initialize with epoch time
        int hoursToAdd = 5; // Non-zero hours

        dateTime.addHours(hoursToAdd); // Call the focal method

        long expectedMillis = dateTime.getMillis() + (hoursToAdd * 3600000); // Calculate expected millis
        assertEquals(expectedMillis, dateTime.getMillis()); // Verify the result
    }

    @Test(timeout = 4000)
    public void testAddHours_ZeroHours() {
        MutableDateTime dateTime = new MutableDateTime(0); // Initialize with epoch time
        int hoursToAdd = 0; // Zero hours

        dateTime.addHours(hoursToAdd); // Call the focal method

        assertEquals(0, dateTime.getMillis()); // Verify that millis remain unchanged
    }

    @Test(timeout = 4000)
    public void testAddHours_NegativeHours() {
        MutableDateTime dateTime = new MutableDateTime(0); // Initialize with epoch time
        int hoursToAdd = -3; // Negative hours

        dateTime.addHours(hoursToAdd); // Call the focal method

        long expectedMillis = dateTime.getMillis() + (hoursToAdd * 3600000); // Calculate expected millis
        assertEquals(expectedMillis, dateTime.getMillis()); // Verify the result
    }

}