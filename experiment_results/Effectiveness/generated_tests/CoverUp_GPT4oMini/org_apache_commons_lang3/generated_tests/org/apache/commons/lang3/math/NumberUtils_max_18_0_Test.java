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

class NumberUtils_max_18_0_Test {

    @Test
    void testMaxWithPositiveValues() {
        byte[] input = { 1, 2, 3, 4, 5 };
        byte expected = 5;
        byte result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    void testMaxWithNegativeValues() {
        byte[] input = { -1, -2, -3, -4, -5 };
        byte expected = -1;
        byte result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    void testMaxWithMixedValues() {
        byte[] input = { -1, 0, 1, 2, -2 };
        byte expected = 2;
        byte result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    void testMaxWithSingleValue() {
        byte[] input = { 42 };
        byte expected = 42;
        byte result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    void testMaxWithEmptyArray() {
        byte[] input = {};
        assertThrows(NullPointerException.class, () -> {
            invokeMaxMethod(input);
        });
    }

    @Test
    void testMaxWithNullArray() {
        byte[] input = null;
        assertThrows(NullPointerException.class, () -> {
            invokeMaxMethod(input);
        });
    }

    private byte invokeMaxMethod(byte[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("max", byte[].class);
        method.setAccessible(true);
        return (byte) method.invoke(null, (Object) array);
    }
}
