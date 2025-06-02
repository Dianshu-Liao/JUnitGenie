package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils_min_33_0_Test {

    @Test
    public void testMinWithPositiveNumbers() {
        double result = invokeMin(3.0, 5.0, 2.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testMinWithNegativeNumbers() {
        double result = invokeMin(-1.0, -5.0, -3.0);
        assertEquals(-5.0, result);
    }

    @Test
    public void testMinWithMixedNumbers() {
        double result = invokeMin(1.0, -1.0, 0.0);
        assertEquals(-1.0, result);
    }

    @Test
    public void testMinWithAllEqualNumbers() {
        double result = invokeMin(2.0, 2.0, 2.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testMinWithZeros() {
        double result = invokeMin(0.0, 0.0, 0.0);
        assertEquals(0.0, result);
    }

    private double invokeMin(double a, double b, double c) {
        try {
            return (double) NumberUtils.class.getDeclaredMethod("min", double.class, double.class, double.class).invoke(null, a, b, c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
