package org.joda.time;
import org.joda.time.MutableInterval;
import org.joda.time.ReadableInterval;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableInterval_setInterval_ReadableInterval_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetInterval_NullReadableInterval() {
        MutableInterval interval = new MutableInterval();

        try {
            interval.setInterval(null);
            fail("Expected IllegalArgumentException for null ReadableInterval");
        } catch (IllegalArgumentException e) {
            assertEquals("Interval must not be null", e.getMessage());
        }
    }

}