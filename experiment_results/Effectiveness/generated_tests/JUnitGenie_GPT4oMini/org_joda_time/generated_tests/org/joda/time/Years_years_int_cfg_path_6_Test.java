package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Years_years_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testYearsWithMinValue() {
        try {
            Years result = Years.years(Integer.MIN_VALUE);
            assertEquals(Years.MIN_VALUE, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}