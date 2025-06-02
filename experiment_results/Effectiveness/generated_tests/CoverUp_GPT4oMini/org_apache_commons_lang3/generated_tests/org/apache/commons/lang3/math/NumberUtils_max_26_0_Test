package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
import java.lang.reflect.Method;
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

public class NumberUtils_max_26_0_Test {

    @Test
    public void testMaxWithPositiveNumbers() {
        long[] numbers = { 1L, 2L, 3L, 4L, 5L };
        long result = NumberUtils.max(numbers);
        assertEquals(5L, result);
    }

    @Test
    public void testMaxWithNegativeNumbers() {
        long[] numbers = { -1L, -2L, -3L, -4L, -5L };
        long result = NumberUtils.max(numbers);
        assertEquals(-1L, result);
    }

    @Test
    public void testMaxWithMixedNumbers() {
        long[] numbers = { -1L, 0L, 1L, 2L };
        long result = NumberUtils.max(numbers);
        assertEquals(2L, result);
    }

    @Test
    public void testMaxWithSingleElement() {
        long[] numbers = { 42L };
        long result = NumberUtils.max(numbers);
        assertEquals(42L, result);
    }

    @Test
    public void testMaxWithZero() {
        long[] numbers = { 0L, 0L, 0L };
        long result = NumberUtils.max(numbers);
        assertEquals(0L, result);
    }

    @Test
    public void testMaxWithEmptyArray() {
        long[] numbers = {};
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeMax(numbers);
        });
        assertEquals("array", exception.getMessage());
    }

    @Test
    public void testMaxWithNullArray() {
        long[] numbers = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeMax(numbers);
        });
        assertEquals("array", exception.getMessage());
    }

    private long invokeMax(long[] array) {
        try {
            Method method = NumberUtils.class.getDeclaredMethod("max", long[].class);
            method.setAccessible(true);
            return (long) method.invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
