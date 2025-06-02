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

public class NumberUtils_max_25_0_Test {

    @Test
    public void testMaxWithFirstGreater() {
        int result = NumberUtils.max(5, 3, 2);
        assertEquals(5, result);
    }

    @Test
    public void testMaxWithSecondGreater() {
        int result = NumberUtils.max(3, 5, 2);
        assertEquals(5, result);
    }

    @Test
    public void testMaxWithThirdGreater() {
        int result = NumberUtils.max(2, 3, 5);
        assertEquals(5, result);
    }

    @Test
    public void testMaxWithAllEqual() {
        int result = NumberUtils.max(2, 2, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMaxWithNegativeValues() {
        int result = NumberUtils.max(-1, -2, -3);
        assertEquals(-1, result);
    }

    @Test
    public void testMaxWithMixedValues() {
        int result = NumberUtils.max(-1, 0, 1);
        assertEquals(1, result);
    }

    @Test
    public void testMaxWithZeroValues() {
        int result = NumberUtils.max(0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testMaxWithIntegerMaxValues() {
        int result = NumberUtils.max(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2);
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testMaxWithIntegerMinValues() {
        int result = NumberUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2);
        assertEquals(Integer.MIN_VALUE + 2, result);
    }

    @Test
    public void testMaxWithInvalidArguments() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Assuming we want to test an invalid state, we can invoke a private method
            Method method = NumberUtils.class.getDeclaredMethod("max", int.class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(null, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        });
    }
}
