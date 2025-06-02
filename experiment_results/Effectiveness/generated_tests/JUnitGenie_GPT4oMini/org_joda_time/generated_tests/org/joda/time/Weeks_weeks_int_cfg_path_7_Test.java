package org.joda.time;
import org.joda.time.Weeks;
import org.junit.Test;
import static org.junit.Assert.*;

public class Weeks_weeks_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testWeeksWithZero() {
        try {
            Weeks result = Weeks.weeks(0);
            assertEquals(Weeks.ZERO, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input 0");
        }
    }

    @Test(timeout = 4000)
    public void testWeeksWithOne() {
        try {
            Weeks result = Weeks.weeks(1);
            assertEquals(Weeks.ONE, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input 1");
        }
    }

    @Test(timeout = 4000)
    public void testWeeksWithTwo() {
        try {
            Weeks result = Weeks.weeks(2);
            assertEquals(Weeks.TWO, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input 2");
        }
    }

    @Test(timeout = 4000)
    public void testWeeksWithThree() {
        try {
            Weeks result = Weeks.weeks(3);
            assertEquals(Weeks.THREE, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input 3");
        }
    }

    @Test(timeout = 4000)
    public void testWeeksWithMaxValue() {
        try {
            Weeks result = Weeks.weeks(Integer.MAX_VALUE);
            assertEquals(Weeks.weeks(Integer.MAX_VALUE), result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input Integer.MAX_VALUE");
        }
    }

    @Test(timeout = 4000)
    public void testWeeksWithMinValue() {
        try {
            Weeks result = Weeks.weeks(Integer.MIN_VALUE);
            assertEquals(Weeks.weeks(Integer.MIN_VALUE), result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input Integer.MIN_VALUE");
        }
    }

    @Test(timeout = 4000)
    public void testWeeksWithDefaultCase() {
        try {
            int testValue = 5; // Any integer not covered by the switch cases
            Weeks result = Weeks.weeks(testValue);
            assertEquals(Weeks.weeks(testValue), result);
        } catch (Exception e) {
            fail("Exception should not be thrown for input 5");
        }
    }


}