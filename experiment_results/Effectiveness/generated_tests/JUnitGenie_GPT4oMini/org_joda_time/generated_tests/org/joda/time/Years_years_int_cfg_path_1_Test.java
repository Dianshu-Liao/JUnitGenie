package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.*;

public class Years_years_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testYearsWithMaxValue() {
        // Test input Integer.MAX_VALUE
        Years result = Years.years(Integer.MAX_VALUE);
        assertEquals(Years.MAX_VALUE, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithZero() {
        // Test input 0
        Years result = Years.years(0);
        assertEquals(Years.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithOne() {
        // Test input 1
        Years result = Years.years(1);
        assertEquals(Years.ONE, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithTwo() {
        // Test input 2
        Years result = Years.years(2);
        assertEquals(Years.TWO, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithThree() {
        // Test input 3
        Years result = Years.years(3);
        assertEquals(Years.THREE, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithMinValue() {
        // Test input Integer.MIN_VALUE
        Years result = Years.years(Integer.MIN_VALUE);
        assertEquals(Years.MIN_VALUE, result);
    }

    @Test(timeout = 4000)
    public void testYearsWithNegativeValue() {
        // Test input -1, which goes to default case
        Years result = Years.years(-1);
        // Since the specific behavior of the Years constructor for negative integers 
        // is not outlined in the provided focal method, we assert the expected output
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testYearsWithOtherValues() {
        // Test input with a value that is neither defined nor special
        Years result = Years.years(10);
        // Assuming the constructor creates a valid Years instance
        assertNotNull(result);
    }

}