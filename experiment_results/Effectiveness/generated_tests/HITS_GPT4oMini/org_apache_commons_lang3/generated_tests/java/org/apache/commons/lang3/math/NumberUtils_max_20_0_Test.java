package org.apache.commons.lang3.math;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils_max_20_0_Test {

    @Test
    public void testMaxWithPositiveValues() {
        double[] input = { 1.5, 2.5, 3.5, 4.5 };
        double expected = 4.5;
        double actual = NumberUtils.max(input);
        assertEquals(expected, actual, "The max value should be 4.5");
    }

    @Test
    public void testMaxWithNegativeValues() {
        double[] input = { -1.5, -2.5, -3.5, -4.5 };
        double expected = -1.5;
        double actual = NumberUtils.max(input);
        assertEquals(expected, actual, "The max value should be -1.5");
    }

    @Test
    public void testMaxWithMixedValues() {
        double[] input = { -1.5, 2.5, 0.0, 3.5 };
        double expected = 3.5;
        double actual = NumberUtils.max(input);
        assertEquals(expected, actual, "The max value should be 3.5");
    }

    @Test
    public void testMaxWithSingleValue() {
        double[] input = { 5.0 };
        double expected = 5.0;
        double actual = NumberUtils.max(input);
        assertEquals(expected, actual, "The max value should be 5.0");
    }

    @Test
    public void testMaxWithEmptyArray() {
        double[] input = {};
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.max(input), "Array cannot be empty.");
    }

    @Test
    public void testMaxWithNaNValue() {
        double[] input = { 1.0, Double.NaN, 2.0 };
        double actual = NumberUtils.max(input);
        assertTrue(Double.isNaN(actual), "The max value should be NaN when input contains NaN.");
    }

    @Test
    public void testMaxWithAllNaNValues() {
        double[] input = { Double.NaN, Double.NaN };
        double actual = NumberUtils.max(input);
        assertTrue(Double.isNaN(actual), "The max value should be NaN when all input values are NaN.");
    }

    @Test
    public void testMaxWithZeroValues() {
        double[] input = { 0.0, 0.0, 0.0 };
        double expected = 0.0;
        double actual = NumberUtils.max(input);
        assertEquals(expected, actual, "The max value should be 0.0 when all values are zero.");
    }
}
