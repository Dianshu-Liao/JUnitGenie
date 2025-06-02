package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_Fraction_getReducedFraction_int_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_ValidInput() {
        try {
            Fraction result = Fraction.getReducedFraction(4, 8);
            assertEquals(Fraction.getReducedFraction(1, 2), result);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ZeroDenominator() {
        try {
            Fraction result = Fraction.getReducedFraction(1, 0);
            fail("Expected ArithmeticException for zero denominator");
        } catch (ArithmeticException e) {
            assertEquals("The denominator must not be zero", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ZeroNumerator() {
        try {
            Fraction result = Fraction.getReducedFraction(0, 5);
            assertEquals(Fraction.ZERO, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown for zero numerator");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_NegativeDenominator() {
        try {
            Fraction result = Fraction.getReducedFraction(4, -8);
            assertEquals(Fraction.getReducedFraction(-1, 2), result);
        } catch (Exception e) {
            fail("Exception should not have been thrown for negative denominator");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_OverflowNegate() {
        try {
            Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
            fail("Expected ArithmeticException for overflow: can't negate");
        } catch (ArithmeticException e) {
            assertEquals("overflow: can't negate", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }


}