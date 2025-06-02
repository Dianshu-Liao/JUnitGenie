package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.fasterxml.jackson.core.io.NumberInput;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertFalse(result); // Should return false as it is equal to MAX_LONG_STR
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeTrue() {
        String testString = "9223372036854775806"; // Just below Long.MAX_VALUE
        boolean negative = true;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Should return true as it is less than MAX_LONG_STR
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithShorterString() {
        String testString = "123"; // Shorter than MAX_LONG_STR
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Should return true as it is shorter
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongerString() {
        String testString = "9223372036854775808"; // Longer than MAX_LONG_STR
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertFalse(result); // Should return false as it is longer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}