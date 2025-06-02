package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

public class math_Fraction_getReducedFraction_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_ValidValues() {
        try {
            Fraction result = Fraction.getReducedFraction(4, 8);
            assertEquals(Fraction.getReducedFraction(1, 2), result);
        } catch (Exception e) {
            fail("Should not have thrown any exception for valid input values.");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_ZeroDenominator() {
        try {
            Fraction result = Fraction.getReducedFraction(1, 0);
            fail("Expected ArithmeticException for zero denominator.");
        } catch (ArithmeticException e) {
            assertEquals("The denominator must not be zero", e.getMessage());
        } catch (Exception e) {
            fail("Expected ArithmeticException but got a different exception.");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_OverflowNegate() {
        try {
            Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, -1);
            fail("Expected ArithmeticException for overflow negate.");
        } catch (ArithmeticException e) {
            assertEquals("overflow: can't negate", e.getMessage());
        } catch (Exception e) {
            fail("Expected ArithmeticException but got a different exception.");
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_NegativeDenominator() {
        try {
            Fraction result = Fraction.getReducedFraction(3, -6);
            assertEquals(Fraction.getReducedFraction(-1, 2), result);
        } catch (Exception e) {
            fail("Should not have thrown any exception for valid negative denominator.");
        }
    }


}