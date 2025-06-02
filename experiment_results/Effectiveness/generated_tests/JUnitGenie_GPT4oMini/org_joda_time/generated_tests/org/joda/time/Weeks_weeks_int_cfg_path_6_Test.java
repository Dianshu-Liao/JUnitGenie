package org.joda.time;
import org.joda.time.Weeks;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Weeks_weeks_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWeeksWithMinValue() {
        try {
            Weeks result = Weeks.weeks(Integer.MIN_VALUE);
            assertEquals(Weeks.MIN_VALUE, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}