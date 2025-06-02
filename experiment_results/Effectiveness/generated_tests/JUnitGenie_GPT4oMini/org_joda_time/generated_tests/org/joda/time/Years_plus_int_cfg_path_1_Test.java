package org.joda.time;
import org.joda.time.Years;
import org.joda.time.field.FieldUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Years_plus_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusWithNonZeroYears() {
        try {
            Years years = Years.years(5);
            Years result = years.plus(3);
            assertEquals(8, result.getYears()); // Changed getValue() to getYears()
        } catch (Exception e) {
            fail("Should not have thrown any exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPlusWithZeroYears() {
        try {
            Years years = Years.years(5);
            Years result = years.plus(0);
            assertEquals(5, result.getYears()); // Changed getValue() to getYears()
        } catch (Exception e) {
            fail("Should not have thrown any exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPlusWithNegativeYears() {
        try {
            Years years = Years.years(5);
            Years result = years.plus(-2);
            assertEquals(3, result.getYears()); // Changed getValue() to getYears()
        } catch (Exception e) {
            fail("Should not have thrown any exception: " + e.getMessage());
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testPlusYearsOverflow() {
        try {
            Years years = Years.years(Integer.MAX_VALUE);
            years.plus(1); // This should trigger an overflow
        } catch (ArithmeticException e) {
            // Expected behavior
            throw e;
        } catch (Exception e) {
            fail("Should have thrown ArithmeticException: " + e.getMessage());
        }
    }


}