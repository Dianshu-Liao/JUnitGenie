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

public class NumberUtils_min_36_0_Test {

    @Test
    public void testMinWithPositiveNumbers() throws Exception {
        int[] input = { 3, 5, 1, 4 };
        int expected = 1;
        int actual = invokeMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithNegativeNumbers() throws Exception {
        int[] input = { -3, -5, -1, -4 };
        int expected = -5;
        int actual = invokeMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithMixedNumbers() throws Exception {
        int[] input = { 3, -1, 2, -4 };
        int expected = -4;
        int actual = invokeMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithSingleElement() throws Exception {
        int[] input = { 42 };
        int expected = 42;
        int actual = invokeMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithZero() throws Exception {
        int[] input = { 0, 1, 2 };
        int expected = 0;
        int actual = invokeMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithEmptyArray() {
        int[] input = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeMin(input);
        });
        assertEquals("Array cannot be empty.", exception.getMessage());
    }

    @Test
    public void testMinWithNullArray() {
        int[] input = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeMin(input);
        });
        assertEquals("array", exception.getMessage());
    }

    private int invokeMin(int[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("min", int[].class);
        method.setAccessible(true);
        return (int) method.invoke(null, (Object) array);
    }
}
