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

public class NumberUtils_toScaledBigDecimal_57_0_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        BigDecimal result = invokeToScaledBigDecimal(null, 2, RoundingMode.HALF_UP);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValue() {
        BigDecimal result = invokeToScaledBigDecimal(1.2345, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithDifferentScale() {
        BigDecimal result = invokeToScaledBigDecimal(1.2345, 3, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("1.235"), result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() {
        BigDecimal result = invokeToScaledBigDecimal(-1.2345, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("-1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_ZeroValue() {
        BigDecimal result = invokeToScaledBigDecimal(0.0, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    public void testToScaledBigDecimal_NullRoundingMode() {
        BigDecimal result = invokeToScaledBigDecimal(1.2345, 2, null);
        assertEquals(new BigDecimal("1.23"), result);
    }

    private BigDecimal invokeToScaledBigDecimal(Double value, int scale, RoundingMode roundingMode) {
        try {
            return (BigDecimal) NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", Double.class, int.class, RoundingMode.class).invoke(null, value, scale, roundingMode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
