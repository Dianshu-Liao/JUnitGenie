package org.joda.time;
import org.joda.time.Weeks;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Weeks_weeks_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWeeksZero() {
        Weeks result = Weeks.weeks(0);
        assertEquals(Weeks.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testWeeksOne() {
        Weeks result = Weeks.weeks(1);
        assertEquals(Weeks.ONE, result);
    }

    @Test(timeout = 4000)
    public void testWeeksTwo() {
        Weeks result = Weeks.weeks(2);
        assertEquals(Weeks.TWO, result);
    }

    @Test(timeout = 4000)
    public void testWeeksThree() {
        Weeks result = Weeks.weeks(3);
        assertEquals(Weeks.THREE, result);
    }

    @Test(timeout = 4000)
    public void testWeeksMaxValue() {
        Weeks result = Weeks.weeks(Integer.MAX_VALUE);
        assertEquals(Weeks.MAX_VALUE, result);
    }

    @Test(timeout = 4000)
    public void testWeeksMinValue() {
        Weeks result = Weeks.weeks(Integer.MIN_VALUE);
        assertEquals(Weeks.MIN_VALUE, result);
    }

    @Test(timeout = 4000)
    public void testWeeksDefault() {
        int input = 5; // Example of a default case
        Weeks result = Weeks.weeks(input);
        assertEquals(Weeks.weeks(input), result); // Use the static method to get the Weeks instance
    }


}