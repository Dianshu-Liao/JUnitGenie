package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.Interval;
import org.joda.time.ReadableInterval;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class DateTimeUtils_getReadableInterval_ReadableInterval_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetReadableIntervalWithNull() {
        ReadableInterval interval = null;
        try {
            ReadableInterval result = DateTimeUtils.getReadableInterval(interval);
            assertNotNull("Expected a non-null interval when input is null", result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetReadableIntervalWithValidInterval() {
        long startMillis = DateTimeUtils.currentTimeMillis();
        long endMillis = startMillis + 1000; // 1 second later
        ReadableInterval interval = new Interval(startMillis, endMillis);
        try {
            ReadableInterval result = DateTimeUtils.getReadableInterval(interval);
            assertNotNull("Expected a non-null interval when input is valid", result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}