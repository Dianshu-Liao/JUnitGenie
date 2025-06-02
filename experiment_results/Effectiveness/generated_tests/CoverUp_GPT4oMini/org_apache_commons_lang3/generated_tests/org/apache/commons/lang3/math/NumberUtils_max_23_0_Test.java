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

public class NumberUtils_max_23_0_Test {

    @Test
    public void testMaxWithPositiveNumbers() {
        float result = invokeMax(1.0f, 2.0f, 3.0f);
        assertEquals(3.0f, result);
    }

    @Test
    public void testMaxWithNegativeNumbers() {
        float result = invokeMax(-1.0f, -2.0f, -3.0f);
        assertEquals(-1.0f, result);
    }

    @Test
    public void testMaxWithMixedNumbers() {
        float result = invokeMax(-1.0f, 0.0f, 1.0f);
        assertEquals(1.0f, result);
    }

    @Test
    public void testMaxWithZeros() {
        float result = invokeMax(0.0f, 0.0f, 0.0f);
        assertEquals(0.0f, result);
    }

    @Test
    public void testMaxWithInfinity() {
        float result = invokeMax(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f);
        assertEquals(Float.POSITIVE_INFINITY, result);
    }

    @Test
    public void testMaxWithNaN() {
        float result = invokeMax(Float.NaN, 1.0f, 2.0f);
        assertEquals(2.0f, result);
    }

    private float invokeMax(float a, float b, float c) {
        try {
            return (float) NumberUtils.class.getDeclaredMethod("max", float.class, float.class, float.class).invoke(null, a, b, c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
