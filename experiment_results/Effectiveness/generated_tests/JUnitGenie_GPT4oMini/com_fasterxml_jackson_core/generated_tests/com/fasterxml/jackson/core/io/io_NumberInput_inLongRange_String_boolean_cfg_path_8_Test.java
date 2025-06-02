package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result); // Should return false as it is equal to MAX_LONG_STR
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeTrue() {
        String testString = "-9223372036854775808"; // Long.MIN_VALUE
        boolean negative = true;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result); // Should return true as it is less than MIN_LONG_STR_NO_SIGN
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithShorterString() {
        String testString = "12345"; // Shorter than MAX_LONG_STR
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result); // Should return true as it is shorter than MAX_LONG_STR
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongerString() {
        String testString = "9223372036854775808"; // Longer than MAX_LONG_STR
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result); // Should return false as it is greater than MAX_LONG_STR
    }

}