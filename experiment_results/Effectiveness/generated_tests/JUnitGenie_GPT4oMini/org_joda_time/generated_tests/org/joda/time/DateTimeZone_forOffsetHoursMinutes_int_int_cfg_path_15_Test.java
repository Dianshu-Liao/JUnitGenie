package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInput() {
        // Test with valid hours and minutes
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        // Test with zero offset
        try {
            DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
            assertEquals(DateTimeZone.UTC, zone);
        } catch (IllegalArgumentException e) {
            fail("Should not throw exception for zero offset");
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        // Test with hours out of range
        try {
            DateTimeZone.forOffsetHoursMinutes(24, 0);
            fail("Expected IllegalArgumentException for hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        // Test with minutes out of range
        try {
            DateTimeZone.forOffsetHoursMinutes(0, 60);
            fail("Expected IllegalArgumentException for minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        // Test with positive hours and negative minutes
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ArithmeticExceptionHandling() {
        // Test with parameters that will cause an ArithmeticException
        try {
            DateTimeZone.forOffsetHoursMinutes(-1440, 0); // This will cause an overflow
            fail("Expected IllegalArgumentException due to overflow");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}