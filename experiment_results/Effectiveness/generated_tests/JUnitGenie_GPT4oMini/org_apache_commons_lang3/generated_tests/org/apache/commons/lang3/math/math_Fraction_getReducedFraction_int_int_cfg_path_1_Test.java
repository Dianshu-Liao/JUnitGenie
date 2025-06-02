package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_Fraction_getReducedFraction_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_DenominatorZero() {
        try {
            Fraction result = Fraction.getReducedFraction(1, 0);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("The denominator must not be zero", e.getMessage());
        }
    }

}