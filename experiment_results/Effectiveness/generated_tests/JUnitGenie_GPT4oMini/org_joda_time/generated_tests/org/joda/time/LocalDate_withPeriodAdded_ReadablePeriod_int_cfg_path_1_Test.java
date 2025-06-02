package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.joda.time.DurationFieldType;
import org.joda.time.Chronology;
import org.joda.time.MutablePeriod;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDate_withPeriodAdded_ReadablePeriod_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithPeriodAdded_NullPeriod() {
        LocalDate localDate = new LocalDate();
        LocalDate result = localDate.withPeriodAdded(null, 5);
        assertEquals(localDate, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_ScalarZero() {
        LocalDate localDate = new LocalDate();
        LocalDate result = localDate.withPeriodAdded(new Period(1), 0);
        assertEquals(localDate, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_ValidPeriod() {
        LocalDate localDate = new LocalDate(2021, 1, 1);
        ReadablePeriod period = new Period(1, 0, 0, 0); // 1 year
        LocalDate result = localDate.withPeriodAdded(period, 1);
        LocalDate expected = new LocalDate(2022, 1, 1);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_EmptyPeriod() {
        LocalDate localDate = new LocalDate(2021, 1, 1);
        ReadablePeriod period = new Period(0); // Empty period
        LocalDate result = localDate.withPeriodAdded(period, 1);
        assertEquals(localDate, result);
    }

}