package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.*;

public class Years_years_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testYears() {
        int testInput = 5; // Valid input to cover the default case
        
        try {
            Years result = Years.years(testInput);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testYears_MinValue() {
        int testInput = Integer.MIN_VALUE; // Edge case for minimum integer value
        
        try {
            Years result = Years.years(testInput);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testYears_MaxValue() {
        int testInput = Integer.MAX_VALUE; // Edge case for maximum integer value
        
        try {
            Years result = Years.years(testInput);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testYears_Zero() {
        int testInput = 0; // Test the case when years is 0
        
        try {
            Years result = Years.years(testInput);
            assertEquals(Years.ZERO, result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testYears_One() {
        int testInput = 1; // Test the case when years is 1
        
        try {
            Years result = Years.years(testInput);
            assertEquals(Years.ONE, result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testYears_Two() {
        int testInput = 2; // Test the case when years is 2
        
        try {
            Years result = Years.years(testInput);
            assertEquals(Years.TWO, result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testYears_Three() {
        int testInput = 3; // Test the case when years is 3
        
        try {
            Years result = Years.years(testInput);
            assertEquals(Years.THREE, result);
        } catch (Exception e) {
            fail("Expected not to throw any exception, but got: " + e.getMessage());
        }
    }

}