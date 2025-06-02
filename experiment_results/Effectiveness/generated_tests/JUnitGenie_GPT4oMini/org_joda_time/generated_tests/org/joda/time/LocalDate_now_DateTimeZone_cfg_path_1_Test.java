package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDate_now_DateTimeZone_cfg_path_1_Test {

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
        LocalDate localDate = LocalDate.now(zone);
        assertNotNull(localDate);
    }

    @Test(timeout = 4000)
    public void testNowWithNullZone() {
        try {
            LocalDate.now((DateTimeZone) null); // Explicitly casting to DateTimeZone
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("Zone must not be null", e.getMessage());
        }
    }


}