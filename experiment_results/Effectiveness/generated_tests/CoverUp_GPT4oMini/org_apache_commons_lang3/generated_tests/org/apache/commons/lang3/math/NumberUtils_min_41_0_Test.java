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

public class NumberUtils_min_41_0_Test {

    @Test
    public void testMinThreeShorts_AllPositive() {
        short result = NumberUtils.min((short) 5, (short) 10, (short) 15);
        assertEquals((short) 5, result);
    }

    @Test
    public void testMinThreeShorts_OneNegative() {
        short result = NumberUtils.min((short) 5, (short) -10, (short) 15);
        assertEquals((short) -10, result);
    }

    @Test
    public void testMinThreeShorts_AllNegative() {
        short result = NumberUtils.min((short) -5, (short) -10, (short) -15);
        assertEquals((short) -15, result);
    }

    @Test
    public void testMinThreeShorts_EqualValues() {
        short result = NumberUtils.min((short) 5, (short) 5, (short) 5);
        assertEquals((short) 5, result);
    }

    @Test
    public void testMinThreeShorts_TwoEqualAndOneDifferent() {
        short result = NumberUtils.min((short) 5, (short) 5, (short) 3);
        assertEquals((short) 3, result);
    }

    @Test
    public void testMinThreeShorts_ZeroIncluded() {
        short result = NumberUtils.min((short) 0, (short) 5, (short) -5);
        assertEquals((short) -5, result);
    }
}
