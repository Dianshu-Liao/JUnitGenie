package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInput() {
        try {
            DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
            assertNotNull(zone);
        } catch (IllegalArgumentException e) {
            fail("Exception should not have been thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(24, 0);
            fail("Expected IllegalArgumentException for hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(0, 60);
            fail("Expected IllegalArgumentException for minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        try {
            DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
            assertEquals(DateTimeZone.UTC, zone);
        } catch (IllegalArgumentException e) {
            fail("Exception should not have been thrown for zero offset");
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ArithmeticException() {
        try {
            DateTimeZone.forOffsetHoursMinutes(100, 0); // This should cause an ArithmeticException
            fail("Expected IllegalArgumentException due to offset being too large");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}