package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_41_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes() {
        // Test case for valid input
        int hoursOffset = 1;
        int minutesOffset = 30;
        DateTimeZone result = DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
        assertNotNull(result);
        
        // Test case for zero offset
        hoursOffset = 0;
        minutesOffset = 0;
        result = DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
        assertEquals(DateTimeZone.UTC, result);
        
        // Test case for hours out of range
        try {
            hoursOffset = 24; // Invalid
            minutesOffset = 0;
            DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
            fail("Expected IllegalArgumentException for hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }

        // Test case for minutes out of range
        try {
            hoursOffset = 0;
            minutesOffset = 60; // Invalid
            DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
            fail("Expected IllegalArgumentException for minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }

        // Test case for positive hours with negative minutes
        try {
            hoursOffset = 1; // Valid
            minutesOffset = -1; // Invalid
            DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }

        // Test case for large offset leading to ArithmeticException
        try {
            hoursOffset = 100000; // This will lead to a large offset
            minutesOffset = 0;
            DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
            fail("Expected IllegalArgumentException for offset is too large");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}