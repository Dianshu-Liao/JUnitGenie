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

public class NumberUtils_min_30_1_Test {

    @Test
    public void testMinWithPositiveBytes() {
        byte[] input = { 1, 2, 3, 4, 5 };
        byte result = NumberUtils.min(input);
        assertEquals(1, result);
    }

    @Test
    public void testMinWithNegativeBytes() {
        byte[] input = { -1, -2, -3, -4, -5 };
        byte result = NumberUtils.min(input);
        assertEquals(-5, result);
    }

    @Test
    public void testMinWithMixedBytes() {
        byte[] input = { 1, -1, 0 };
        byte result = NumberUtils.min(input);
        assertEquals(-1, result);
    }

    @Test
    public void testMinWithSingleElement() {
        byte[] input = { 42 };
        byte result = NumberUtils.min(input);
        assertEquals(42, result);
    }

    @Test
    public void testMinWithEmptyArray() {
        byte[] input = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeMin(input);
        });
        assertEquals("Array cannot be empty.", exception.getMessage());
    }

    @Test
    public void testMinWithNullArray() {
        byte[] input = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeMin(input);
        });
        assertEquals("array", exception.getMessage());
    }

    private byte invokeMin(byte[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("min", byte[].class);
        method.setAccessible(true);
        return (byte) method.invoke(null, (Object) array);
    }
}
