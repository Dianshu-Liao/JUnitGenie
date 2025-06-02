package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_47_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes() {
        try {
            // Test case where hoursOffset is 0 and minutesOffset is 0
            DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
            assertEquals(DateTimeZone.UTC, zone);

            // Test case where hoursOffset is within valid range and minutesOffset is within valid range
            zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
            assertNotNull(zone);

            // Test case where hoursOffset is negative and minutesOffset is valid
            zone = DateTimeZone.forOffsetHoursMinutes(-1, 30);
            assertNotNull(zone);

            // Test case where hoursOffset is positive and minutesOffset is negative
            try {
                zone = DateTimeZone.forOffsetHoursMinutes(1, -30);
                fail("Expected IllegalArgumentException for positive hours with negative minutes");
            } catch (IllegalArgumentException e) {
                // Expected exception
            }

            // Test case where hoursOffset is out of range
            try {
                zone = DateTimeZone.forOffsetHoursMinutes(24, 0);
                fail("Expected IllegalArgumentException for hours out of range");
            } catch (IllegalArgumentException e) {
                // Expected exception
            }

            // Test case where minutesOffset is out of range
            try {
                zone = DateTimeZone.forOffsetHoursMinutes(0, 60);
                fail("Expected IllegalArgumentException for minutes out of range");
            } catch (IllegalArgumentException e) {
                // Expected exception
            }

            // Test case where offset is too large
            try {
                zone = DateTimeZone.forOffsetHoursMinutes(0, Integer.MAX_VALUE);
                fail("Expected IllegalArgumentException for offset too large");
            } catch (IllegalArgumentException e) {
                // Expected exception
            }

        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}