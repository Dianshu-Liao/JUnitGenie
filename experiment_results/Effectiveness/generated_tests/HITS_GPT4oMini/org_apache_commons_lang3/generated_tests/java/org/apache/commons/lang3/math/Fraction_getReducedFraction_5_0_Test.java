package org.apache.commons.lang3.math;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Objects;

public class Fraction_getReducedFraction_5_0_Test {

    @Test
    public void testGetReducedFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 5);
        assertEquals(Fraction.ZERO, result);
    }

    @Test
    public void testGetReducedFraction_NegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(1, -2);
        assertEquals(Fraction.ONE_HALF.negate(), result);
    }

    @Test
    public void testGetReducedFraction_PositiveFraction() {
        Fraction result = Fraction.getReducedFraction(4, 8);
        assertEquals(Fraction.ONE_HALF, result);
    }

    @Test
    public void testGetReducedFraction_NegativeFraction() {
        Fraction result = Fraction.getReducedFraction(-4, 8);
        assertEquals(Fraction.ONE_HALF.negate(), result);
    }

    @Test
    public void testGetReducedFraction_OverflowDenominator() {
        assertThrows(ArithmeticException.class, () -> {
            Fraction.getReducedFraction(Integer.MIN_VALUE, -1);
        });
    }

    @Test
    public void testGetReducedFraction_OverflowNumerator() {
        assertThrows(ArithmeticException.class, () -> {
            Fraction.getReducedFraction(-1, Integer.MIN_VALUE);
        });
    }

    @Test
    public void testGetReducedFraction_GreatestCommonDivisor() {
        Fraction result = Fraction.getReducedFraction(10, 5);
        assertEquals(Fraction.TWO_FIFTHS, result);
    }

    @Test
    public void testGetReducedFraction_SimplifyNegativeFraction() {
        Fraction result = Fraction.getReducedFraction(-10, -5);
        assertEquals(Fraction.TWO_FIFTHS, result);
    }

    @Test
    public void testGetReducedFraction_SimplifyMixedFraction() {
        Fraction result = Fraction.getReducedFraction(6, 9);
        assertEquals(Fraction.TWO_THIRDS, result);
    }

    @Test
    public void testGetReducedFraction_DenominatorIsZero() {
        assertThrows(ArithmeticException.class, () -> {
            Fraction.getReducedFraction(1, 0);
        });
    }
}
