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

class NumberUtils_max_23_0_Test {

    @Test
    void testMaxWithAllPositiveNumbers() {
        float result = NumberUtils.max(1.0f, 2.0f, 3.0f);
        assertEquals(3.0f, result);
    }

    @Test
    void testMaxWithNegativeAndPositiveNumbers() {
        float result = NumberUtils.max(-1.0f, 2.0f, 0.0f);
        assertEquals(2.0f, result);
    }

    @Test
    void testMaxWithAllNegativeNumbers() {
        float result = NumberUtils.max(-1.0f, -2.0f, -3.0f);
        assertEquals(-1.0f, result);
    }

    @Test
    void testMaxWithTwoEqualNumbers() {
        float result = NumberUtils.max(2.0f, 2.0f, 1.0f);
        assertEquals(2.0f, result);
    }

    @Test
    void testMaxWithAllZeros() {
        float result = NumberUtils.max(0.0f, 0.0f, 0.0f);
        assertEquals(0.0f, result);
    }

    @Test
    void testMaxWithMixedValues() {
        float result = NumberUtils.max(-1.0f, 1.0f, 0.5f);
        assertEquals(1.0f, result);
    }

    @Test
    void testMaxWithInfinity() {
        float result = NumberUtils.max(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f);
        assertEquals(Float.POSITIVE_INFINITY, result);
    }

    @Test
    void testMaxWithNaN() {
        float result = NumberUtils.max(Float.NaN, 1.0f, 2.0f);
        assertTrue(Float.isNaN(result));
    }
}
