package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Should return true as the string is equal to Long.MAX_VALUE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeTrue() {
        String testString = "-9223372036854775808"; // Long.MIN_VALUE
        boolean negative = true;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Should return true as the string is less than Long.MAX_VALUE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithShorterString() {
        String testString = "12345"; // Shorter than Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Should return true as the string is shorter
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongerString() {
        String testString = "9223372036854775808"; // Longer than Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertFalse(result); // Should return false as the string is longer
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithEqualString() {
        String testString = "9223372036854775807"; // Equal to Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Should return true as the string is equal
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}