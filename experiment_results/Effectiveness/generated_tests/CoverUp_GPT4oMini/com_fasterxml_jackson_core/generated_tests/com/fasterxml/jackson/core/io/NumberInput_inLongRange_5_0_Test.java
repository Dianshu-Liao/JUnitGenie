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
    public void testInLongRange_LessThanMinLong() throws Exception {
        // Less than Long.MIN_VALUE
        char[] input = "-9223372036854775809".toCharArray();
        assertTrue(inLongRange(input, 0, input.length, true));
    }

    @Test
    public void testInLongRange_EqualToMinLong() throws Exception {
        // Equal to Long.MIN_VALUE
        char[] input = "-9223372036854775808".toCharArray();
        assertFalse(inLongRange(input, 0, input.length, true));
    }

    @Test
    public void testInLongRange_GreaterThanMinLong() throws Exception {
        // Greater than Long.MIN_VALUE
        char[] input = "-9223372036854775807".toCharArray();
        assertFalse(inLongRange(input, 0, input.length, true));
    }

    @Test
    public void testInLongRange_LessThanMaxLong() throws Exception {
        // Less than Long.MAX_VALUE
        char[] input = "9223372036854775806".toCharArray();
        assertTrue(inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_EqualToMaxLong() throws Exception {
        // Equal to Long.MAX_VALUE
        char[] input = "9223372036854775807".toCharArray();
        assertFalse(inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_GreaterThanMaxLong() throws Exception {
        // Greater than Long.MAX_VALUE
        char[] input = "9223372036854775808".toCharArray();
        assertFalse(inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_EmptyInput() throws Exception {
        // Empty input
        char[] input = "".toCharArray();
        assertTrue(inLongRange(input, 0, 0, false));
    }

    @Test
    public void testInLongRange_SingleDigitInput() throws Exception {
        // Single digit input
        char[] input = "5".toCharArray();
        assertTrue(inLongRange(input, 0, input.length, false));
    }

    private boolean inLongRange(char[] ch, int off, int len, boolean negative) throws Exception {
        Method method = NumberInput.class.getDeclaredMethod("inLongRange", char[].class, int.class, int.class, boolean.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, ch, off, len, negative);
    }
}
