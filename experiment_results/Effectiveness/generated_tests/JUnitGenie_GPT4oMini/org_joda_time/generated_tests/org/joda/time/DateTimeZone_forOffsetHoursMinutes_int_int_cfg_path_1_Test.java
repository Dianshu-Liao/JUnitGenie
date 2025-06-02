package org.joda.time;
import static org.junit.Assert.*;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_1_Test {

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
    public void testForOffsetHoursMinutes_NegativeHoursOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(-24, 0);
            fail("Expected IllegalArgumentException for negative hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: -24", e.getMessage());
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
    public void testForOffsetHoursMinutes_NegativeMinutesOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(0, -60);
            fail("Expected IllegalArgumentException for negative minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: -60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_PositiveHoursWithNegativeMinutes() {
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

}