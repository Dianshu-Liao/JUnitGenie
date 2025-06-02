package org.apache.commons.lang3.math;

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

public class NumberUtils_min_38_0_Test {

    @Test
    public void testMin_WithPositiveNumbers() {
        long result = NumberUtils.min(5L, 2L, 8L, 3L);
        assertEquals(2L, result);
    }

    @Test
    public void testMin_WithNegativeNumbers() {
        long result = NumberUtils.min(-5L, -2L, -8L, -3L);
        assertEquals(-8L, result);
    }

    @Test
    public void testMin_WithMixedNumbers() {
        long result = NumberUtils.min(-5L, 2L, 0L, 3L);
        assertEquals(-5L, result);
    }

    @Test
    public void testMin_WithSingleElement() {
        long result = NumberUtils.min(10L);
        assertEquals(10L, result);
    }

    @Test
    public void testMin_WithZero() {
        long result = NumberUtils.min(0L, 1L, 2L);
        assertEquals(0L, result);
    }

    @Test
    public void testMin_WithEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min();
        });
        assertEquals("Array must not be empty", exception.getMessage());
    }

    @Test
    public void testMin_WithNullArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min((long[]) null);
        });
        assertEquals("Array must not be null", exception.getMessage());
    }

    // Reflection to test private method
    @Test
    public void testValidateArray() throws Exception {
        Method validateArrayMethod = NumberUtils.class.getDeclaredMethod("validateArray", long[].class);
        validateArrayMethod.setAccessible(true);
        // Assuming validateArray throws IllegalArgumentException for null or empty array
        assertThrows(IllegalArgumentException.class, () -> {
            validateArrayMethod.invoke(null, (long[]) null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validateArrayMethod.invoke(null, new long[0]);
        });
        // Valid case
        // should not throw
        validateArrayMethod.invoke(null, new long[] { 1L, 2L, 3L });
    }
}
