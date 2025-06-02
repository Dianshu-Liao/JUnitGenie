package org.joda.time;
import org.joda.time.MutableInterval;
import org.joda.time.ReadableInterval;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.PeriodType;
import org.joda.time.Period;
import org.joda.time.ReadableInstant;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableInterval_setInterval_ReadableInterval_cfg_path_2_Test {


    @Test(timeout = 4000)
    public void testSetInterval_NullInterval() {
        // Arrange
        MutableInterval mutableInterval = new MutableInterval();

        // Act & Assert
        try {
            mutableInterval.setInterval(null);
            fail("Expected IllegalArgumentException for null interval");
        } catch (IllegalArgumentException e) {
            assertEquals("Interval must not be null", e.getMessage());
        }
    }


}
