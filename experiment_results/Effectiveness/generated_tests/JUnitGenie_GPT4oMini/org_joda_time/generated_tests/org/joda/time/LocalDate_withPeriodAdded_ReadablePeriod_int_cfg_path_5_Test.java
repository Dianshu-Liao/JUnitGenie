package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePeriod;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDate_withPeriodAdded_ReadablePeriod_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWithPeriodAdded_NullPeriod() {
        LocalDate localDate = new LocalDate(2023, 10, 1); // Example date
        ReadablePeriod period = null;
        int scalar = 5;

        LocalDate result = localDate.withPeriodAdded(period, scalar);

        // Since the period is null, the result should be the same as the original date
        assertEquals(localDate, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_ScalarZero() {
        LocalDate localDate = new LocalDate(2023, 10, 1); // Example date
        ReadablePeriod period = new org.joda.time.Period(1, 0, 0, 0); // 1 year
        int scalar = 0;

        LocalDate result = localDate.withPeriodAdded(period, scalar);

        // Since the scalar is zero, the result should be the same as the original date
        assertEquals(localDate, result);
    }

}