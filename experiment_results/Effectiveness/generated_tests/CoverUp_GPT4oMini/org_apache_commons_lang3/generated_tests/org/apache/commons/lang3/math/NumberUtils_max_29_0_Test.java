package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
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

public class NumberUtils_max_29_0_Test {

    @Test
    public void testMaxWithAllNegativeNumbers() {
        short result = invokeMax((short) -5, (short) -10, (short) -3);
        assertEquals((short) -3, result);
    }

    @Test
    public void testMaxWithAllPositiveNumbers() {
        short result = invokeMax((short) 5, (short) 10, (short) 3);
        assertEquals((short) 10, result);
    }

    @Test
    public void testMaxWithMixedNumbers() {
        short result = invokeMax((short) -5, (short) 10, (short) 3);
        assertEquals((short) 10, result);
    }

    @Test
    public void testMaxWithTwoEqualNumbers() {
        short result = invokeMax((short) 5, (short) 5, (short) 3);
        assertEquals((short) 5, result);
    }

    @Test
    public void testMaxWithZero() {
        short result = invokeMax((short) 0, (short) -10, (short) 10);
        assertEquals((short) 10, result);
    }

    private short invokeMax(short a, short b, short c) {
        try {
            return (short) NumberUtils.class.getMethod("max", short.class, short.class, short.class).invoke(null, a, b, c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
