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

public class NumberUtils_max_25_0_Test {

    @Test
    public void testMax_WhenBIsGreaterThanAAndC() {
        int result = NumberUtils.max(1, 2, 0);
        assertEquals(2, result);
    }

    @Test
    public void testMax_WhenCIsGreaterThanAAndB() {
        int result = NumberUtils.max(1, 0, 3);
        assertEquals(3, result);
    }

    @Test
    public void testMax_WhenAIsGreatest() {
        int result = NumberUtils.max(5, 2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testMax_WhenAllAreEqual() {
        int result = NumberUtils.max(2, 2, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMax_WhenNegativeValues() {
        int result = NumberUtils.max(-1, -2, -3);
        assertEquals(-1, result);
    }

    @Test
    public void testMax_WhenMixedValues() {
        int result = NumberUtils.max(-1, 1, 0);
        assertEquals(1, result);
    }

    @Test
    public void testMax_WhenAllZeros() {
        int result = NumberUtils.max(0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testMax_WhenBAndCAreEqualAndGreaterThanA() {
        int result = NumberUtils.max(1, 2, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMax_WhenAAndCAreEqualAndGreaterThanB() {
        int result = NumberUtils.max(3, 2, 3);
        assertEquals(3, result);
    }

    @Test
    public void testMax_WhenAIsNegativeAndBAndCArePositive() {
        int result = NumberUtils.max(-5, 2, 3);
        assertEquals(3, result);
    }
}
