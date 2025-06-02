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

public class NumberUtils_max_18_0_Test {

    @Test
    public void testMaxWithPositiveNumbers() {
        byte[] input = { 1, 2, 3, 4, 5 };
        byte expected = 5;
        byte result = invokeMax(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithNegativeNumbers() {
        byte[] input = { -1, -2, -3, -4, -5 };
        byte expected = -1;
        byte result = invokeMax(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithMixedNumbers() {
        byte[] input = { -1, 0, 1, 2 };
        byte expected = 2;
        byte result = invokeMax(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithSingleElement() {
        byte[] input = { 42 };
        byte expected = 42;
        byte result = invokeMax(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithAllEqualElements() {
        byte[] input = { 5, 5, 5, 5 };
        byte expected = 5;
        byte result = invokeMax(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> invokeMax(new byte[] {}));
    }

    private byte invokeMax(byte[] array) {
        try {
            Method method = NumberUtils.class.getDeclaredMethod("max", byte[].class);
            method.setAccessible(true);
            return (byte) method.invoke(null, (Object) array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
