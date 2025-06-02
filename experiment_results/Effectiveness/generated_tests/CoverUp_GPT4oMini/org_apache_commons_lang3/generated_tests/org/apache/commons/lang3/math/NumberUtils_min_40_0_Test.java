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

class NumberUtils_min_40_0_Test {

    @Test
    void testMinWithPositiveNumbers() throws Exception {
        short[] array = { 5, 2, 8, 3 };
        short result = invokeMin(array);
        assertEquals(2, result);
    }

    @Test
    void testMinWithNegativeNumbers() throws Exception {
        short[] array = { -5, -2, -8, -3 };
        short result = invokeMin(array);
        assertEquals(-8, result);
    }

    @Test
    void testMinWithMixedNumbers() throws Exception {
        short[] array = { 5, -2, 8, -3 };
        short result = invokeMin(array);
        assertEquals(-3, result);
    }

    @Test
    void testMinWithSingleElement() throws Exception {
        short[] array = { 5 };
        short result = invokeMin(array);
        assertEquals(5, result);
    }

    @Test
    void testMinWithZero() throws Exception {
        short[] array = { 0, 1, -1 };
        short result = invokeMin(array);
        assertEquals(-1, result);
    }

    @Test
    void testMinWithEmptyArray() {
        assertThrows(NullPointerException.class, () -> {
            invokeMin(null);
        });
    }

    @Test
    void testMinWithNonEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokeMin(new short[] {});
        });
    }

    private short invokeMin(short[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("min", short[].class);
        method.setAccessible(true);
        return (short) method.invoke(null, (Object) array);
    }
}
