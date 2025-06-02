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

class NumberUtils_min_32_0_Test {

    @Test
    void testMin_ValidArray() {
        double[] input = { 3.0, 1.5, 2.0, 4.0 };
        double expected = 1.5;
        double actual = NumberUtils.min(input);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testMin_ArrayWithNaN() {
        double[] input = { 3.0, Double.NaN, 2.0, 4.0 };
        double expected = Double.NaN;
        double actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    void testMin_SingleElementArray() {
        double[] input = { 5.0 };
        double expected = 5.0;
        double actual = NumberUtils.min(input);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testMin_EmptyArray() {
        double[] input = {};
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.min(input));
    }

    @Test
    void testMin_AllElementsSame() {
        double[] input = { 2.0, 2.0, 2.0 };
        double expected = 2.0;
        double actual = NumberUtils.min(input);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testMin_NegativeNumbers() {
        double[] input = { -1.0, -3.0, -2.0 };
        double expected = -3.0;
        double actual = NumberUtils.min(input);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testMin_MixedNumbers() {
        double[] input = { 1.0, -1.0, 0.0, 2.0 };
        double expected = -1.0;
        double actual = NumberUtils.min(input);
        assertEquals(expected, actual, 0.001);
    }
}
