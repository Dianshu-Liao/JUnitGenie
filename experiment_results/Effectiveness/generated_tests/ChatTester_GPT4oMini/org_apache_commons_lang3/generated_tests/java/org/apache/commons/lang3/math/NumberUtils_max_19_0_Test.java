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
    public void testMax_withAllNegativeValues() {
        byte result = NumberUtils.max((byte) -5, (byte) -3, (byte) -4);
        assertEquals((byte) -3, result);
    }

    @Test
    public void testMax_withMixedValues() {
        byte result = NumberUtils.max((byte) 1, (byte) -1, (byte) 0);
        assertEquals((byte) 1, result);
    }

    @Test
    public void testMax_withAllPositiveValues() {
        byte result = NumberUtils.max((byte) 2, (byte) 3, (byte) 1);
        assertEquals((byte) 3, result);
    }

    @Test
    public void testMax_withEqualValues() {
        byte result = NumberUtils.max((byte) 2, (byte) 2, (byte) 2);
        assertEquals((byte) 2, result);
    }

    @Test
    public void testMax_withOneValueGreater() {
        byte result = NumberUtils.max((byte) 0, (byte) 5, (byte) 3);
        assertEquals((byte) 5, result);
    }

    @Test
    public void testMax_withZeroValues() {
        byte result = NumberUtils.max((byte) 0, (byte) 0, (byte) 0);
        assertEquals((byte) 0, result);
    }

    @Test
    public void testMax_withNegativeAndPositiveValues() {
        byte result = NumberUtils.max((byte) -1, (byte) 1, (byte) 0);
        assertEquals((byte) 1, result);
    }
}
