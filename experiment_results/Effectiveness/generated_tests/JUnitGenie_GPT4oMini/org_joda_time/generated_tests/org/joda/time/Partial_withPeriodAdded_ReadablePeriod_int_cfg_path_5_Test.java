package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Partial_withPeriodAdded_ReadablePeriod_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWithPeriodAdded_NullPeriod() {
        Partial partial = new Partial();
        ReadablePeriod period = null;
        int scalar = 5;

        Partial result = partial.withPeriodAdded(period, scalar);

        // Since the period is null, the result should be the same as the original partial
        assertEquals(partial, result);
    }

    @Test(timeout = 4000)
    public void testWithPeriodAdded_ScalarZero() {
        Partial partial = new Partial();
        ReadablePeriod period = new Period(1); // Example period
        int scalar = 0;

        Partial result = partial.withPeriodAdded(period, scalar);

        // Since the scalar is zero, the result should be the same as the original partial
        assertEquals(partial, result);
    }

}