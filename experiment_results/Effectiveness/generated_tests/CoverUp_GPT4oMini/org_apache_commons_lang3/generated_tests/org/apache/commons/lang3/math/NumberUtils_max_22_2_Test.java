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

class NumberUtils_max_22_2_Test {

    @Test
    void testMaxWithValidArray() {
        float[] array = { 1.0f, 2.0f, 3.0f, 4.0f };
        assertEquals(4.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxWithNegativeNumbers() {
        float[] array = { -1.0f, -2.0f, -3.0f };
        assertEquals(-1.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxWithSingleElement() {
        float[] array = { 5.0f };
        assertEquals(5.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxWithAllEqualElements() {
        float[] array = { 2.0f, 2.0f, 2.0f };
        assertEquals(2.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxWithNaN() {
        float[] array = { 1.0f, Float.NaN, 2.0f };
        assertEquals(Float.NaN, NumberUtils.max(array));
    }

    @Test
    void testMaxWithEmptyArray() {
        float[] array = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeMax(array);
        });
        assertEquals("Array cannot be empty.", exception.getMessage());
    }

    @Test
    void testMaxWithNullArray() {
        float[] array = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeMax(array);
        });
        assertEquals("array", exception.getMessage());
    }

    private float invokeMax(float[] array) {
        try {
            return (float) NumberUtils.class.getDeclaredMethod("max", float[].class).invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
