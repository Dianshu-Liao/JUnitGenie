package org.apache.commons.lang3.math;

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

public class NumberUtils_min_41_0_Test {

    @Test
    public void testMinWithAllPositiveValues() {
        short result = NumberUtils.min((short) 5, (short) 3, (short) 4);
        assertEquals((short) 3, result);
    }

    @Test
    public void testMinWithNegativeAndPositiveValues() {
        short result = NumberUtils.min((short) 1, (short) -1, (short) 0);
        assertEquals((short) -1, result);
    }

    @Test
    public void testMinWithAllNegativeValues() {
        short result = NumberUtils.min((short) -2, (short) -3, (short) -1);
        assertEquals((short) -3, result);
    }

    @Test
    public void testMinWithEqualValues() {
        short result = NumberUtils.min((short) 2, (short) 2, (short) 2);
        assertEquals((short) 2, result);
    }

    @Test
    public void testMinWithMixedValues() {
        short result = NumberUtils.min((short) 0, (short) 5, (short) -10);
        assertEquals((short) -10, result);
    }

    @Test
    public void testMinWithBoundaryValues() {
        short result = NumberUtils.min(Short.MAX_VALUE, Short.MIN_VALUE, (short) 0);
        assertEquals(Short.MIN_VALUE, result);
    }

    @Test
    public void testMinWithIdenticalMinValue() {
        short result = NumberUtils.min((short) 10, (short) 10, (short) 5);
        assertEquals((short) 5, result);
    }

    @Test
    public void testMinWithAllZeros() {
        short result = NumberUtils.min((short) 0, (short) 0, (short) 0);
        assertEquals((short) 0, result);
    }

    @Test
    public void testMinWithMixedSigns() {
        short result = NumberUtils.min((short) -5, (short) 5, (short) -10);
        assertEquals((short) -10, result);
    }
}
