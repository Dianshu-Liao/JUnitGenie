package org.joda.time;
import org.joda.time.Hours;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Hours_plus_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusWithZero() {
        try {
            Hours hours = Hours.hours(5);
            Hours result = hours.plus(0);
            assertEquals(hours, result); // Expecting the same instance returned
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception if it occurs
        }
    }

    @Test(timeout = 4000)
    public void testPlusWithPositiveHours() {
        try {
            Hours hours = Hours.hours(5);
            Hours result = hours.plus(2);
            assertEquals(Hours.hours(7), result); // Expecting the result to be 7 hours
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception if it occurs
        }
    }

}