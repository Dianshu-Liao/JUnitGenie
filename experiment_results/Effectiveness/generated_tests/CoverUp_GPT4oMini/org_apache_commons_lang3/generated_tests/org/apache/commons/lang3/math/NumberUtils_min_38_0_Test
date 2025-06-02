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

class NumberUtils_min_38_0_Test {

    @Test
    void testMinWithPositiveNumbers() {
        long[] array = { 5L, 2L, 8L, 1L };
        long result = invokeMin(array);
        assertEquals(1L, result);
    }

    @Test
    void testMinWithNegativeNumbers() {
        long[] array = { -5L, -2L, -8L, -1L };
        long result = invokeMin(array);
        assertEquals(-8L, result);
    }

    @Test
    void testMinWithMixedNumbers() {
        long[] array = { 5L, -2L, 8L, -1L };
        long result = invokeMin(array);
        assertEquals(-2L, result);
    }

    @Test
    void testMinWithSingleElement() {
        long[] array = { 42L };
        long result = invokeMin(array);
        assertEquals(42L, result);
    }

    @Test
    void testMinWithZero() {
        long[] array = { 0L, 1L, -1L };
        long result = invokeMin(array);
        assertEquals(-1L, result);
    }

    @Test
    void testMinWithEmptyArray() {
        assertThrows(NullPointerException.class, () -> invokeMin((long[]) null));
    }

    @Test
    void testMinWithEmptyLongArray() {
        assertThrows(IllegalArgumentException.class, () -> invokeMin(new long[] {}));
    }

    private long invokeMin(long[] array) {
        try {
            Method method = NumberUtils.class.getDeclaredMethod("min", long[].class);
            method.setAccessible(true);
            return (long) method.invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
