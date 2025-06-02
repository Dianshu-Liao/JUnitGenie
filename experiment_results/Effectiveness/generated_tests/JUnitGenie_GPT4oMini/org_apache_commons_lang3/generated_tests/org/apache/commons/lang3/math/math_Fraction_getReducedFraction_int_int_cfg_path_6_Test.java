package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_Fraction_getReducedFraction_int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction() {
        try {
            // Test case for a valid fraction
            Fraction result = Fraction.getReducedFraction(4, 8);
            assertEquals(Fraction.getReducedFraction(1, 2), result);

            // Test case for zero numerator
            result = Fraction.getReducedFraction(0, 5);
            assertEquals(Fraction.ZERO, result);

            // Test case for negative denominator
            result = Fraction.getReducedFraction(4, -8);
            assertEquals(Fraction.getReducedFraction(-1, 2), result);

            // Test case for Integer.MIN_VALUE as denominator
            result = Fraction.getReducedFraction(2, Integer.MIN_VALUE);
            assertEquals(Fraction.getReducedFraction(1, Integer.MIN_VALUE / 2), result);

            // Test case for overflow scenario
            try {
                result = Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
                fail("Expected ArithmeticException for overflow");
            } catch (ArithmeticException e) {
                assertEquals("overflow: can't negate", e.getMessage());
            }

        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFractionDenominatorZero() {
        try {
            Fraction.getReducedFraction(1, 0);
            fail("Expected ArithmeticException for denominator zero");
        } catch (ArithmeticException e) {
            assertEquals("The denominator must not be zero", e.getMessage());
        }
    }


}