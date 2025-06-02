package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.reflect.Method;
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

public class NumberUtils_toScaledBigDecimal_60_0_Test {

    @Test
    public void testToScaledBigDecimal_ValidString() throws Exception {
        String input = "123.456";
        BigDecimal expected = new BigDecimal("123.46");
        BigDecimal result = invokeToScaledBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidStringWithTrailingZeros() throws Exception {
        String input = "123.4500";
        BigDecimal expected = new BigDecimal("123.45");
        BigDecimal result = invokeToScaledBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeString() throws Exception {
        String input = "-123.456";
        BigDecimal expected = new BigDecimal("-123.46");
        BigDecimal result = invokeToScaledBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_ZeroString() throws Exception {
        String input = "0.000";
        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal result = invokeToScaledBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToScaledBigDecimal_InvalidString() throws Exception {
        String input = "invalid";
        assertThrows(NumberFormatException.class, () -> {
            invokeToScaledBigDecimal(input);
        });
    }

    private BigDecimal invokeToScaledBigDecimal(String value) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", String.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, value);
    }
}
