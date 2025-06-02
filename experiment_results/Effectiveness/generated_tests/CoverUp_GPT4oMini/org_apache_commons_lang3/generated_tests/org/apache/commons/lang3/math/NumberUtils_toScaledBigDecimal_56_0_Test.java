package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils_toScaledBigDecimal_56_0_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        BigDecimal result = invokeToScaledBigDecimal(null);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_PositiveValue() {
        Double value = 123.456;
        // Scaled to 2 decimal places
        BigDecimal expected = new BigDecimal("123.46");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() {
        Double value = -123.456;
        // Scaled to 2 decimal places
        BigDecimal expected = new BigDecimal("-123.46");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_ZeroValue() {
        Double value = 0.0;
        // Scaled to 2 decimal places
        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_ExactValue() {
        Double value = 123.00;
        // Scaled to 2 decimal places
        BigDecimal expected = new BigDecimal("123.00");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_SpecialCases() {
        Double value = 123.456789;
        // Scaled to 2 decimal places
        BigDecimal expected = new BigDecimal("123.46");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeExactValue() {
        Double value = -123.00;
        // Scaled to 2 decimal places
        BigDecimal expected = new BigDecimal("-123.00");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    private BigDecimal invokeToScaledBigDecimal(Double value) {
        try {
            Method method = NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", Double.class);
            method.setAccessible(true);
            return (BigDecimal) method.invoke(null, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
