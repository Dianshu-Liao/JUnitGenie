package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Years_years_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testYearsWithThree() {
        try {
            Years result = Years.years(3);
            assertEquals(Years.THREE, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}