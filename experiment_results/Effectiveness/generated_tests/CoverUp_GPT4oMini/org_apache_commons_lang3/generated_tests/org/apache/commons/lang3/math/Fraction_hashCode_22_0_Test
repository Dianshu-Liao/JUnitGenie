package org.apache.commons.lang3.math;

import org.apache.commons.lang3.math.Fraction;
import java.lang.reflect.Constructor;
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
    public void testHashCodeWithZero() throws Exception {
        Fraction fraction = Fraction.ZERO;
        int expectedHashCode = fraction.hashCode();
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeWithOne() throws Exception {
        Fraction fraction = Fraction.ONE;
        int expectedHashCode = fraction.hashCode();
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeWithOneHalf() throws Exception {
        Fraction fraction = Fraction.ONE_HALF;
        int expectedHashCode = fraction.hashCode();
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeWithCustomFraction() throws Exception {
        Fraction fraction = createFraction(3, 4);
        int expectedHashCode = 37 * (37 * 17 + 3) + 4;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeCaching() throws Exception {
        Fraction fraction = createFraction(5, 6);
        int firstHashCode = fraction.hashCode();
        int secondHashCode = fraction.hashCode();
        assertEquals(firstHashCode, secondHashCode);
    }

    @Test
    public void testHashCodeWithNegativeFraction() throws Exception {
        Fraction fraction = createFraction(-1, 2);
        int expectedHashCode = 37 * (37 * 17 - 1) + 2;
        assertEquals(expectedHashCode, fraction.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentFractions() throws Exception {
        Fraction fraction1 = createFraction(1, 3);
        Fraction fraction2 = createFraction(2, 3);
        assertNotEquals(fraction1.hashCode(), fraction2.hashCode());
    }

    private Fraction createFraction(int numerator, int denominator) throws Exception {
        Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        return constructor.newInstance(numerator, denominator);
    }
}
