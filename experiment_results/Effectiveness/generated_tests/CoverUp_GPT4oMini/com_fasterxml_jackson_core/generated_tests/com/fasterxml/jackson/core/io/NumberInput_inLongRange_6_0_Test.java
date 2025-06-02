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

public class NumberInput_inLongRange_6_0_Test {

    @Test
    public void testInLongRange_ValidPositiveLong() {
        assertTrue(NumberInput.inLongRange("1000000000", false));
        assertTrue(NumberInput.inLongRange("999999999", false));
        assertTrue(NumberInput.inLongRange("0", false));
        // max int
        assertTrue(NumberInput.inLongRange("2147483647", false));
    }

    @Test
    public void testInLongRange_ValidNegativeLong() {
        assertTrue(NumberInput.inLongRange("-1000000000", true));
        assertTrue(NumberInput.inLongRange("-999999999", true));
        assertTrue(NumberInput.inLongRange("-1", true));
        // min int
        assertTrue(NumberInput.inLongRange("-2147483648", true));
    }

    @Test
    public void testInLongRange_ExceedingPositiveLong() {
        assertFalse(NumberInput.inLongRange("10000000000", false));
        // Long.MAX_VALUE + 1
        assertFalse(NumberInput.inLongRange("9223372036854775808", false));
    }

    @Test
    public void testInLongRange_ExceedingNegativeLong() {
        assertFalse(NumberInput.inLongRange("-10000000001", true));
        // Long.MIN_VALUE - 1
        assertFalse(NumberInput.inLongRange("-9223372036854775809", true));
    }

    @Test
    public void testInLongRange_EqualMaxLong() {
        // Long.MAX_VALUE
        assertTrue(NumberInput.inLongRange("9223372036854775807", false));
    }

    @Test
    public void testInLongRange_EqualMinLong() {
        // Long.MIN_VALUE
        assertTrue(NumberInput.inLongRange("-9223372036854775808", true));
    }

    @Test
    public void testInLongRange_EmptyString() {
        assertTrue(NumberInput.inLongRange("", false));
        assertTrue(NumberInput.inLongRange("", true));
    }

    @Test
    public void testInLongRange_SingleDigit() {
        assertTrue(NumberInput.inLongRange("5", false));
        assertTrue(NumberInput.inLongRange("-5", true));
    }

    @Test
    public void testInLongRange_NastySmallDouble() {
        assertTrue(NumberInput.inLongRange(NumberInput.NASTY_SMALL_DOUBLE, false));
        assertTrue(NumberInput.inLongRange("-" + NumberInput.NASTY_SMALL_DOUBLE, true));
    }
}
