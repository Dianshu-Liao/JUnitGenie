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

public class NumberUtils_min_31_0_Test {

    @Test
    public void testMin_WithPositiveValues() {
        byte result = NumberUtils.min((byte) 5, (byte) 3, (byte) 4);
        assertEquals(3, result);
    }

    @Test
    public void testMin_WithNegativeValues() {
        byte result = NumberUtils.min((byte) -5, (byte) -3, (byte) -4);
        assertEquals(-5, result);
    }

    @Test
    public void testMin_WithMixedValues() {
        byte result = NumberUtils.min((byte) -1, (byte) 0, (byte) 1);
        assertEquals(-1, result);
    }

    @Test
    public void testMin_WithAllEqualValues() {
        byte result = NumberUtils.min((byte) 2, (byte) 2, (byte) 2);
        assertEquals(2, result);
    }

    @Test
    public void testMin_WithZeroValues() {
        byte result = NumberUtils.min((byte) 0, (byte) 0, (byte) 0);
        assertEquals(0, result);
    }

    @Test
    public void testMin_WithOneNegativeAndTwoPositive() {
        byte result = NumberUtils.min((byte) 1, (byte) -1, (byte) 2);
        assertEquals(-1, result);
    }

    @Test
    public void testMin_WithOnePositiveAndTwoNegative() {
        byte result = NumberUtils.min((byte) -1, (byte) -2, (byte) 1);
        assertEquals(-2, result);
    }
}
