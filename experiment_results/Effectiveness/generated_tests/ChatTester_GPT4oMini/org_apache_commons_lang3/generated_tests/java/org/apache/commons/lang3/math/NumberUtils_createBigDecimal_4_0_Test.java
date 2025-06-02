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
    public void testCreateBigDecimal_BlankInput() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigDecimal(" ");
        }, "A blank string is not a valid number");
    }

    @Test
    public void testCreateBigDecimal_ValidInput() {
        BigDecimal result = NumberUtils.createBigDecimal("123.45");
        assertNotNull(result, "Expected a BigDecimal for valid input");
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testCreateBigDecimal_ValidInputNegative() {
        BigDecimal result = NumberUtils.createBigDecimal("-123.45");
        assertNotNull(result, "Expected a BigDecimal for valid negative input");
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    public void testCreateBigDecimal_ValidInputZero() {
        BigDecimal result = NumberUtils.createBigDecimal("0");
        assertNotNull(result, "Expected a BigDecimal for zero input");
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testCreateBigDecimal_ValidInputInteger() {
        BigDecimal result = NumberUtils.createBigDecimal("100");
        assertNotNull(result, "Expected a BigDecimal for integer input");
        assertEquals(new BigDecimal("100"), result);
    }

    @Test
    public void testCreateBigDecimal_EmptyString() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigDecimal("");
        }, "A blank string is not a valid number");
    }
}
