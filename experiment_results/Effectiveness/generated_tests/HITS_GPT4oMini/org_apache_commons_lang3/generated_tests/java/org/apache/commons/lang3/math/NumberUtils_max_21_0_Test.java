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
    public void testMaxWithPositiveNumbers() {
        double result = NumberUtils.max(1.0, 2.0, 3.0);
        assertEquals(3.0, result, "The max of 1.0, 2.0, and 3.0 should be 3.0");
    }

    @Test
    public void testMaxWithNegativeNumbers() {
        double result = NumberUtils.max(-1.0, -2.0, -3.0);
        assertEquals(-1.0, result, "The max of -1.0, -2.0, and -3.0 should be -1.0");
    }

    @Test
    public void testMaxWithMixedNumbers() {
        double result = NumberUtils.max(-1.0, 0.0, 1.0);
        assertEquals(1.0, result, "The max of -1.0, 0.0, and 1.0 should be 1.0");
    }

    @Test
    public void testMaxWithAllEqualNumbers() {
        double result = NumberUtils.max(2.0, 2.0, 2.0);
        assertEquals(2.0, result, "The max of 2.0, 2.0, and 2.0 should be 2.0");
    }

    @Test
    public void testMaxWithZeroAndNegativeNumbers() {
        double result = NumberUtils.max(0.0, -1.0, -2.0);
        assertEquals(0.0, result, "The max of 0.0, -1.0, and -2.0 should be 0.0");
    }

    @Test
    public void testMaxWithLargeNumbers() {
        double result = NumberUtils.max(1e10, 1e11, 1e12);
        assertEquals(1e12, result, "The max of 1e10, 1e11, and 1e12 should be 1e12");
    }

    @Test
    public void testMaxWithNaNValues() {
        double result = NumberUtils.max(Double.NaN, 1.0, 2.0);
        assertEquals(2.0, result, "The max should ignore NaN and return 2.0");
    }

    @Test
    public void testMaxWithInfinityValues() {
        double result = NumberUtils.max(Double.NEGATIVE_INFINITY, 1.0, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, "The max of -∞, 1.0, and +∞ should be +∞");
    }
}
