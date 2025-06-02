package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.field.FieldUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_46_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes() {
        // Test case for valid input
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutesWithNegativeHours() {
        // Test case for negative hours and valid minutes
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(-1, 30);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutesWithPositiveHoursAndNegativeMinutes() {
        // Test case for positive hours with negative minutes (should throw exception)
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutesWithOutOfRangeHours() {
        // Test case for out of range hours (should throw exception)
        try {
            DateTimeZone.forOffsetHoursMinutes(24, 0);
            fail("Expected IllegalArgumentException for hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutesWithOutOfRangeMinutes() {
        // Test case for out of range minutes (should throw exception)
        try {
            DateTimeZone.forOffsetHoursMinutes(0, 60);
            fail("Expected IllegalArgumentException for minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutesWithLargeOffset() {
        // Test case for large offset (should throw exception)
        try {
            DateTimeZone.forOffsetHoursMinutes(0, Integer.MAX_VALUE);
            fail("Expected IllegalArgumentException for offset is too large");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}