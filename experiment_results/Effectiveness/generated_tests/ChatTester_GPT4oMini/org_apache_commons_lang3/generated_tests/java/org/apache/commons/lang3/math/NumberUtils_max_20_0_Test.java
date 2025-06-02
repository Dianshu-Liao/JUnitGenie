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

class NumberUtils_max_20_0_Test {

    @Test
    void testMaxWithValidInput() {
        assertEquals(5.0, NumberUtils.max(1.0, 2.0, 3.0, 4.0, 5.0));
        assertEquals(-1.0, NumberUtils.max(-5.0, -4.0, -3.0, -2.0, -1.0));
        assertEquals(0.0, NumberUtils.max(0.0, -1.0, -2.0));
        assertEquals(1.0, NumberUtils.max(1.0));
    }

    @Test
    void testMaxWithNaN() {
        assertEquals(Double.NaN, NumberUtils.max(1.0, Double.NaN, 3.0));
        assertEquals(Double.NaN, NumberUtils.max(Double.NaN));
    }

    @Test
    void testMaxWithEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.max();
        });
        assertEquals("Array must not be empty", exception.getMessage());
    }

    @Test
    void testMaxWithSingleElementArray() {
        assertEquals(10.0, NumberUtils.max(10.0));
        assertEquals(-10.0, NumberUtils.max(-10.0));
    }

    @Test
    void testMaxWithNegativeAndPositiveValues() {
        assertEquals(10.0, NumberUtils.max(-10.0, 0.0, 10.0));
        assertEquals(5.0, NumberUtils.max(-5.0, -10.0, 5.0));
    }

    @Test
    void testMaxWithAllNaNValues() {
        assertEquals(Double.NaN, NumberUtils.max(Double.NaN, Double.NaN));
    }

    @Test
    void testMaxWithMixedValues() {
        assertEquals(3.5, NumberUtils.max(-1.0, 3.5, 2.1, -2.2));
        assertEquals(0.0, NumberUtils.max(-1.0, -2.0, 0.0));
    }

    @Test
    void testMaxWithVeryLargeValues() {
        assertEquals(Double.MAX_VALUE, NumberUtils.max(Double.MAX_VALUE, 1.0, 2.0));
        assertEquals(Double.MAX_VALUE, NumberUtils.max(Double.MAX_VALUE, Double.MIN_VALUE));
    }

    @Test
    void testMaxWithVerySmallValues() {
        assertEquals(Double.MIN_VALUE, NumberUtils.max(Double.MIN_VALUE, 0.0));
        assertEquals(0.0, NumberUtils.max(-Double.MIN_VALUE, 0.0));
    }
}
