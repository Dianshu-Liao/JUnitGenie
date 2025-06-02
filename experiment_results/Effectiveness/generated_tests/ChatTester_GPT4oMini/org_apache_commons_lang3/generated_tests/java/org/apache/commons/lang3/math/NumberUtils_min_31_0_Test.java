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
    public void testMin_WithAllPositiveValues() {
        byte result = NumberUtils.min((byte) 5, (byte) 3, (byte) 4);
        assertEquals((byte) 3, result);
    }

    @Test
    public void testMin_WithNegativeAndPositiveValues() {
        byte result = NumberUtils.min((byte) 5, (byte) -3, (byte) 4);
        assertEquals((byte) -3, result);
    }

    @Test
    public void testMin_WithAllNegativeValues() {
        byte result = NumberUtils.min((byte) -1, (byte) -5, (byte) -3);
        assertEquals((byte) -5, result);
    }

    @Test
    public void testMin_WithDuplicateValues() {
        byte result = NumberUtils.min((byte) 2, (byte) 2, (byte) 2);
        assertEquals((byte) 2, result);
    }

    @Test
    public void testMin_WithMixedValues() {
        byte result = NumberUtils.min((byte) 0, (byte) 1, (byte) -1);
        assertEquals((byte) -1, result);
    }

    @Test
    public void testMin_WithZeroAndNegative() {
        byte result = NumberUtils.min((byte) 0, (byte) -1, (byte) -2);
        assertEquals((byte) -2, result);
    }

    @Test
    public void testMin_WithAllZeros() {
        byte result = NumberUtils.min((byte) 0, (byte) 0, (byte) 0);
        assertEquals((byte) 0, result);
    }

    @Test
    public void testMin_WithNegativeAndZero() {
        byte result = NumberUtils.min((byte) -1, (byte) 0, (byte) -2);
        assertEquals((byte) -2, result);
    }
}
