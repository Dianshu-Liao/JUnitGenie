package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils_toScaledBigDecimal_54_0_Test {

    @Test
    public void testToScaledBigDecimal_NullInput_ReturnsZero() {
        // Arrange
        BigDecimal input = null;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        // Assert
        assertEquals(BigDecimal.ZERO, result, "Expected BigDecimal.ZERO when input is null");
    }

    @Test
    public void testToScaledBigDecimal_ValidInput_ReturnsScaledValue() {
        // Arrange
        BigDecimal input = new BigDecimal("123.456");
        // scale to 2 decimal places
        int scale = 2;
        // expected result after rounding
        BigDecimal expected = new BigDecimal("123.46");
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        // Assert
        assertEquals(expected, result, "Expected value to be scaled correctly");
    }

    @Test
    public void testToScaledBigDecimal_NegativeInput_ReturnsScaledValue() {
        // Arrange
        BigDecimal input = new BigDecimal("-123.456");
        // scale to 2 decimal places
        int scale = 2;
        // expected result after rounding
        BigDecimal expected = new BigDecimal("-123.46");
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        // Assert
        assertEquals(expected, result, "Expected negative value to be scaled correctly");
    }

    @Test
    public void testToScaledBigDecimal_ZeroInput_ReturnsZero() {
        // Arrange
        BigDecimal input = BigDecimal.ZERO;
        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(input);
        // Assert
        assertEquals(BigDecimal.ZERO, result, "Expected BigDecimal.ZERO when input is zero");
    }
}
