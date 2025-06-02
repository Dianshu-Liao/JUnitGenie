package org.joda.time;
import org.joda.time.YearMonth;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class YearMonth_withPeriodAdded_ReadablePeriod_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithPeriodAdded_NullPeriod() {
        YearMonth yearMonth = new YearMonth(2021, 1);
        ReadablePeriod period = null;
        int scalar = 5;

        YearMonth result = yearMonth.withPeriodAdded(period, scalar);

        assertEquals(yearMonth, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_ScalarZero() {
        YearMonth yearMonth = new YearMonth(2021, 1);
        ReadablePeriod period = new Period(1, 0, 0, 0); // 1 year
        int scalar = 0;

        YearMonth result = yearMonth.withPeriodAdded(period, scalar);

        assertEquals(yearMonth, result);
    }

}