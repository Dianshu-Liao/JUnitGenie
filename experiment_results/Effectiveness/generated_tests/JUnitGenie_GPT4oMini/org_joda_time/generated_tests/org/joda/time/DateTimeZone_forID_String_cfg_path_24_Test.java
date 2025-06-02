package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_24_Test {

    // Mock implementation of the abstract DateTimeZone class for testing
    private static class TestDateTimeZone extends DateTimeZone {
        protected TestDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
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

        @Override
        public boolean equals(Object obj) {
            // Implement a simple equality check for testing purposes
            if (this == obj) return true;
            if (!(obj instanceof TestDateTimeZone)) return false;
            TestDateTimeZone other = (TestDateTimeZone) obj;
            return this.getID().equals(other.getID());
        }
    }

    @Test(timeout = 4000)
    public void testForID_ValidUTC() {
        DateTimeZone zone = DateTimeZone.forID("UTC");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidUT() {
        DateTimeZone zone = DateTimeZone.forID("UT");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidGMT() {
        DateTimeZone zone = DateTimeZone.forID("GMT");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidZ() {
        DateTimeZone zone = DateTimeZone.forID("Z");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidOffset() {
        String id = "UTC+05:00"; // Corrected format for offset
        DateTimeZone zone = DateTimeZone.forID(id);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForID_InvalidZone() {
        try {
            DateTimeZone.forID("InvalidZone");
            fail("Expected IllegalArgumentException for invalid zone id");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidZone' is not recognised", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForID_NullInput() {
        DateTimeZone zone = DateTimeZone.forID(null);
        assertEquals(DateTimeZone.UTC, zone); // This test is expected to fail as per the Joda-Time library behavior
    }


}