package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class io_NumberInput_inLongRange_String_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeFalse() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithNegativeTrue() {
        String testString = "9223372036854775807"; // Long.MAX_VALUE
        boolean negative = true;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithShorterString() {
        String testString = "123"; // Shorter than Long.MAX_VALUE
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithLongerString() {
        String testString = "9223372036854775808"; // Longer than Long.MAX_VALUE
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testInLongRangeWithEqualString() {
        String testString = "9223372036854775807"; // Equal to Long.MAX_VALUE
        boolean negative = false;
        boolean result = NumberInput.inLongRange(testString, negative);
        assertTrue(result);
    }

}