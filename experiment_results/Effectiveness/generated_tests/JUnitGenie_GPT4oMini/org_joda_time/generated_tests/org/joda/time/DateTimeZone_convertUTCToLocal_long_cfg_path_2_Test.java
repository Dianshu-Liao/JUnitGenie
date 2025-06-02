package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_convertUTCToLocal_long_cfg_path_2_Test {

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
            return 0; // No offset for testing
        }

        @Override
        public long previousTransition(long instant) {
            return instant;
        }

        @Override
        public int getOffset(long instant) {
            return 0; // No offset for testing
        }

        @Override
        public long nextTransition(long instant) {
            return instant;
        }
    }

    @Test(timeout = 4000)
    public void testConvertUTCToLocal() {
        TestDateTimeZone testZone = new TestDateTimeZone("TestZone");
        long instantUTC = 1000000000L; // Example UTC time
        long expectedLocal = instantUTC; // Expected local time with no offset

        long result = testZone.convertUTCToLocal(instantUTC);
        assertEquals(expectedLocal, result);
    }

    @Test(timeout = 4000)
    public void testConvertUTCToLocal_Overflow() {
        TestDateTimeZone testZone = new TestDateTimeZone("TestZone");
        long instantUTC = Long.MAX_VALUE; // Example UTC time that may cause overflow

        try {
            testZone.convertUTCToLocal(instantUTC);
            fail("Expected ArithmeticException not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Adding time zone offset caused overflow", e.getMessage());
        }
    }

}