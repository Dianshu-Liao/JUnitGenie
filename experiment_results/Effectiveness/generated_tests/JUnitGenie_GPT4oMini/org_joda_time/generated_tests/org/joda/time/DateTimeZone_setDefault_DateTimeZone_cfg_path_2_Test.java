package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import java.security.Permission;
import java.lang.SecurityManager;
import static org.junit.Assert.fail;

public class DateTimeZone_setDefault_DateTimeZone_cfg_path_2_Test {

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
    public void testSetDefaultWithValidZone() {
        try {
            DateTimeZone validZone = new TestDateTimeZone("UTC");
            DateTimeZone.setDefault(validZone);
        } catch (SecurityException e) {
            fail("SecurityException should not be thrown for a valid zone.");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown for a valid zone.");
        }
    }

    @Test(timeout = 4000)
    public void testSetDefaultWithNullZone() {
        try {
            DateTimeZone.setDefault(null);
            fail("Expected IllegalArgumentException not thrown for null zone.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (SecurityException e) {
            fail("SecurityException should not be thrown for a null zone.");
        }
    }

    @Test(timeout = 4000)
    public void testSetDefaultWithPermissionDenied() {
        // Assuming SecurityManager is set to deny permission
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                throw new SecurityException("Permission denied");
            }
        });

        try {
            DateTimeZone validZone = new TestDateTimeZone("UTC");
            DateTimeZone.setDefault(validZone);
            fail("Expected SecurityException not thrown due to permission denial.");
        } catch (SecurityException e) {
            // Expected exception
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown due to permission denial.");
        } finally {
            // Reset the security manager
            System.setSecurityManager(null);
        }
    }

}