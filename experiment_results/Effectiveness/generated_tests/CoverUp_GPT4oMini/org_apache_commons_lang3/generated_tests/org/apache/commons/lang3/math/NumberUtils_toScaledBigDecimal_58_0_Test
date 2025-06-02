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

public class NumberUtils_toScaledBigDecimal_58_0_Test {

    @Test
    void testToScaledBigDecimalWithPositiveFloat() {
        Float value = 123.456f;
        BigDecimal expected = BigDecimal.valueOf(123.46).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimalWithNegativeFloat() {
        Float value = -123.456f;
        BigDecimal expected = BigDecimal.valueOf(-123.46).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimalWithZero() {
        Float value = 0.0f;
        BigDecimal expected = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimalWithNull() {
        Float value = null;
        BigDecimal expected = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    private BigDecimal invokeToScaledBigDecimal(Float value) {
        try {
            return (BigDecimal) NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", Float.class).invoke(null, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
