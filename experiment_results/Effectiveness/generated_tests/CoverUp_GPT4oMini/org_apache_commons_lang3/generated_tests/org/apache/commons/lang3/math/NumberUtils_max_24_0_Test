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

class NumberUtils_max_24_0_Test {

    @Test
    void testMaxWithPositiveNumbers() {
        int[] input = { 1, 2, 3, 4, 5 };
        int result = NumberUtils.max(input);
        assertEquals(5, result);
    }

    @Test
    void testMaxWithNegativeNumbers() {
        int[] input = { -1, -2, -3, -4, -5 };
        int result = NumberUtils.max(input);
        assertEquals(-1, result);
    }

    @Test
    void testMaxWithMixedNumbers() {
        int[] input = { -1, 0, 1, 2, -2 };
        int result = NumberUtils.max(input);
        assertEquals(2, result);
    }

    @Test
    void testMaxWithSingleElement() {
        int[] input = { 42 };
        int result = NumberUtils.max(input);
        assertEquals(42, result);
    }

    @Test
    void testMaxWithTwoElements() {
        int[] input = { 1, 2 };
        int result = NumberUtils.max(input);
        assertEquals(2, result);
    }

    @Test
    void testMaxWithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokeMaxMethod(new int[] {});
        });
    }

    @Test
    void testMaxWithNullArray() {
        assertThrows(NullPointerException.class, () -> {
            invokeMaxMethod(null);
        });
    }

    private int invokeMaxMethod(int[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("max", int[].class);
        method.setAccessible(true);
        return (int) method.invoke(null, (Object) array);
    }
}
