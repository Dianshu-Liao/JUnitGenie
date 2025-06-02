package org.apache.commons.lang3.math;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Objects;

public class Fraction_hashCode_22_0_Test {

    @Test
    public void testHashCodeForZero() {
        Fraction fraction = Fraction.ZERO;
        int expectedHashCode = 37 * (37 * 17 + 0) + 1;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForOne() {
        Fraction fraction = Fraction.ONE;
        int expectedHashCode = 37 * (37 * 17 + 1) + 1;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForOneHalf() {
        Fraction fraction = Fraction.ONE_HALF;
        int expectedHashCode = 37 * (37 * 17 + 1) + 2;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForOneThird() {
        Fraction fraction = Fraction.ONE_THIRD;
        int expectedHashCode = 37 * (37 * 17 + 1) + 3;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForTwoThirds() {
        Fraction fraction = Fraction.TWO_THIRDS;
        int expectedHashCode = 37 * (37 * 17 + 2) + 3;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForOneQuarter() {
        Fraction fraction = Fraction.ONE_QUARTER;
        int expectedHashCode = 37 * (37 * 17 + 1) + 4;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForTwoFifths() {
        Fraction fraction = Fraction.TWO_FIFTHS;
        int expectedHashCode = 37 * (37 * 17 + 2) + 5;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForThreeFifths() {
        Fraction fraction = Fraction.THREE_FIFTHS;
        int expectedHashCode = 37 * (37 * 17 + 3) + 5;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForFourFifths() {
        Fraction fraction = Fraction.FOUR_FIFTHS;
        int expectedHashCode = 37 * (37 * 17 + 4) + 5;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForNegativeFraction() {
        // Using existing fractions
        Fraction fraction = Fraction.ZERO.subtract(Fraction.ONE_HALF);
        int expectedHashCode = 37 * (37 * 17 - 1) + 2;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeForPositiveFraction() {
        // Using existing fractions
        Fraction fraction = Fraction.ONE.add(Fraction.ONE_QUARTER);
        int expectedHashCode = 37 * (37 * 17 + 5) + 3;
        assertEquals(expectedHashCode, fraction.hashCode());
    }
}
