package org.joda.time;
import org.joda.time.Weeks;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Weeks_weeks_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWeeksWithOne() {
        try {
            Weeks result = Weeks.weeks(1);
            assertEquals(Weeks.ONE, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}