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

public class NumberUtils_max_19_0_Test {

    @Test
    public void testMaxWithAllNegativeValues() throws Exception {
        byte result = invokeMax((byte) -5, (byte) -10, (byte) -3);
        assertEquals(-3, result);
    }

    @Test
    public void testMaxWithAllPositiveValues() throws Exception {
        byte result = invokeMax((byte) 5, (byte) 10, (byte) 3);
        assertEquals(10, result);
    }

    @Test
    public void testMaxWithMixedValues() throws Exception {
        byte result = invokeMax((byte) -5, (byte) 10, (byte) 3);
        assertEquals(10, result);
    }

    @Test
    public void testMaxWithSameValues() throws Exception {
        byte result = invokeMax((byte) 5, (byte) 5, (byte) 5);
        assertEquals(5, result);
    }

    @Test
    public void testMaxWithOneNegativeAndTwoPositive() throws Exception {
        byte result = invokeMax((byte) -1, (byte) 2, (byte) 1);
        assertEquals(2, result);
    }

    private byte invokeMax(byte a, byte b, byte c) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("max", byte.class, byte.class, byte.class);
        method.setAccessible(true);
        return (byte) method.invoke(null, a, b, c);
    }
}
