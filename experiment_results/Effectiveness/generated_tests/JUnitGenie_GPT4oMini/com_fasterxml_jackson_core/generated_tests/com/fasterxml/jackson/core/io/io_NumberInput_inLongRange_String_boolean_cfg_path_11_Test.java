package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegative() {
        String input = String.valueOf(Long.MIN_VALUE).substring(1); // This should be less than MIN_LONG_STR_NO_SIGN
        boolean negative = true;
        try {
            boolean result = NumberInput.inLongRange(input, negative);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithPositive() {
        String input = String.valueOf(Long.MAX_VALUE); // This should be greater than MIN_LONG_STR_NO_SIGN
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(input, negative);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeEqualLength() {
        String input = String.valueOf(Long.MIN_VALUE); // This should be equal to MIN_LONG_STR_NO_SIGN
        boolean negative = true;
        try {
            boolean result = NumberInput.inLongRange(input, negative);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}