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

public class NumberUtils_max_22_0_Test {

    @Test
    public void testMaxWithValidArray() {
        float[] input = { 1.0f, 2.0f, 3.0f, 2.5f };
        float result = NumberUtils.max(input);
        assertEquals(3.0f, result);
    }

    @Test
    public void testMaxWithSingleElementArray() {
        float[] input = { 5.0f };
        float result = NumberUtils.max(input);
        assertEquals(5.0f, result);
    }

    @Test
    public void testMaxWithAllNegativeNumbers() {
        float[] input = { -1.0f, -2.0f, -3.0f };
        float result = NumberUtils.max(input);
        assertEquals(-1.0f, result);
    }

    @Test
    public void testMaxWithNaNElement() {
        float[] input = { 1.0f, Float.NaN, 2.0f };
        float result = NumberUtils.max(input);
        assertTrue(Float.isNaN(result));
    }

    @Test
    public void testMaxWithEmptyArray() {
        float[] input = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.max(input);
        });
        assertEquals("Array cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testMaxWithAllZeros() {
        float[] input = { 0.0f, 0.0f, 0.0f };
        float result = NumberUtils.max(input);
        assertEquals(0.0f, result);
    }

    @Test
    public void testMaxWithNegativeAndPositiveNumbers() {
        float[] input = { -1.0f, 0.0f, 1.0f };
        float result = NumberUtils.max(input);
        assertEquals(1.0f, result);
    }

    @Test
    public void testMaxWithLargeNumbers() {
        float[] input = { Float.MAX_VALUE, Float.MAX_VALUE - 1, Float.MIN_VALUE };
        float result = NumberUtils.max(input);
        assertEquals(Float.MAX_VALUE, result);
    }

    @Test
    public void testMaxWithMixedNaN() {
        float[] input = { Float.NaN, Float.NaN };
        float result = NumberUtils.max(input);
        assertTrue(Float.isNaN(result));
    }
}
