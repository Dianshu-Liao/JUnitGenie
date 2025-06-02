package org.joda.time;
import org.joda.time.Weeks;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Weeks_weeks_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWeeksWithMaxValue() {
        try {
            Weeks result = Weeks.weeks(Integer.MAX_VALUE);
            assertEquals(Weeks.MAX_VALUE, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}