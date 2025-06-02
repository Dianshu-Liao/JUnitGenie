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

public class NumberUtils_max_28_0_Test {

    @Test
    public void testMaxWithPositiveNumbers() {
        short[] input = { 1, 2, 3, 4, 5 };
        short expected = 5;
        short result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithNegativeNumbers() {
        short[] input = { -1, -2, -3, -4, -5 };
        short expected = -1;
        short result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithMixedNumbers() {
        short[] input = { -1, 2, -3, 4, -5 };
        short expected = 4;
        short result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithSingleElement() {
        short[] input = { 42 };
        short expected = 42;
        short result = NumberUtils.max(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithEmptyArray() {
        short[] input = {};
        assertThrows(NullPointerException.class, () -> {
            invokeMaxMethod(input);
        });
    }

    @Test
    public void testMaxWithNullArray() {
        assertThrows(NullPointerException.class, () -> {
            invokeMaxMethod(null);
        });
    }

    private short invokeMaxMethod(short[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("max", short[].class);
        method.setAccessible(true);
        return (short) method.invoke(null, (Object) array);
    }
}
