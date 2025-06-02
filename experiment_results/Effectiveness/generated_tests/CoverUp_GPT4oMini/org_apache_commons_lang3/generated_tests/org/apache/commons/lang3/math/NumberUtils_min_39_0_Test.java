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

public class NumberUtils_min_39_0_Test {

    @Test
    public void testMin_withAllPositiveNumbers() {
        long result = NumberUtils.min(5L, 10L, 15L);
        assertEquals(5L, result);
    }

    @Test
    public void testMin_withOneNegativeNumber() {
        long result = NumberUtils.min(5L, -10L, 15L);
        assertEquals(-10L, result);
    }

    @Test
    public void testMin_withAllNegativeNumbers() {
        long result = NumberUtils.min(-5L, -10L, -15L);
        assertEquals(-15L, result);
    }

    @Test
    public void testMin_withZeroAndPositiveNumbers() {
        long result = NumberUtils.min(0L, 10L, 15L);
        assertEquals(0L, result);
    }

    @Test
    public void testMin_withZeroAndNegativeNumbers() {
        long result = NumberUtils.min(0L, -10L, -15L);
        assertEquals(-15L, result);
    }

    @Test
    public void testMin_withEqualNumbers() {
        long result = NumberUtils.min(10L, 10L, 10L);
        assertEquals(10L, result);
    }

    @Test
    public void testMin_withTwoEqualAndOneDifferent() {
        long result = NumberUtils.min(10L, 10L, 5L);
        assertEquals(5L, result);
    }

    @Test
    public void testMin_withTwoNegativeAndOnePositive() {
        long result = NumberUtils.min(-5L, -10L, 5L);
        assertEquals(-10L, result);
    }

    @Test
    public void testMin_withTwoPositiveAndOneNegative() {
        long result = NumberUtils.min(5L, 10L, -1L);
        assertEquals(-1L, result);
    }
}
