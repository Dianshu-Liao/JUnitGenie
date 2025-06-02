package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;
import ch.randelshofer.fastdoubleparser.JavaDoubleParser;
import ch.randelshofer.fastdoubleparser.JavaFloatParser;

public class NumberInput_inLongRange_5_0_Test {

    @Test
    public void testInLongRange_PositiveWithinRange() throws Exception {
        // MAX_LONG_STR
        char[] input = "9223372036854775807".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, false);
        assertTrue(result);
    }

    @Test
    public void testInLongRange_PositiveExceedingRange() throws Exception {
        // Exceeds MAX_LONG
        char[] input = "9223372036854775808".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, false);
        assertFalse(result);
    }

    @Test
    public void testInLongRange_NegativeWithinRange() throws Exception {
        // MIN_LONG_STR_NO_SIGN
        char[] input = "-9223372036854775808".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, true);
        assertTrue(result);
    }

    @Test
    public void testInLongRange_NegativeExceedingRange() throws Exception {
        // Exceeds MIN_LONG
        char[] input = "-9223372036854775809".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, true);
        assertFalse(result);
    }

    @Test
    public void testInLongRange_EqualToMaxLong() throws Exception {
        // Equal to MAX_LONG
        char[] input = "9223372036854775807".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, false);
        assertTrue(result);
    }

    @Test
    public void testInLongRange_EqualToMinLong() throws Exception {
        // Equal to MIN_LONG
        char[] input = "-9223372036854775808".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, true);
        assertTrue(result);
    }

    @Test
    public void testInLongRange_EmptyInput() throws Exception {
        // Empty input
        char[] input = "".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, false);
        // Should return true as len < cmpLen
        assertTrue(result);
    }

    @Test
    public void testInLongRange_NegativeShorterThanMinLong() throws Exception {
        // Shorter than MIN_LONG
        char[] input = "-9223372036854775807".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, true);
        // Should return true as len < cmpLen
        assertTrue(result);
    }

    @Test
    public void testInLongRange_PositiveShorterThanMaxLong() throws Exception {
        // Shorter than MAX_LONG
        char[] input = "9223372036854775806".toCharArray();
        boolean result = invokeInLongRange(input, 0, input.length, false);
        // Should return true as len < cmpLen
        assertTrue(result);
    }

    private boolean invokeInLongRange(char[] ch, int off, int len, boolean negative) throws Exception {
        Method method = NumberInput.class.getDeclaredMethod("inLongRange", char[].class, int.class, int.class, boolean.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, ch, off, len, negative);
    }
}
