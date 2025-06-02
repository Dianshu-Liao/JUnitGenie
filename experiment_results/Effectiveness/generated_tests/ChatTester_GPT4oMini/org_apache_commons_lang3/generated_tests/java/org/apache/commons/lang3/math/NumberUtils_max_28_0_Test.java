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

class NumberUtils_max_28_0_Test {

    @Test
    void testMaxWithPositiveNumbers() {
        short[] input = { 1, 2, 3, 4, 5 };
        short result = NumberUtils.max(input);
        assertEquals(5, result);
    }

    @Test
    void testMaxWithNegativeNumbers() {
        short[] input = { -1, -2, -3, -4, -5 };
        short result = NumberUtils.max(input);
        assertEquals(-1, result);
    }

    @Test
    void testMaxWithMixedNumbers() {
        short[] input = { -1, 0, 1, 2 };
        short result = NumberUtils.max(input);
        assertEquals(2, result);
    }

    @Test
    void testMaxWithSingleElement() {
        short[] input = { 5 };
        short result = NumberUtils.max(input);
        assertEquals(5, result);
    }

    @Test
    void testMaxWithAllEqualElements() {
        short[] input = { 2, 2, 2, 2 };
        short result = NumberUtils.max(input);
        assertEquals(2, result);
    }

    @Test
    void testMaxWithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.max(new short[] {});
        });
    }

    @Test
    void testMaxWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Fixed the buggy line by casting to short[]
            NumberUtils.max((short[]) null);
        });
    }
}
