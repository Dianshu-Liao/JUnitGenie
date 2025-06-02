package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
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

public class NumberUtils_toScaledBigDecimal_61_0_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((String) null, 2, RoundingMode.HALF_EVEN);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("123.456", 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("123.46"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithNegativeScale() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("123.456", -1, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("120"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithZeroScale() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("123.456", 0, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("123"), result);
    }

    @Test
    public void testToScaledBigDecimal_EmptyString() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.toScaledBigDecimal("", 2, RoundingMode.HALF_UP);
        });
    }

    @Test
    public void testToScaledBigDecimal_WhitespaceString() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.toScaledBigDecimal("   ", 2, RoundingMode.HALF_UP);
        });
    }

    @Test
    public void testToScaledBigDecimal_NullRoundingMode() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("123.456", 2, null);
        assertEquals(new BigDecimal("123.46"), result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("-123.456", 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("-123.46"), result);
    }
}
