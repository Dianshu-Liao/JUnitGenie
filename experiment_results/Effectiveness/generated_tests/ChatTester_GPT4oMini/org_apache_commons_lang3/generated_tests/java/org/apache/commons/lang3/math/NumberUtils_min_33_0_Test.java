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

public class NumberUtils_min_33_0_Test {

    @Test
    public void testMin_WithPositiveNumbers() {
        double result = NumberUtils.min(5.0, 10.0, 3.0);
        assertEquals(3.0, result);
    }

    @Test
    public void testMin_WithNegativeNumbers() {
        double result = NumberUtils.min(-1.0, -5.0, -3.0);
        assertEquals(-5.0, result);
    }

    @Test
    public void testMin_WithMixedNumbers() {
        double result = NumberUtils.min(-1.0, 5.0, 3.0);
        assertEquals(-1.0, result);
    }

    @Test
    public void testMin_WithZeros() {
        double result = NumberUtils.min(0.0, 0.0, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    public void testMin_WithIdenticalNumbers() {
        double result = NumberUtils.min(2.0, 2.0, 2.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testMin_WithInfinity() {
        double result = NumberUtils.min(Double.POSITIVE_INFINITY, 1.0, 2.0);
        assertEquals(1.0, result);
    }

    @Test
    public void testMin_WithNaN() {
        double result = NumberUtils.min(Double.NaN, 1.0, 2.0);
        // NaN should not affect the minimum
        assertEquals(1.0, result);
    }
}
