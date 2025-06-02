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

public class NumberUtils_max_21_0_Test {

    @Test
    public void testMaxWithAllPositiveNumbers() {
        double result = NumberUtils.max(1.0, 2.0, 3.0);
        assertEquals(3.0, result);
    }

    @Test
    public void testMaxWithNegativeAndPositiveNumbers() {
        double result = NumberUtils.max(-1.0, 0.0, 1.0);
        assertEquals(1.0, result);
    }

    @Test
    public void testMaxWithAllNegativeNumbers() {
        double result = NumberUtils.max(-1.0, -2.0, -3.0);
        assertEquals(-1.0, result);
    }

    @Test
    public void testMaxWithTwoEqualNumbers() {
        double result = NumberUtils.max(2.0, 2.0, 1.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testMaxWithAllZeros() {
        double result = NumberUtils.max(0.0, 0.0, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    public void testMaxWithLargeNumbers() {
        double result = NumberUtils.max(Double.MAX_VALUE, 1.0, 0.0);
        assertEquals(Double.MAX_VALUE, result);
    }

    @Test
    public void testMaxWithMixedInfinity() {
        double result = NumberUtils.max(Double.POSITIVE_INFINITY, 1.0, -1.0);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void testMaxWithNaN() {
        double result = NumberUtils.max(Double.NaN, 1.0, 2.0);
        assertTrue(Double.isNaN(result));
    }
}
