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

class NumberUtils_toScaledBigDecimal_58_0_Test {

    @Test
    void testToScaledBigDecimal_NullValue() {
        Float value = null;
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertNull(result, "Expected null for null input");
    }

    @Test
    void testToScaledBigDecimal_ZeroValue() {
        Float value = 0.0f;
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN), result);
    }

    @Test
    void testToScaledBigDecimal_PositiveValue() {
        Float value = 1.2345f;
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(new BigDecimal("1.23").setScale(2, RoundingMode.HALF_EVEN), result);
    }

    @Test
    void testToScaledBigDecimal_NegativeValue() {
        Float value = -1.2345f;
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(new BigDecimal("-1.23").setScale(2, RoundingMode.HALF_EVEN), result);
    }

    @Test
    void testToScaledBigDecimal_ExactScale() {
        Float value = 1.2000f;
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(new BigDecimal("1.20").setScale(2, RoundingMode.HALF_EVEN), result);
    }
}
