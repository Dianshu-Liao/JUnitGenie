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

public class NumberUtils_max_29_0_Test {

    @Test
    public void testMaxWithAllNegativeNumbers() {
        short result = NumberUtils.max((short) -3, (short) -5, (short) -1);
        assertEquals((short) -1, result);
    }

    @Test
    public void testMaxWithMixedNegativeAndPositiveNumbers() {
        short result = NumberUtils.max((short) -3, (short) 5, (short) -1);
        assertEquals((short) 5, result);
    }

    @Test
    public void testMaxWithAllPositiveNumbers() {
        short result = NumberUtils.max((short) 3, (short) 5, (short) 1);
        assertEquals((short) 5, result);
    }

    @Test
    public void testMaxWithEqualNumbers() {
        short result = NumberUtils.max((short) 3, (short) 3, (short) 3);
        assertEquals((short) 3, result);
    }

    @Test
    public void testMaxWithOnePositiveAndTwoNegativeNumbers() {
        short result = NumberUtils.max((short) -2, (short) -3, (short) 0);
        assertEquals((short) 0, result);
    }

    @Test
    public void testMaxWithTwoEqualAndOneDifferent() {
        short result = NumberUtils.max((short) 2, (short) 2, (short) 3);
        assertEquals((short) 3, result);
    }

    @Test
    public void testMaxWithTwoEqualAndOneLower() {
        short result = NumberUtils.max((short) 4, (short) 4, (short) 2);
        assertEquals((short) 4, result);
    }

    @Test
    public void testMaxWithAllZeros() {
        short result = NumberUtils.max((short) 0, (short) 0, (short) 0);
        assertEquals((short) 0, result);
    }

    @Test
    public void testMaxWithNegativeAndZero() {
        short result = NumberUtils.max((short) -1, (short) 0, (short) -2);
        assertEquals((short) 0, result);
    }
}
