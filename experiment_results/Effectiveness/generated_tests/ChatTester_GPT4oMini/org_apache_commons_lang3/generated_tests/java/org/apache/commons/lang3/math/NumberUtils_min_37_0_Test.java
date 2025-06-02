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

class NumberUtils_min_37_0_Test {

    @Test
    void testMinWithAllPositiveNumbers() {
        int result = NumberUtils.min(5, 3, 4);
        assertEquals(3, result, "The minimum of 5, 3, and 4 should be 3");
    }

    @Test
    void testMinWithNegativeAndPositiveNumbers() {
        int result = NumberUtils.min(5, -1, 4);
        assertEquals(-1, result, "The minimum of 5, -1, and 4 should be -1");
    }

    @Test
    void testMinWithAllNegativeNumbers() {
        int result = NumberUtils.min(-5, -3, -4);
        assertEquals(-5, result, "The minimum of -5, -3, and -4 should be -5");
    }

    @Test
    void testMinWithZero() {
        int result = NumberUtils.min(0, 0, 0);
        assertEquals(0, result, "The minimum of 0, 0, and 0 should be 0");
    }

    @Test
    void testMinWithTwoEqualNumbers() {
        int result = NumberUtils.min(5, 5, 4);
        assertEquals(4, result, "The minimum of 5, 5, and 4 should be 4");
    }

    @Test
    void testMinWithMixedValues() {
        int result = NumberUtils.min(1, 2, -1);
        assertEquals(-1, result, "The minimum of 1, 2, and -1 should be -1");
    }

    @Test
    void testMinWithSameNumbers() {
        int result = NumberUtils.min(3, 3, 3);
        assertEquals(3, result, "The minimum of 3, 3, and 3 should be 3");
    }

    @Test
    void testMinWithEdgeValues() {
        int result = NumberUtils.min(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(Integer.MIN_VALUE, result, "The minimum of Integer.MAX_VALUE, Integer.MIN_VALUE, and 0 should be Integer.MIN_VALUE");
    }
}
