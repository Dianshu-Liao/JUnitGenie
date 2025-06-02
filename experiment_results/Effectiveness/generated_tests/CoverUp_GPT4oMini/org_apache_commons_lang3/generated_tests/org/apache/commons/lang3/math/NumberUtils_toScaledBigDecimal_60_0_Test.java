package org.apache.commons.lang3.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.reflect.Method;
import org.apache.commons.lang3.math.NumberUtils;
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

    private NumberUtils numberUtils;

    @BeforeEach
    public void setUp() {
        numberUtils = new NumberUtils();
    }

    @Test
    public void testToScaledBigDecimal_NullInput() throws Exception {
        BigDecimal result = invokeToScaledBigDecimal("null");
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testToScaledBigDecimal_ValidInput() throws Exception {
        BigDecimal result = invokeToScaledBigDecimal("123.456");
        assertEquals(new BigDecimal("123.46"), result);
    }

    @Test
    public void testToScaledBigDecimal_EmptyString() throws Exception {
        BigDecimal result = invokeToScaledBigDecimal("");
        assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    public void testToScaledBigDecimal_InvalidNumberFormat() {
        assertThrows(NumberFormatException.class, () -> {
            invokeToScaledBigDecimal("invalid");
        });
    }

    private BigDecimal invokeToScaledBigDecimal(String value) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("toScaledBigDecimal", String.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, value);
    }
}
