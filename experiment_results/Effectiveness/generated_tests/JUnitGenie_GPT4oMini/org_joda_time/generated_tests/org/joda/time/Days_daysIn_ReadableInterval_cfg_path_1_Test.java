package org.joda.time;
import static org.junit.Assert.assertEquals;
import org.joda.time.Days;
import org.joda.time.ReadableInterval;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

public class Days_daysIn_ReadableInterval_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDaysIn_NonNullInterval() {
        ReadableInterval interval = new Interval(new DateTime(2020, 1, 1, 0, 0),
                                                 new DateTime(2020, 1, 10, 0, 0));
        Days result = Days.daysIn(interval);
        assertEquals(Days.days(9), result);
    }

    @Test(timeout = 4000)
    public void testDaysIn_NullInterval() {
        ReadableInterval interval = null;
        Days result = Days.daysIn(interval);
        assertEquals(Days.ZERO, result);
    }

}