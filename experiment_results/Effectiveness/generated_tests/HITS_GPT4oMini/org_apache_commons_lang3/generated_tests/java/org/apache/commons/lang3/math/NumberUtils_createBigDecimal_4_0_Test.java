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

public class NumberUtils_createBigDecimal_4_0_Test {

    @Test
    public void testCreateBigDecimal_NullInput() {
        BigDecimal result = NumberUtils.createBigDecimal(null);
        assertNull(result, "Expected null for null input");
    }

    @Test
    public void testCreateBigDecimal_EmptyString() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigDecimal("");
        });
        assertEquals("A blank string is not a valid number", exception.getMessage());
    }

    @Test
    public void testCreateBigDecimal_BlankString() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigDecimal("   ");
        });
        assertEquals("A blank string is not a valid number", exception.getMessage());
    }

    @Test
    public void testCreateBigDecimal_ValidIntegerString() {
        BigDecimal result = NumberUtils.createBigDecimal("123");
        assertEquals(new BigDecimal("123"), result, "Expected BigDecimal value to be 123");
    }

    @Test
    public void testCreateBigDecimal_ValidNegativeIntegerString() {
        BigDecimal result = NumberUtils.createBigDecimal("-123");
        assertEquals(new BigDecimal("-123"), result, "Expected BigDecimal value to be -123");
    }

    @Test
    public void testCreateBigDecimal_ValidDecimalString() {
        BigDecimal result = NumberUtils.createBigDecimal("123.45");
        assertEquals(new BigDecimal("123.45"), result, "Expected BigDecimal value to be 123.45");
    }

    @Test
    public void testCreateBigDecimal_ValidNegativeDecimalString() {
        BigDecimal result = NumberUtils.createBigDecimal("-123.45");
        assertEquals(new BigDecimal("-123.45"), result, "Expected BigDecimal value to be -123.45");
    }

    @Test
    public void testCreateBigDecimal_ValidScientificNotationString() {
        BigDecimal result = NumberUtils.createBigDecimal("1.23E2");
        assertEquals(new BigDecimal("123.00"), result, "Expected BigDecimal value to be 123.00");
    }

    @Test
    public void testCreateBigDecimal_ValidNegativeScientificNotationString() {
        BigDecimal result = NumberUtils.createBigDecimal("-1.23E2");
        assertEquals(new BigDecimal("-123.00"), result, "Expected BigDecimal value to be -123.00");
    }
}
