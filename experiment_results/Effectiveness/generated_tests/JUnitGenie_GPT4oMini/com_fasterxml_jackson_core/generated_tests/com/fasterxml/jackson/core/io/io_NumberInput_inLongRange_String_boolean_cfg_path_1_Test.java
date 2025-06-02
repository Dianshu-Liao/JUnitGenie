package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;

        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Expecting true since the string is equal to Long.MAX_VALUE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeTrue() {
        String testString = "9223372036854775806"; // One less than Long.MAX_VALUE
        boolean negative = true;

        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Expecting true since the string is less than Long.MAX_VALUE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongValue() {
        String testString = "9223372036854775808"; // One more than Long.MAX_VALUE
        boolean negative = false;

        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(!result); // Expecting false since the string is greater than Long.MAX_VALUE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithShorterString() {
        String testString = "123"; // Shorter than Long.MAX_VALUE
        boolean negative = false;

        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result); // Expecting true since the string is shorter than Long.MAX_VALUE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}