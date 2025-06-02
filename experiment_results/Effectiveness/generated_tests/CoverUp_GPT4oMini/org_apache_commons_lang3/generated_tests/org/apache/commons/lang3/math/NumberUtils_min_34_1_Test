package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
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

class NumberUtils_min_34_1_Test {

    @Test
    void testMinWithValidFloats() {
        float[] input = { 3.5f, 2.1f, 4.0f, 1.0f };
        float result = NumberUtils.min(input);
        assertEquals(1.0f, result);
    }

    @Test
    void testMinWithNegativeFloats() {
        float[] input = { -1.5f, -2.3f, -0.4f };
        float result = NumberUtils.min(input);
        assertEquals(-2.3f, result);
    }

    @Test
    void testMinWithNaN() {
        float[] input = { 1.0f, Float.NaN, 2.0f };
        float result = NumberUtils.min(input);
        assertTrue(Float.isNaN(result));
    }

    @Test
    void testMinWithSingleElement() {
        float[] input = { 5.0f };
        float result = NumberUtils.min(input);
        assertEquals(5.0f, result);
    }

    @Test
    void testMinWithEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(new float[] {});
        });
        assertEquals("Array cannot be empty.", exception.getMessage());
    }

    @Test
    void testMinWithAllSameValues() {
        float[] input = { 2.0f, 2.0f, 2.0f };
        float result = NumberUtils.min(input);
        assertEquals(2.0f, result);
    }

    @Test
    void testMinWithZero() {
        float[] input = { 0.0f, 1.0f, -1.0f };
        float result = NumberUtils.min(input);
        assertEquals(-1.0f, result);
    }
}
