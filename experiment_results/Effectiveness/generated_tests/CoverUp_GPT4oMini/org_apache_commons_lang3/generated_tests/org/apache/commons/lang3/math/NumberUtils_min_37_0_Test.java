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

public class NumberUtils_min_37_0_Test {

    @Test
    public void testMinWithAllPositiveNumbers() {
        int result = NumberUtils.min(5, 10, 15);
        assertEquals(5, result);
    }

    @Test
    public void testMinWithNegativeAndPositiveNumbers() {
        int result = NumberUtils.min(-5, 10, 15);
        assertEquals(-5, result);
    }

    @Test
    public void testMinWithAllNegativeNumbers() {
        int result = NumberUtils.min(-5, -10, -15);
        assertEquals(-15, result);
    }

    @Test
    public void testMinWithDuplicates() {
        int result = NumberUtils.min(5, 5, 10);
        assertEquals(5, result);
    }

    @Test
    public void testMinWithMixedNumbers() {
        int result = NumberUtils.min(0, -1, 1);
        assertEquals(-1, result);
    }

    @Test
    public void testMinWithZeros() {
        int result = NumberUtils.min(0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testMinWithTwoEqualAndOneDifferent() {
        int result = NumberUtils.min(3, 3, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMinWithOneNegativeAndTwoPositive() {
        int result = NumberUtils.min(1, 2, -3);
        assertEquals(-3, result);
    }
}
