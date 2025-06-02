package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_10_Test {

    private static class TestDateTimeZone extends DateTimeZone {
        protected TestDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public String getNameKey(long instant) {
            return null;
        }

        @Override
        public int getStandardOffset(long instant) {
            return 0;
        }

        @Override
        public long previousTransition(long instant) {
            return 0;
        }

        @Override
        public int getOffset(long instant) {
            return 0;
        }

        @Override
        public long nextTransition(long instant) {
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidOffsets() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(5, 30);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(24, 0);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(0, 60);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_NegativeMinutesPositiveHours() {
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ExceptionHandling() {
        try {
            DateTimeZone.forOffsetHoursMinutes(10, 200); // Potentially causes ArithmeticException
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}