package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

public class NumberUtils_toScaledBigDecimal_54_3_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((BigDecimal) null);
        assertSame(BigDecimal.ZERO, result, "Expected BigDecimal.ZERO when input is null");
    }

    @Test
    public void testToScaledBigDecimal_ZeroValue() {
        BigDecimal input = BigDecimal.ZERO;
        BigDecimal expected = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        assertEquals(expected, result, "Expected scaled BigDecimal for zero input");
    }

    @Test
    public void testToScaledBigDecimal_PositiveValue() {
        BigDecimal input = new BigDecimal("123.456");
        // Rounded to 2 decimal places
        BigDecimal expected = new BigDecimal("123.46");
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        assertEquals(expected, result, "Expected scaled BigDecimal for positive input");
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() {
        BigDecimal input = new BigDecimal("-123.456");
        // Rounded to 2 decimal places
        BigDecimal expected = new BigDecimal("-123.46");
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        assertEquals(expected, result, "Expected scaled BigDecimal for negative input");
    }

    @Test
    public void testToScaledBigDecimal_PositiveValueWithExactScale() {
        BigDecimal input = new BigDecimal("123.45");
        // No rounding needed
        BigDecimal expected = new BigDecimal("123.45");
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        assertEquals(expected, result, "Expected exact scaled BigDecimal for input with exact scale");
    }

    @Test
    public void testToScaledBigDecimal_NegativeValueWithExactScale() {
        BigDecimal input = new BigDecimal("-123.45");
        // No rounding needed
        BigDecimal expected = new BigDecimal("-123.45");
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        assertEquals(expected, result, "Expected exact scaled BigDecimal for negative input with exact scale");
    }
}
