package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Years_years_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testYearsWithOne() {
        // Test case for the input 1
        Years result = Years.years(1);
        assertEquals(Years.ONE, result);
    }

}