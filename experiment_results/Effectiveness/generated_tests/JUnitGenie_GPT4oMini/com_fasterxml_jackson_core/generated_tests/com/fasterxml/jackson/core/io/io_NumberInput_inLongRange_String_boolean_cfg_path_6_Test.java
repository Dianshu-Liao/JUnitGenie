package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.fasterxml.jackson.core.io.NumberInput;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result);
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
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongValueExceedingMax() {
        String testString = "9223372036854775808"; // Exceeds Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongValueLessThanMin() {
        String testString = "-9223372036854775809"; // Less than Long.MIN_VALUE
        boolean negative = true;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithEqualMaxValue() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;
        try {
            boolean result = NumberInput.inLongRange(testString, negative);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}