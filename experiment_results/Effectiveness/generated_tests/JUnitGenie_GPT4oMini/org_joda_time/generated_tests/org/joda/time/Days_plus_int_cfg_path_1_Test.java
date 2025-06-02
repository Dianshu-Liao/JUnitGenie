package org.joda.time;
import org.joda.time.Days;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Days_plus_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusWithPositiveDays() {
        Days initialDays = Days.days(5);
        Days result = initialDays.plus(3);
        assertEquals(Days.days(8), result);
    }

    @Test(timeout = 4000)
    public void testPlusWithZeroDays() {
        Days initialDays = Days.days(5);
        Days result = initialDays.plus(0);
        assertEquals(initialDays, result);
    }

    @Test(timeout = 4000)
    public void testPlusWithNegativeDays() {
        Days initialDays = Days.days(5);
        Days result = initialDays.plus(-2);
        assertEquals(Days.days(3), result);
    }

    @Test(timeout = 4000)
    public void testPlusWithLargeDays() {
        Days initialDays = Days.days(5);
        Days result = initialDays.plus(1000);
        assertEquals(Days.days(1005), result);
    }

}