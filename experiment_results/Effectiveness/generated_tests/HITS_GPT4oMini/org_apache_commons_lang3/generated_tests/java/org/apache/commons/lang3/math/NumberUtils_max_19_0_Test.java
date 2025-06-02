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

public class NumberUtils_max_19_0_Test {

    @Test
    public void testMaxWithAllPositiveNumbers() {
        byte result = NumberUtils.max((byte) 1, (byte) 2, (byte) 3);
        assertEquals(3, result);
    }

    @Test
    public void testMaxWithNegativeAndPositiveNumbers() {
        byte result = NumberUtils.max((byte) -1, (byte) 0, (byte) 1);
        assertEquals(1, result);
    }

    @Test
    public void testMaxWithAllNegativeNumbers() {
        byte result = NumberUtils.max((byte) -3, (byte) -2, (byte) -1);
        assertEquals(-1, result);
    }

    @Test
    public void testMaxWithTwoEqualNumbers() {
        byte result = NumberUtils.max((byte) 5, (byte) 5, (byte) 3);
        assertEquals(5, result);
    }

    @Test
    public void testMaxWithAllZeros() {
        byte result = NumberUtils.max((byte) 0, (byte) 0, (byte) 0);
        assertEquals(0, result);
    }

    @Test
    public void testMaxWithMixedZerosAndNegatives() {
        byte result = NumberUtils.max((byte) 0, (byte) -1, (byte) -2);
        assertEquals(0, result);
    }

    @Test
    public void testMaxWithMixedZerosAndPositives() {
        byte result = NumberUtils.max((byte) 0, (byte) 1, (byte) 2);
        assertEquals(2, result);
    }

    @Test
    public void testMaxWithFirstNumberAsMax() {
        byte result = NumberUtils.max((byte) 10, (byte) 5, (byte) 3);
        assertEquals(10, result);
    }

    @Test
    public void testMaxWithLastNumberAsMax() {
        byte result = NumberUtils.max((byte) 5, (byte) 3, (byte) 10);
        assertEquals(10, result);
    }
}
