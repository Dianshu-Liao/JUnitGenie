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

public class NumberUtils_toScaledBigDecimal_59_0_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((Float) null, 2, RoundingMode.HALF_UP);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal(1.2345f, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_ZeroValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal(0.0f, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal(-1.5678f, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("-1.57"), result);
    }

    @Test
    public void testToScaledBigDecimal_ScaleNegative() {
        BigDecimal result = NumberUtils.toScaledBigDecimal(1.2345f, -1, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("1.2345"), result);
    }

    @Test
    public void testToScaledBigDecimal_ScaleZero() {
        BigDecimal result = NumberUtils.toScaledBigDecimal(2.5678f, 0, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("3"), result);
    }

    @Test
    public void testToScaledBigDecimal_InvalidRoundingMode() {
        assertThrows(NullPointerException.class, () -> {
            NumberUtils.toScaledBigDecimal(1.2345f, 2, null);
        });
    }
}
