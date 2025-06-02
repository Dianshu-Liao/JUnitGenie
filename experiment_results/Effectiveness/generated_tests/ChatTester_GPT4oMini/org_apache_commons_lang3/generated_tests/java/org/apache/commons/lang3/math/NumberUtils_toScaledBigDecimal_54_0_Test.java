package org.apache.commons.lang3.math;

import org.junit.jupiter.api.function.Executable;
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

class NumberUtils_toScaledBigDecimal_54_0_Test {

    @Test
    void testToScaledBigDecimal() {
        // Test with a normal positive BigDecimal
        BigDecimal value1 = new BigDecimal("123.456");
        BigDecimal expected1 = value1.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected1, invokeToScaledBigDecimal(value1));
        // Test with a normal negative BigDecimal
        BigDecimal value2 = new BigDecimal("-123.456");
        BigDecimal expected2 = value2.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected2, invokeToScaledBigDecimal(value2));
        // Test with zero
        BigDecimal value3 = BigDecimal.ZERO;
        BigDecimal expected3 = value3.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected3, invokeToScaledBigDecimal(value3));
        // Test with a BigDecimal with no decimal part
        BigDecimal value4 = new BigDecimal("100");
        BigDecimal expected4 = value4.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected4, invokeToScaledBigDecimal(value4));
        // Test with a BigDecimal that has more than two decimal places
        BigDecimal value5 = new BigDecimal("123.4567");
        BigDecimal expected5 = value5.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected5, invokeToScaledBigDecimal(value5));
        // Test with a BigDecimal that has exactly two decimal places
        BigDecimal value6 = new BigDecimal("123.45");
        BigDecimal expected6 = value6.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected6, invokeToScaledBigDecimal(value6));
        // Test with a BigDecimal that has one decimal place
        BigDecimal value7 = new BigDecimal("123.4");
        BigDecimal expected7 = value7.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected7, invokeToScaledBigDecimal(value7));
        // Test with a very large BigDecimal
        BigDecimal value8 = new BigDecimal("12345678901234567890.123456789");
        BigDecimal expected8 = value8.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected8, invokeToScaledBigDecimal(value8));
        // Test with a very small BigDecimal
        BigDecimal value9 = new BigDecimal("0.000123456");
        BigDecimal expected9 = value9.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected9, invokeToScaledBigDecimal(value9));
    }

    private BigDecimal invokeToScaledBigDecimal(BigDecimal value) {
        try {
            return (BigDecimal) NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", BigDecimal.class).invoke(null, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
