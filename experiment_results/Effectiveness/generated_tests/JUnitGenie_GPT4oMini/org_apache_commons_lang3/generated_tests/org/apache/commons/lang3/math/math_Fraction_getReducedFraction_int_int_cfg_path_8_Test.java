package org.apache.commons.lang3.math;
import static org.junit.Assert.*;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

public class math_Fraction_getReducedFraction_int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_ExceptionOnDenominatorZero() {
        try {
            Fraction result = Fraction.getReducedFraction(1, 0);
            fail("Expected ArithmeticException was not thrown.");
        } catch (ArithmeticException e) {
            assertEquals("The denominator must not be zero", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ValidFraction() {
        Fraction result = Fraction.getReducedFraction(4, 8);
        assertEquals(Fraction.getReducedFraction(1, 2), result);
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ValidFraction_NumeratorZero() {
        Fraction result = Fraction.getReducedFraction(0, 10);
        assertEquals(Fraction.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_OverflowNegation() {
        try {
            Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
            fail("Expected ArithmeticException was not thrown.");
        } catch (ArithmeticException e) {
            assertEquals("overflow: can't negate", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ZeroDenominatorAfterNormalization() {
        try {
            Fraction result = Fraction.getReducedFraction(-Integer.MIN_VALUE, -2);
            fail("Expected ArithmeticException was not thrown.");
        } catch (ArithmeticException e) {
            assertEquals("overflow: can't negate", e.getMessage());
        }
    }


}