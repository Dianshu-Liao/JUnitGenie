package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDate_withPeriodAdded_ReadablePeriod_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithPeriodAdded_NullPeriod() {
        LocalDate localDate = new LocalDate();
        LocalDate result = localDate.withPeriodAdded(null, 5);
        assertEquals(localDate, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_ZeroScalar() {
        LocalDate localDate = new LocalDate();
        ReadablePeriod period = new Period(1, 0, 0, 0); // 1 year
        LocalDate result = localDate.withPeriodAdded(period, 0);
        assertEquals(localDate, result);
    }

}