package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.fasterxml.jackson.core.io.NumberInput;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testInLongRange_NegativeTrue_SmallValue() {
        // Test case where input is within the min long range
        String s = String.valueOf(Long.MIN_VALUE).substring(1);
        boolean negative = true;

        try {
            boolean result = NumberInput.inLongRange(s, negative);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRange_NegativeTrue_LargeValue() {
        // Test case where input is just outside the min long range
        String s = String.valueOf(Long.MIN_VALUE);
        boolean negative = true;

        try {
            boolean result = NumberInput.inLongRange(s, negative);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRange_NegativeFalse_LargeValue() {
        // Test case where input is just within the max long range
        String s = String.valueOf(Long.MAX_VALUE);
        boolean negative = false;

        try {
            boolean result = NumberInput.inLongRange(s, negative);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRange_NegativeFalse_OutsideMax() {
        // Test case where input is outside the max long range
        String s = String.valueOf(Long.MAX_VALUE + 1);
        boolean negative = false;

        try {
            boolean result = NumberInput.inLongRange(s, negative);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}