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
    public void testInLongRange_LessThanMinLong() {
        assertTrue(NumberInput.inLongRange("-9223372036854775809", true));
    }

    @Test
    public void testInLongRange_EqualToMinLong() {
        assertFalse(NumberInput.inLongRange("-9223372036854775808", true));
    }

    @Test
    public void testInLongRange_GreaterThanMinLong() {
        assertFalse(NumberInput.inLongRange("-9223372036854775807", true));
    }

    @Test
    public void testInLongRange_LessThanMaxLong() {
        assertTrue(NumberInput.inLongRange("9223372036854775806", false));
    }

    @Test
    public void testInLongRange_EqualToMaxLong() {
        assertFalse(NumberInput.inLongRange("9223372036854775807", false));
    }

    @Test
    public void testInLongRange_GreaterThanMaxLong() {
        assertFalse(NumberInput.inLongRange("9223372036854775808", false));
    }

    @Test
    public void testInLongRange_EmptyString() {
        assertTrue(NumberInput.inLongRange("", false));
    }

    @Test
    public void testInLongRange_SingleDigit() {
        assertTrue(NumberInput.inLongRange("5", false));
        assertTrue(NumberInput.inLongRange("-5", true));
    }

    @Test
    public void testInLongRange_NegativeSingleDigit() {
        assertTrue(NumberInput.inLongRange("-1", true));
    }

    @Test
    public void testInLongRange_PositiveSingleDigit() {
        assertTrue(NumberInput.inLongRange("1", false));
    }

    @Test
    public void testInLongRange_NegativeLongString() {
        assertFalse(NumberInput.inLongRange("-10000000000000000000", true));
    }

    @Test
    public void testInLongRange_PositiveLongString() {
        assertFalse(NumberInput.inLongRange("10000000000000000000", false));
    }
}
