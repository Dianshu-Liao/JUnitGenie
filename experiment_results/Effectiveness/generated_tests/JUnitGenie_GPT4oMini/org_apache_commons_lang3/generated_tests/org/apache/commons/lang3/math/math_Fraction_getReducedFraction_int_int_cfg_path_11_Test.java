package org.apache.commons.lang3.math;
import static org.junit.Assert.*;
import org.junit.Test;
import org.apache.commons.lang3.math.Fraction;

public class math_Fraction_getReducedFraction_int_int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_NormalCase() {
        // Given
        int numerator = 4;
        int denominator = 8;

        // When
        Fraction result = Fraction.getReducedFraction(numerator, denominator);

        // Then
        assertEquals(Fraction.getReducedFraction(1, 2), result);
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ZeroDenominator() {
        // Given
        int numerator = 1;
        int denominator = 0;

        // When
        try {
            Fraction.getReducedFraction(numerator, denominator);
            fail("Expected ArithmeticException due to zero denominator");
        } catch (ArithmeticException e) {
            // Expected exception
            assertEquals("The denominator must not be zero", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ZeroNumerator() {
        // Given
        int numerator = 0;
        int denominator = 5;

        // When
        Fraction result = Fraction.getReducedFraction(numerator, denominator);

        // Then
        assertEquals(Fraction.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_NegativeDenominator() {
        // Given
        int numerator = 3;
        int denominator = -9;

        // When
        Fraction result = Fraction.getReducedFraction(numerator, denominator);

        // Then
        assertEquals(Fraction.getReducedFraction(-1, 3), result);
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_NegativeNumeratorAndDenominator() {
        // Given
        int numerator = -16;
        int denominator = -4;

        // When
        Fraction result = Fraction.getReducedFraction(numerator, denominator);

        // Then
        assertEquals(Fraction.getReducedFraction(4, 1), result);
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_OverflowNegate() {
        // Given
        int numerator = Integer.MIN_VALUE; 
        int denominator = Integer.MIN_VALUE; 

        // When
        try {
            Fraction.getReducedFraction(numerator, denominator);
            fail("Expected ArithmeticException due to overflow when negating");
        } catch (ArithmeticException e) {
            // Expected exception
            assertEquals("overflow: can't negate", e.getMessage());
        }
    }


}