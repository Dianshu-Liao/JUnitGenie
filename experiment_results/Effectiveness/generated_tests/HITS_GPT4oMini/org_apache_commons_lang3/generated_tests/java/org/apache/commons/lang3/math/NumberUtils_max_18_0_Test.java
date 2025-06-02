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

public class NumberUtils_max_18_0_Test {

    @Test
    public void testMaxWithPositiveNumbers() {
        byte[] input = { 1, 2, 3, 4, 5 };
        byte expected = 5;
        assertEquals(expected, NumberUtils.max(input));
    }

    @Test
    public void testMaxWithNegativeNumbers() {
        byte[] input = { -1, -2, -3, -4, -5 };
        byte expected = -1;
        assertEquals(expected, NumberUtils.max(input));
    }

    @Test
    public void testMaxWithMixedNumbers() {
        byte[] input = { -1, 0, 1, -2, 2 };
        byte expected = 2;
        assertEquals(expected, NumberUtils.max(input));
    }

    @Test
    public void testMaxWithSingleElement() {
        byte[] input = { 42 };
        byte expected = 42;
        assertEquals(expected, NumberUtils.max(input));
    }

    @Test
    public void testMaxWithIdenticalElements() {
        byte[] input = { 7, 7, 7, 7 };
        byte expected = 7;
        assertEquals(expected, NumberUtils.max(input));
    }

    @Test
    public void testMaxWithEmptyArray() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.max((byte[]) new byte[] {});
        });
        assertEquals("Array cannot be empty.", exception.getMessage());
    }

    @Test
    public void testMaxWithNullArray() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            NumberUtils.max((byte[]) null);
        });
        assertEquals("array", exception.getMessage());
    }
}
