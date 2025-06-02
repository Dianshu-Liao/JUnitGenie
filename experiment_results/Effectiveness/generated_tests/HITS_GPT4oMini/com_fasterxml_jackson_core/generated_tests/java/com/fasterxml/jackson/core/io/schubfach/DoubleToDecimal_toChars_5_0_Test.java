package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10pow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10threeQuartersPow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog2pow10;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g0;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Double.doubleToRawLongBits;
import static java.lang.Long.numberOfLeadingZeros;

class DoubleToDecimal_toChars_5_0_Test {

    @Test
    void testToCharsWithPositiveLongAndSmallExponent() {
        long f = 12345678L;
        int e = 0;
        // Expected length for digits in 12345678
        int expectedLength = 8;
        int result = invokeToChars(f, e);
        assertEquals(expectedLength, result);
    }

    @Test
    void testToCharsWithPositiveLongAndLargeExponent() {
        long f = 1234567890123456789L;
        int e = 10;
        // Expected length for digits in 1234567890123456789
        int expectedLength = 19;
        int result = invokeToChars(f, e);
        assertEquals(expectedLength, result);
    }

    @Test
    void testToCharsWithZero() {
        long f = 0L;
        int e = 0;
        // Expected length for zero representation
        int expectedLength = 1;
        int result = invokeToChars(f, e);
        assertEquals(expectedLength, result);
    }

    @Test
    void testToCharsWithNegativeLong() {
        long f = -12345678L;
        int e = 0;
        // Expected length for digits in 12345678
        int expectedLength = 8;
        int result = invokeToChars(f, e);
        assertEquals(expectedLength, result);
    }

    @Test
    void testToCharsWithLongGreaterThanPow10() {
        long f = 10000000000L;
        int e = 0;
        // Expected length for digits in 10000000000
        int expectedLength = 11;
        int result = invokeToChars(f, e);
        assertEquals(expectedLength, result);
    }

    @Test
    void testToCharsWithLongThatRequiresLengthIncrease() {
        long f = 99999999L;
        int e = 0;
        // Expected length for digits in 99999999
        int expectedLength = 8;
        int result = invokeToChars(f, e);
        assertEquals(expectedLength, result);
    }

    private int invokeToChars(long f, int e) {
        try {
            Method method = DoubleToDecimal.class.getDeclaredMethod("toChars", long.class, int.class);
            method.setAccessible(true);
            // Pass null because toChars is a static method
            return (int) method.invoke(null, f, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
