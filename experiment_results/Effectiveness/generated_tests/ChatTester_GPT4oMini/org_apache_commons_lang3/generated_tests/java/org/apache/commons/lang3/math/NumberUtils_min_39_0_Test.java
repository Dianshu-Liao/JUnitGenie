package org.apache.commons.lang3.math;

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

public class NumberUtils_min_39_0_Test {

    @Test
    public void testMin_WithPositiveValues() throws Exception {
        long result = invokeMin(3L, 2L, 5L);
        assertEquals(2L, result);
    }

    @Test
    public void testMin_WithNegativeValues() throws Exception {
        long result = invokeMin(-1L, -3L, -2L);
        assertEquals(-3L, result);
    }

    @Test
    public void testMin_WithMixedValues() throws Exception {
        long result = invokeMin(1L, -1L, 0L);
        assertEquals(-1L, result);
    }

    @Test
    public void testMin_WithAllEqualValues() throws Exception {
        long result = invokeMin(2L, 2L, 2L);
        assertEquals(2L, result);
    }

    @Test
    public void testMin_WithZeroValues() throws Exception {
        long result = invokeMin(0L, 0L, 0L);
        assertEquals(0L, result);
    }

    private long invokeMin(long a, long b, long c) throws Exception {
        Method method = NumberUtils.class.getDeclaredMethod("min", long.class, long.class, long.class);
        method.setAccessible(true);
        return (long) method.invoke(null, a, b, c);
    }
}
