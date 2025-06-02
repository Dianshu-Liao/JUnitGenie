package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.Fraction;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Objects;

class Fraction_getReducedFraction_5_0_Test {

    @Test
    void testGetReducedFraction_ZeroDenominator() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
        assertEquals("The denominator must not be zero", exception.getMessage());
    }

    @Test
    void testGetReducedFraction_ZeroNumerator() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertSame(Fraction.ZERO, result);
    }

    @Test
    void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(1, -2);
        assertEquals(-1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_NegativeNumeratorAndDenominator() {
        Fraction result = Fraction.getReducedFraction(-4, -8);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_PositiveFraction() {
        Fraction result = Fraction.getReducedFraction(4, 8);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_SimplifyingEvenDenominator() {
        Fraction result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
        assertEquals(1, result.getNumerator());
        assertEquals(Integer.MIN_VALUE / 2, result.getDenominator());
    }

    @Test
    void testGetReducedFraction_OverflowDenominator() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
        assertEquals("overflow: can't negate", exception.getMessage());
    }

    @Test
    void testGetReducedFraction_GreatestCommonDivisor() {
        Fraction result = Fraction.getReducedFraction(15, 5);
        assertEquals(3, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }
}
