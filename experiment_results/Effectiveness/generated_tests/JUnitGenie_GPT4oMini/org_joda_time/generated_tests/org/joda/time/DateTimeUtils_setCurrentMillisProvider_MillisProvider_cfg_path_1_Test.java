package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeUtils.MillisProvider;
import org.junit.Test;

public class DateTimeUtils_setCurrentMillisProvider_MillisProvider_cfg_path_1_Test {

    private static class TestMillisProvider implements MillisProvider {
        @Override
        public long getMillis() {
            return 0; // Dummy implementation
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCurrentMillisProvider_NullProvider() {
        DateTimeUtils.setCurrentMillisProvider(null); // Directly call, exception is expected
    }

    @Test(timeout = 4000)
    public void testSetCurrentMillisProvider_ValidProvider() {
        try {
            // Check if the security manager allows setting the provider
            System.setSecurityManager(new SecurityManager());
            DateTimeUtils.setCurrentMillisProvider(new TestMillisProvider());
            // If we reach this point, the test passes
        } catch (SecurityException e) {
            // Handle the SecurityException if it occurs
            e.printStackTrace();
        } finally {
            // Reset the security manager to null after the test
            System.setSecurityManager(null);
        }
    }


}