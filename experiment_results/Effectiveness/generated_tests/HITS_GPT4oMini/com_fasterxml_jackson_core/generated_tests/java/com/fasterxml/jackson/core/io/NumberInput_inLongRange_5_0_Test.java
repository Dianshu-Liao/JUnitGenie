// Replace with the actual package name where NumberInput is located
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

public class NumberInput_inLongRange_5_0_Test {

    @Test
    public void testInLongRange_LengthLessThanMaxLongString() {
        // Length is less than MAX_LONG_STR (19)
        char[] input = "123456789".toCharArray();
        boolean negative = false;
        assertTrue(NumberInput.inLongRange(input, 0, input.length, negative));
    }

    @Test
    public void testInLongRange_LengthEqualToMaxLongString() {
        // Length is equal to MAX_LONG_STR (19)
        char[] input = "9223372036854775807".toCharArray();
        boolean negative = false;
        assertTrue(NumberInput.inLongRange(input, 0, input.length, negative));
    }

    @Test
    public void testInLongRange_LengthGreaterThanMaxLongString() {
        // Length is greater than MAX_LONG_STR (19)
        char[] input = "92233720368547758070".toCharArray();
        boolean negative = false;
        assertFalse(NumberInput.inLongRange(input, 0, input.length, negative));
    }

    @Test
    public void testInLongRange_NegativeLengthLessThanMinLongString() {
        // Length is less than MIN_LONG_STR_NO_SIGN (19)
        char[] input = "123456789".toCharArray();
        boolean negative = true;
        assertTrue(NumberInput.inLongRange(input, 0, input.length, negative));
    }

    @Test
    public void testInLongRange_NegativeLengthEqualToMinLongString() {
        // Length is equal to MIN_LONG_STR_NO_SIGN (19)
        char[] input = "9223372036854775808".toCharArray();
        boolean negative = true;
        assertTrue(NumberInput.inLongRange(input, 0, input.length, negative));
    }

    @Test
    public void testInLongRange_NegativeLengthGreaterThanMinLongString() {
        // Length is greater than MIN_LONG_STR_NO_SIGN (19)
        char[] input = "92233720368547758080".toCharArray();
        boolean negative = true;
        assertFalse(NumberInput.inLongRange(input, 0, input.length, negative));
    }
}
