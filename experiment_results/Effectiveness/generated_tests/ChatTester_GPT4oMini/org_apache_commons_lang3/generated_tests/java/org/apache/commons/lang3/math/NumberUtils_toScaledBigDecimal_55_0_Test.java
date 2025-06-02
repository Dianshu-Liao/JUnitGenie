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

public class NumberUtils_toScaledBigDecimal_55_0_Test {

    @Test
    public void testToScaledBigDecimal_NullValue() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((BigDecimal) null, 2, RoundingMode.HALF_UP);
        Assertions.assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithRoundingMode() {
        BigDecimal value = new BigDecimal("1.2345");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 2, RoundingMode.HALF_UP);
        Assertions.assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithNullRoundingMode() {
        BigDecimal value = new BigDecimal("1.2345");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 2, null);
        Assertions.assertEquals(new BigDecimal("1.24"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithNegativeScale() {
        BigDecimal value = new BigDecimal("123.456");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, -1, RoundingMode.HALF_UP);
        Assertions.assertEquals(new BigDecimal("120"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithZeroScale() {
        BigDecimal value = new BigDecimal("1.999");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 0, RoundingMode.HALF_UP);
        Assertions.assertEquals(new BigDecimal("2"), result);
    }

    @Test
    public void testToScaledBigDecimal_ValidValueWithNegativeRoundingMode() {
        BigDecimal value = new BigDecimal("1.2345");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 2, RoundingMode.DOWN);
        Assertions.assertEquals(new BigDecimal("1.23"), result);
    }
}
