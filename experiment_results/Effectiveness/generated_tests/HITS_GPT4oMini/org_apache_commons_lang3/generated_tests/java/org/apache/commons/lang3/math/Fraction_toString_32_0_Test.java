package org.apache.commons.lang3.math;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Objects;

public class Fraction_toString_32_0_Test {

    @Test
    public void testToStringZero() {
        assertEquals("0/1", Fraction.ZERO.toString());
    }

    @Test
    public void testToStringOne() {
        assertEquals("1/1", Fraction.ONE.toString());
    }

    @Test
    public void testToStringOneHalf() {
        assertEquals("1/2", Fraction.ONE_HALF.toString());
    }

    @Test
    public void testToStringOneThird() {
        assertEquals("1/3", Fraction.ONE_THIRD.toString());
    }

    @Test
    public void testToStringTwoThirds() {
        assertEquals("2/3", Fraction.TWO_THIRDS.toString());
    }

    @Test
    public void testToStringOneQuarter() {
        assertEquals("1/4", Fraction.ONE_QUARTER.toString());
    }

    @Test
    public void testToStringTwoQuarters() {
        assertEquals("2/4", Fraction.TWO_QUARTERS.toString());
    }

    @Test
    public void testToStringThreeQuarters() {
        assertEquals("3/4", Fraction.THREE_QUARTERS.toString());
    }

    @Test
    public void testToStringOneFifth() {
        assertEquals("1/5", Fraction.ONE_FIFTH.toString());
    }

    @Test
    public void testToStringTwoFifths() {
        assertEquals("2/5", Fraction.TWO_FIFTHS.toString());
    }

    @Test
    public void testToStringThreeFifths() {
        assertEquals("3/5", Fraction.THREE_FIFTHS.toString());
    }

    @Test
    public void testToStringFourFifths() {
        assertEquals("4/5", Fraction.FOUR_FIFTHS.toString());
    }
}
