package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // MAX_LONG_STR
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result); // Should return false as the string is equal to MAX_LONG_STR
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeTrue() {
        String testString = "9223372036854775806"; // Just below MAX_LONG_STR
        boolean negative = true;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result); // Should return true as the string is less than MIN_LONG_STR_NO_SIGN
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithShorterString() {
        String testString = "123"; // Shorter than MIN_LONG_STR_NO_SIGN
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result); // Should return true as the string is shorter
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithEqualLength() {
        String testString = "9223372036854775807"; // Equal to MAX_LONG_STR
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result); // Should return false as the string is equal to MAX_LONG_STR
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongerString() {
        String testString = "9223372036854775808"; // Longer than MAX_LONG_STR
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result); // Should return false as the string is longer
    }

}