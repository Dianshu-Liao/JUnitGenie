package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.NumberUtils;
import java.lang.reflect.Method;
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

class NumberUtils_min_32_0_Test {

    @Test
    void testMinWithValidArray() throws Exception {
        double[] array = { 3.0, 1.0, 2.0 };
        double result = invokeMin(array);
        assertEquals(1.0, result);
    }

    @Test
    void testMinWithNegativeValues() throws Exception {
        double[] array = { -1.0, -2.0, -3.0 };
        double result = invokeMin(array);
        assertEquals(-3.0, result);
    }

    @Test
    void testMinWithNaN() throws Exception {
        double[] array = { 1.0, Double.NaN, 2.0 };
        double result = invokeMin(array);
        assertEquals(Double.NaN, result);
    }

    @Test
    void testMinWithSingleElement() throws Exception {
        double[] array = { 5.0 };
        double result = invokeMin(array);
        assertEquals(5.0, result);
    }

    @Test
    void testMinWithEmptyArray() {
        assertThrows(NullPointerException.class, () -> {
            invokeMin(new double[] {});
        });
    }

    @Test
    void testMinWithNullArray() {
        assertThrows(NullPointerException.class, () -> {
            invokeMin(null);
        });
    }

    private double invokeMin(double[] array) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("min", double[].class);
        method.setAccessible(true);
        return (double) method.invoke(null, (Object) array);
    }
}
