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

public class NumberUtils_min_30_0_Test {

    @Test
    public void testMinWithPositiveNumbers() {
        byte[] input = { 3, 5, 1, 7, 2 };
        byte expected = 1;
        byte actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithNegativeNumbers() {
        byte[] input = { -3, -5, -1, -7, -2 };
        byte expected = -7;
        byte actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithMixedNumbers() {
        byte[] input = { 3, -5, 1, -7, 2 };
        byte expected = -7;
        byte actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithSingleElement() {
        byte[] input = { 5 };
        byte expected = 5;
        byte actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithAllSameElements() {
        byte[] input = { 2, 2, 2, 2 };
        byte expected = 2;
        byte actual = NumberUtils.min(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinWithEmptyArray() {
        byte[] input = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(input);
        });
        assertEquals("Array cannot be empty.", exception.getMessage());
    }

    @Test
    public void testMinWithNullArray() {
        byte[] input = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            NumberUtils.min(input);
        });
        assertEquals("array", exception.getMessage());
    }
}
