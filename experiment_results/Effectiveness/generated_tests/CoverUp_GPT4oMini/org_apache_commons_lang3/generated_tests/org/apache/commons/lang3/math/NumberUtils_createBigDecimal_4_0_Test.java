package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
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

class NumberUtils_createBigDecimal_4_0_Test {

    @Test
    void testCreateBigDecimalWithNull() {
        assertNull(NumberUtils.createBigDecimal(null));
    }

    @Test
    void testCreateBigDecimalWithEmptyString() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigDecimal("");
        });
        assertEquals("A blank string is not a valid number", exception.getMessage());
    }

    @Test
    void testCreateBigDecimalWithBlankString() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigDecimal("   ");
        });
        assertEquals("A blank string is not a valid number", exception.getMessage());
    }

    @Test
    void testCreateBigDecimalWithValidString() {
        BigDecimal result = NumberUtils.createBigDecimal("123.45");
        assertNotNull(result);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    void testCreateBigDecimalWithNegativeString() {
        BigDecimal result = NumberUtils.createBigDecimal("-123.45");
        assertNotNull(result);
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    void testCreateBigDecimalWithZeroString() {
        BigDecimal result = NumberUtils.createBigDecimal("0");
        assertNotNull(result);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testCreateBigDecimalWithLargeNumberString() {
        BigDecimal result = NumberUtils.createBigDecimal("12345678901234567890.123456789");
        assertNotNull(result);
        assertEquals(new BigDecimal("12345678901234567890.123456789"), result);
    }
}
