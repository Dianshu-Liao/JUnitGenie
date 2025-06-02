package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_5_Test {

    // Concrete implementation of the abstract DateTimeZone class for testing purposes
    private static class TestDateTimeZone extends DateTimeZone {
        protected TestDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return true;
        }

        @Override
        public boolean equals(Object obj) {
            // Use the instance's id to compare instead of calling super.equals
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TestDateTimeZone that = (TestDateTimeZone) obj;
            return getID().equals(that.getID());
        }

        @Override
        public String getNameKey(long instant) {
            return "TestZone";
        }

        @Override
        public int getStandardOffset(long instant) {
            return 0;
        }

        @Override
        public long previousTransition(long instant) {
            return instant;
        }

        @Override
        public int getOffset(long instant) {
            return 0;
        }

        @Override
        public long nextTransition(long instant) {
            return instant;
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
    public void testForID_InvalidZone() {
        try {
            DateTimeZone.forID("InvalidZone");
            fail("Expected IllegalArgumentException for invalid zone id");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testForID_Null() {
        DateTimeZone zone = DateTimeZone.forID(null);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidOffset() {
        DateTimeZone zone = DateTimeZone.forID("UTC+05:00"); // Corrected format for offset
        assertNotNull(zone);
    }

}