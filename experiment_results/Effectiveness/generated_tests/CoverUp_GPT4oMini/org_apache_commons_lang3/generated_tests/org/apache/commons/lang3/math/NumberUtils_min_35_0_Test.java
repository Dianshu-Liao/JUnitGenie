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

public class NumberUtils_min_35_0_Test {

    @Test
    public void testMinWithPositiveNumbers() {
        float result = NumberUtils.min(1.5f, 2.5f, 3.5f);
        assertEquals(1.5f, result);
    }

    @Test
    public void testMinWithNegativeNumbers() {
        float result = NumberUtils.min(-1.5f, -2.5f, -3.5f);
        assertEquals(-3.5f, result);
    }

    @Test
    public void testMinWithMixedNumbers() {
        float result = NumberUtils.min(-1.5f, 2.5f, 0.0f);
        assertEquals(-1.5f, result);
    }

    @Test
    public void testMinWithAllZero() {
        float result = NumberUtils.min(0.0f, 0.0f, 0.0f);
        assertEquals(0.0f, result);
    }

    @Test
    public void testMinWithTwoEqual() {
        float result = NumberUtils.min(2.0f, 2.0f, 1.0f);
        assertEquals(1.0f, result);
    }

    @Test
    public void testMinWithInfinity() {
        float result = NumberUtils.min(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.0f);
        assertEquals(Float.NEGATIVE_INFINITY, result);
    }

    @Test
    public void testMinWithNaN() {
        float result = NumberUtils.min(Float.NaN, 1.0f, 2.0f);
        assertEquals(Float.NaN, result);
    }
}
