package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_6_Test {

    // Concrete implementation of the abstract class DateTimeZone
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
    public void testForOffsetHoursMinutes_ValidInputs() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(5, 30);
        assertEquals("UTC+05:30", zone.getID());
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_NegativeHours() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(-5, 30);
        assertEquals("UTC-05:30", zone.getID());
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ThrowException_HoursOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(24, 0);
            fail("Expected IllegalArgumentException for hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ThrowException_MinutesOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(0, 60);
            fail("Expected IllegalArgumentException for minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ThrowException_PositiveHoursNegativeMinutes() {
        try {
            DateTimeZone.forOffsetHoursMinutes(5, -1);
            fail("Expected IllegalArgumentException for positive hours having negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ThrowException_ArithmeticException() {
        try {
            DateTimeZone.forOffsetHoursMinutes(Integer.MAX_VALUE, 0); // This will cause ArithmeticException
            fail("Expected IllegalArgumentException due to arithmetic exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}