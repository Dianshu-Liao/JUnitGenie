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

public class NumberUtils_toScaledBigDecimal_55_3_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        // Arrange
        BigDecimal value = null;
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        // Assert
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValue() {
        // Arrange
        BigDecimal value = new BigDecimal("1.2345");
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        // Assert
        assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithNullRoundingMode() {
        // Arrange
        BigDecimal value = new BigDecimal("1.2345");
        int scale = 3;
        RoundingMode roundingMode = null;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        // Assert
        assertEquals(new BigDecimal("1.235"), result);
    }

    @Test
    public void testToScaledBigDecimal_ZeroValue() {
        // Arrange
        BigDecimal value = BigDecimal.ZERO;
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        // Assert
        assertEquals(BigDecimal.ZERO.setScale(scale, roundingMode), result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() {
        // Arrange
        BigDecimal value = new BigDecimal("-1.5678");
        int scale = 3;
        RoundingMode roundingMode = RoundingMode.HALF_DOWN;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        // Assert
        assertEquals(new BigDecimal("-1.568"), result);
    }
}
