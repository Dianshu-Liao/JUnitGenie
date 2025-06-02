package org.apache.commons.lang3.math;

import java.lang.reflect.Method;
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

public class NumberUtils_toScaledBigDecimal_56_0_Test {

    @Test
    public void testToScaledBigDecimal() throws Exception {
        // Test with a positive value
        Double positiveValue = 123.456;
        BigDecimal expectedPositive = new BigDecimal("123.46");
        BigDecimal actualPositive = invokeToScaledBigDecimal(positiveValue);
        assertEquals(expectedPositive, actualPositive);
        // Test with a negative value
        Double negativeValue = -123.456;
        BigDecimal expectedNegative = new BigDecimal("-123.46");
        BigDecimal actualNegative = invokeToScaledBigDecimal(negativeValue);
        assertEquals(expectedNegative, actualNegative);
        // Test with zero
        Double zeroValue = 0.0;
        BigDecimal expectedZero = new BigDecimal("0.00");
        BigDecimal actualZero = invokeToScaledBigDecimal(zeroValue);
        assertEquals(expectedZero, actualZero);
        // Test with a null value (should handle gracefully)
        Double nullValue = null;
        BigDecimal actualNull = invokeToScaledBigDecimal(nullValue);
        assertEquals(null, actualNull);
    }

    private BigDecimal invokeToScaledBigDecimal(Double value) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", Double.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, value);
    }
}
