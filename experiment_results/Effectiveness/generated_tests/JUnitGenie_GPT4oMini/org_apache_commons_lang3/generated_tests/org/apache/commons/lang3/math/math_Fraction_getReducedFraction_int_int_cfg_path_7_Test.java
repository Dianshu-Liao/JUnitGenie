package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_Fraction_getReducedFraction_int_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction() {
        try {
            // Test case for a valid fraction
            Fraction result = Fraction.getReducedFraction(4, 8);
            assertEquals(Fraction.getReducedFraction(1, 2), result);

            // Test case for zero numerator
            result = Fraction.getReducedFraction(0, 5);
            assertEquals(Fraction.ZERO, result);

            // Test case for denominator being Integer.MIN_VALUE and numerator being even
            result = Fraction.getReducedFraction(4, Integer.MIN_VALUE);
            assertEquals(Fraction.getReducedFraction(-2, Integer.MAX_VALUE), result);

            // Test case for negative denominator
            result = Fraction.getReducedFraction(3, -6);
            assertEquals(Fraction.getReducedFraction(-1, 2), result);

            // Test case for denominator being zero (should throw exception)
            try {
                Fraction.getReducedFraction(1, 0);
                fail("Expected ArithmeticException for denominator = 0");
            } catch (ArithmeticException e) {
                assertEquals("The denominator must not be zero", e.getMessage());
            }

            // Test case for overflow when negating Integer.MIN_VALUE
            try {
                Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
                fail("Expected ArithmeticException for overflow");
            } catch (ArithmeticException e) {
                assertEquals("overflow: can't negate", e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}