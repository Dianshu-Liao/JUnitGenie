package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTime_now_DateTimeZone_cfg_path_1_Test {

    private static class TestDateTimeZone extends DateTimeZone {
        protected TestDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return false;
        }

        @Override
        public String getNameKey(long millis) {
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

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof TestDateTimeZone)) return false;
            TestDateTimeZone other = (TestDateTimeZone) obj;
            return this.getID().equals(other.getID());
        }

        @Override
        public int hashCode() {
            return getID().hashCode();
        }
    }

    @Test(timeout = 4000)
    public void testNow_WithValidZone() {
        DateTimeZone zone = new TestDateTimeZone("TestZone");
        DateTime dateTime = null;
        try {
            dateTime = DateTime.now(zone);
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid DateTimeZone.");
        }
        assertNotNull("DateTime should not be null when valid DateTimeZone is provided.", dateTime);
    }

    @Test(timeout = 4000)
    public void testNow_WithNullZone() {
        try {
            // Specify the method explicitly to avoid ambiguity
            DateTime.now((DateTimeZone) null);
            fail("NullPointerException should have been thrown for null DateTimeZone.");
        } catch (NullPointerException e) {
            assertEquals("Zone must not be null", e.getMessage());
        }
    }

}