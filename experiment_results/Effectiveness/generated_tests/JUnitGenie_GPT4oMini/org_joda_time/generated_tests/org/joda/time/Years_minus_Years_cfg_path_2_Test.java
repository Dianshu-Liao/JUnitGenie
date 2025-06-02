package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Years_minus_Years_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusWithNull() {
        Years years = Years.years(5);
        Years result = years.minus(null);
        assertEquals(years, result);
    }

    @Test(timeout = 4000)
    public void testMinusWithValidYears() {
        Years years1 = Years.years(5);
        Years years2 = Years.years(3);
        Years result = years1.minus(years2);
        // Assuming the minus method subtracts the value of years2 from years1
        assertEquals(Years.years(2), result);
    }

}