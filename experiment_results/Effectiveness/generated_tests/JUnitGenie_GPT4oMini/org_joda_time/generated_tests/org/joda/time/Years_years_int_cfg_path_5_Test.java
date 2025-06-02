package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class Years_years_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testYearsWithZero() {
        Years result = Years.years(0);
        assertSame(Years.ZERO, result);
    }
    
    @Test(timeout = 4000)
    public void testYearsWithOne() {
        Years result = Years.years(1);
        assertSame(Years.ONE, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithTwo() {
        Years result = Years.years(2);
        assertSame(Years.TWO, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithThree() {
        Years result = Years.years(3);
        assertSame(Years.THREE, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithMaxValue() {
        Years result = Years.years(Integer.MAX_VALUE);
        assertSame(Years.years(Integer.MAX_VALUE), result);
    }

    @Test(timeout = 4000)
    public void testYearsWithMinValue() {
        Years result = Years.years(Integer.MIN_VALUE);
        assertSame(Years.years(Integer.MIN_VALUE), result);
    }

    @Test(timeout = 4000)
    public void testYearsWithOtherValue() {
        int testValue = 5; // any random value that is not covered by the switch
        Years result = Years.years(testValue);
        assertSame(Years.years(testValue), result);
    }


}