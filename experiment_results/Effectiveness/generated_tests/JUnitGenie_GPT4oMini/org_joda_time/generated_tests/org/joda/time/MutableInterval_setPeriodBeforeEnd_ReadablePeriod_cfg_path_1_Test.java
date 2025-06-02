package org.joda.time;
import org.joda.time.MutableInterval;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableInterval_setPeriodBeforeEnd_ReadablePeriod_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetPeriodBeforeEndWithValidPeriod() {
        MutableInterval interval = new MutableInterval(1000L, 2000L);
        ReadablePeriod period = new Period(500L); // A valid period of 500 milliseconds

        // Execute the method under test
        interval.setPeriodBeforeEnd(period);

        // Validate the expected outcome
        assertEquals(1500L, interval.getStartMillis()); // Start should be 2000 - 500
    }

    @Test(timeout = 4000)
    public void testSetPeriodBeforeEndWithNullPeriod() {
        MutableInterval interval = new MutableInterval(1000L, 2000L);

        // Execute the method under test with null
        interval.setPeriodBeforeEnd(null);

        // Validate the expected outcome
        assertEquals(2000L, interval.getStartMillis()); // Start should be set to endMillis
    }

    @Test(timeout = 4000)
    public void testSetPeriodBeforeEndWithNegativeStartMillis() {
        MutableInterval interval = new MutableInterval(0L, 1000L);
        ReadablePeriod period = new Period(2000L); // A period that will cause startMillis to be negative

        // Execute the method under test
        try {
            interval.setPeriodBeforeEnd(period);
            fail("Expected an exception due to negative startMillis");
        } catch (Exception e) {
            // Expected exception
        }
    }

}