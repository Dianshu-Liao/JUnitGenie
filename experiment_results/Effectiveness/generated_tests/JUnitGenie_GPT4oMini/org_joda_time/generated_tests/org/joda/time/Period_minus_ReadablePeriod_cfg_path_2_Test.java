package org.joda.time;
import org.joda.time.Period;
import org.joda.time.ReadablePeriod;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Period_minus_ReadablePeriod_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusWithNullPeriod() {
        Period period = new Period();
        Period result = period.minus(null);
        assertEquals(period, result);
    }

}