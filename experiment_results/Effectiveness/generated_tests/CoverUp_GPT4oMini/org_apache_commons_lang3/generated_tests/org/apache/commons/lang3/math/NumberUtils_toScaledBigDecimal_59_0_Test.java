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

public class NumberUtils_toScaledBigDecimal_59_0_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() throws Exception {
        // Test with null Float value
        BigDecimal result = invokeToScaledBigDecimal(null, 2, RoundingMode.HALF_EVEN);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValue() throws Exception {
        // Test with a valid Float value
        BigDecimal result = invokeToScaledBigDecimal(1.2345f, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_ZeroValue() throws Exception {
        // Test with Float value of 0
        BigDecimal result = invokeToScaledBigDecimal(0.0f, 2, RoundingMode.HALF_EVEN);
        assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    public void testToScaledBigDecimal_NegativeValue() throws Exception {
        // Test with a negative Float value
        BigDecimal result = invokeToScaledBigDecimal(-1.2345f, 2, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("-1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_EmptyRoundingMode() throws Exception {
        // Test with a valid Float value and null RoundingMode
        BigDecimal result = invokeToScaledBigDecimal(1.2345f, 2, null);
        assertEquals(new BigDecimal("1.23"), result);
    }

    private BigDecimal invokeToScaledBigDecimal(Float value, int scale, RoundingMode roundingMode) throws Exception {
        // Use reflection to invoke the private method
        return (BigDecimal) NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", Float.class, int.class, RoundingMode.class).invoke(null, value, scale, roundingMode);
    }
}
