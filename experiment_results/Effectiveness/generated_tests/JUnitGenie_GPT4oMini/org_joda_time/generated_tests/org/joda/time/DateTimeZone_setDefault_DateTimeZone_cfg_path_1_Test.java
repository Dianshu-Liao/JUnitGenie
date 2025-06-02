package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.fail;

public class DateTimeZone_setDefault_DateTimeZone_cfg_path_1_Test {

    // Concrete implementation of DateTimeZone for testing purposes
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
    public void testSetDefaultWithValidZone() {
        try {
            // Create a new instance of TestDateTimeZone
            TestDateTimeZone zone = new TestDateTimeZone("TestZone");

            // Attempt to set the default DateTimeZone
            DateTimeZone.setDefault(zone);
        } catch (SecurityException e) {
            fail("Should not throw SecurityException when SecurityManager is null.");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDefaultWithNullZone() {
        // Attempt to set the default DateTimeZone with null, expecting IllegalArgumentException
        DateTimeZone.setDefault(null);
    }

    @Test(timeout = 4000)
    public void testSecurityManagerPermission() {
        // Temporarily disable the Security Manager for this test
        System.setSecurityManager(null);
        try {
            // Attempt to set the default DateTimeZone
            TestDateTimeZone zone = new TestDateTimeZone("TestZone");
            DateTimeZone.setDefault(zone);
        } catch (SecurityException e) {
            fail("Should not throw SecurityException when SecurityManager is null.");
        } finally {
            // Restore the Security Manager to its original state
            System.setSecurityManager(new SecurityManager());
        }
    }

}