package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
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

public class NumberUtils_toScaledBigDecimal_54_0_Test {

    @Test
    public void testToScaledBigDecimalWithNull() throws Exception {
        BigDecimal result = invokeToScaledBigDecimal(null);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimalWithValidValue() throws Exception {
        BigDecimal value = new BigDecimal("123.456");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(new BigDecimal("123.46"), result);
    }

    @Test
    public void testToScaledBigDecimalWithNegativeValue() throws Exception {
        BigDecimal value = new BigDecimal("-123.456");
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(new BigDecimal("-123.46"), result);
    }

    @Test
    public void testToScaledBigDecimalWithZero() throws Exception {
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal result = invokeToScaledBigDecimal(value);
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN), result);
    }

    private BigDecimal invokeToScaledBigDecimal(BigDecimal value) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", BigDecimal.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, value);
    }
}
