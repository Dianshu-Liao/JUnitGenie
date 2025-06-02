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

public class NumberUtils_min_34_0_Test {

    @Test
    public void testMin_ValidArray() {
        float[] input = { 3.5f, 2.1f, 4.7f, 1.0f };
        float expected = 1.0f;
        float actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMin_SingleElementArray() {
        float[] input = { 5.0f };
        float expected = 5.0f;
        float actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMin_NegativeNumbers() {
        float[] input = { -1.0f, -3.5f, -2.2f };
        float expected = -3.5f;
        float actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMin_WithNaN() {
        float[] input = { 1.0f, Float.NaN, 2.0f };
        float actual = NumberUtils.min(input);
        assertTrue(Float.isNaN(actual));
    }

    @Test
    public void testMin_EmptyArray() {
        float[] input = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(input);
        });
    }

    @Test
    public void testMin_AllNaN() {
        float[] input = { Float.NaN, Float.NaN };
        float actual = NumberUtils.min(input);
        assertTrue(Float.isNaN(actual));
    }

    @Test
    public void testMin_MixedValues() {
        float[] input = { 2.0f, Float.NaN, -1.0f, 0.0f };
        float actual = NumberUtils.min(input);
        assertTrue(Float.isNaN(actual));
    }
}
