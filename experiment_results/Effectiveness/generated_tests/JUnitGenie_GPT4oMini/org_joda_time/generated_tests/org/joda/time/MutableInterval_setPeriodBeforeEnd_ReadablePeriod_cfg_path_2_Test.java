package org.joda.time;
import org.joda.time.MutableInterval;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.junit.Test;
import static org.junit.Assert.fail;

public class MutableInterval_setPeriodBeforeEnd_ReadablePeriod_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetPeriodBeforeEndWithReadablePeriod() {
        MutableInterval interval = new MutableInterval(1000L, 2000L);

        // Create a ReadablePeriod (using Period class here)
        ReadablePeriod period = new Period(5000L); // 5 seconds as readable period

        try {
            interval.setPeriodBeforeEnd(period);
            // Optionally assert the outcome if necessary
            // Example: assert that startMillis is updated correctly
        } catch (Exception e) {
            fail("Expected no exception to be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testSetPeriodBeforeEndWithNull() {
        MutableInterval interval = new MutableInterval(1000L, 2000L);

        try {
            interval.setPeriodBeforeEnd(null);
            // Optionally assert that startMillis is set to endMillis after a null period
        } catch (Exception e) {
            fail("Expected no exception to be thrown");
        }
    }

}