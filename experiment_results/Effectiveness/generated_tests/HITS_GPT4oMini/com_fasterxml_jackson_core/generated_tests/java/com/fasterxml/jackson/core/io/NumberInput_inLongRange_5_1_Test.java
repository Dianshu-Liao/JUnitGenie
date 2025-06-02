// Replace with the actual package name
package com.fasterxml.jackson.core.io;

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

public class NumberInput_inLongRange_5_1_Test {

    @Test
    public void testInLongRange_WithNegativeValue_WithinRange() {
        char[] input = "-9223372036854775808".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, true));
    }

    @Test
    public void testInLongRange_WithNegativeValue_ExceedsRange() {
        char[] input = "-9223372036854775809".toCharArray();
        assertFalse(NumberInput.inLongRange(input, 0, input.length, true));
    }

    @Test
    public void testInLongRange_WithPositiveValue_WithinRange() {
        char[] input = "9223372036854775807".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_WithPositiveValue_ExceedsRange() {
        char[] input = "9223372036854775808".toCharArray();
        assertFalse(NumberInput.inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_WithEqualValue_MaxLong() {
        char[] input = "9223372036854775807".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_WithEqualValue_MinLong() {
        char[] input = "-9223372036854775808".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, true));
    }

    @Test
    public void testInLongRange_WithShorterLength() {
        // Shorter than max long
        char[] input = "92233720368547758".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_WithLongerLength() {
        // Longer than max long
        char[] input = "92233720368547758077".toCharArray();
        assertFalse(NumberInput.inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_WithZeroValue() {
        char[] input = "0".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, false));
    }

    @Test
    public void testInLongRange_WithNegativeZero() {
        char[] input = "0".toCharArray();
        assertTrue(NumberInput.inLongRange(input, 0, input.length, true));
    }
}
