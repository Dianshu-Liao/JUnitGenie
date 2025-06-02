package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.fasterxml.jackson.core.io.NumberInput;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegative() {
        String testValue = "9223372036854775807"; // Example outside the range for negative
        boolean negative = true;
        try {
            boolean result = NumberInput.inLongRange(testValue, negative);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithinRange() {
        String testValue = "9223372036854775801"; // Example within the range
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testValue, negative);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testInLongRangeEqualToMaxLong() {
        String testValue = "9223372036854775807"; // Example equal to MAX_LONG
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testValue, negative);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeShorterThanMinLong() {
        String testValue = "0"; // Example shorter than MIN_LONG
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testValue, negative);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testInLongRangeLongerThanMaxLong() {
        String testValue = "10000000000000000000"; // Example longer than MAX_LONG
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testValue, negative);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}