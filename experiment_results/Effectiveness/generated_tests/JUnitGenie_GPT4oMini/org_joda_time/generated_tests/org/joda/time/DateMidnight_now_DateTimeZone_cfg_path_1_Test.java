package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateMidnight_now_DateTimeZone_cfg_path_1_Test {

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
            return this == obj;
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
    public void testNowWithValidZone() {
        DateTimeZone zone = new TestDateTimeZone("TestZone");
        DateMidnight dateMidnight = DateMidnight.now(zone);
        assertNotNull(dateMidnight);
    }

    @Test(timeout = 4000)
    public void testNowWithNullZone() {
        try {
            // Specify the method explicitly to avoid ambiguity
            DateMidnight.now((DateTimeZone) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("Zone must not be null", e.getMessage());
        }
    }


}