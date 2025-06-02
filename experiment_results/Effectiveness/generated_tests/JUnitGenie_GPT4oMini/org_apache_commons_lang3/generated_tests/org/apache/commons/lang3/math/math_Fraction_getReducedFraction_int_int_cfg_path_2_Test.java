package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_Fraction_getReducedFraction_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_NumeratorIsZero() {
        try {
            Fraction result = Fraction.getReducedFraction(0, 5);
            assertEquals(Fraction.ZERO, result);
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetReducedFraction_DenominatorIsZero() {
        try {
            Fraction result = Fraction.getReducedFraction(5, 0);
        } catch (ArithmeticException e) {
            // Expected exception
            assertEquals("The denominator must not be zero", e.getMessage());
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

}