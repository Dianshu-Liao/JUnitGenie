package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
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
        BigDecimal result = NumberUtils.toScaledBigDecimal((String) null, 2, RoundingMode.HALF_UP);
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
    public void testToScaledBigDecimal_InvalidNumber() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtils.toScaledBigDecimal("invalid", 2, RoundingMode.HALF_UP);
        });
        assertEquals("For input string: \"invalid\"", exception.getMessage());
    }

    @Test
    public void testToScaledBigDecimal_ZeroScale() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("123.456", 0, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("123"), result);
    }

    @Test
    public void testToScaledBigDecimal_ExactValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal("123.00", 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("123.00"), result);
    }

    private BigDecimal invokeCreateBigDecimal(String value) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("createBigDecimal", String.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, value);
    }
}
