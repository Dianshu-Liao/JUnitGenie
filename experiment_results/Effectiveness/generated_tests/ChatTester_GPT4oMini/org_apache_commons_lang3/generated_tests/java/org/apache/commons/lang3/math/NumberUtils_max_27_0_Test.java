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

public class NumberUtils_max_27_0_Test {

    @Test
    public void testMaxWithAllNegativeValues() {
        long result = NumberUtils.max(-5L, -10L, -3L);
        assertEquals(-3L, result);
    }

    @Test
    public void testMaxWithMixedValues() {
        long result = NumberUtils.max(-5L, 0L, 3L);
        assertEquals(3L, result);
    }

    @Test
    public void testMaxWithAllPositiveValues() {
        long result = NumberUtils.max(5L, 10L, 3L);
        assertEquals(10L, result);
    }

    @Test
    public void testMaxWithEqualValues() {
        long result = NumberUtils.max(5L, 5L, 5L);
        assertEquals(5L, result);
    }

    @Test
    public void testMaxWithZeroAndNegative() {
        long result = NumberUtils.max(0L, -1L, -2L);
        assertEquals(0L, result);
    }

    @Test
    public void testMaxWithZeroAndPositive() {
        long result = NumberUtils.max(0L, 1L, 2L);
        assertEquals(2L, result);
    }

    @Test
    public void testMaxWithOneNegativeValue() {
        long result = NumberUtils.max(1L, -1L, 0L);
        assertEquals(1L, result);
    }

    @Test
    public void testMaxWithAllSameValues() {
        long result = NumberUtils.max(7L, 7L, 7L);
        assertEquals(7L, result);
    }

    @Test
    public void testMaxWithLargeValues() {
        long result = NumberUtils.max(Long.MAX_VALUE, Long.MIN_VALUE, 0L);
        assertEquals(Long.MAX_VALUE, result);
    }

    @Test
    public void testMaxWithAllZeros() {
        long result = NumberUtils.max(0L, 0L, 0L);
        assertEquals(0L, result);
    }
}
