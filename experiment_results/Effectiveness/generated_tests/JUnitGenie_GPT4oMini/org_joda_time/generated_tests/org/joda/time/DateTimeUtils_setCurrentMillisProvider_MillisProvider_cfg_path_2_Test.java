package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeUtils.MillisProvider;
import org.junit.Test;
import static org.junit.Assert.fail;

public class DateTimeUtils_setCurrentMillisProvider_MillisProvider_cfg_path_2_Test {

    private static class TestMillisProvider implements MillisProvider {
        @Override
        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    @Test(timeout = 4000)
    public void testSetCurrentMillisProvider() {
        try {
            MillisProvider millisProvider = new TestMillisProvider();
            DateTimeUtils.setCurrentMillisProvider(millisProvider);
        } catch (SecurityException e) {
            fail("SecurityException should not be thrown for valid MillisProvider");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown for valid MillisProvider");
        }
    }

    @Test(timeout = 4000)
    public void testSetCurrentMillisProviderWithNull() {
        try {
            DateTimeUtils.setCurrentMillisProvider(null);
            fail("IllegalArgumentException should be thrown when MillisProvider is null");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (SecurityException e) {
            fail("SecurityException should not be thrown when MillisProvider is null");
        }
    }

}