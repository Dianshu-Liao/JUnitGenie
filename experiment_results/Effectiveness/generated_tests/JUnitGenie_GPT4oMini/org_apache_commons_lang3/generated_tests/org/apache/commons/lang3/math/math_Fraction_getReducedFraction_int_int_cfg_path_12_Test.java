package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_Fraction_getReducedFraction_int_int_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_OverflowNegate() {
        int numerator = Integer.MIN_VALUE;
        int denominator = Integer.MIN_VALUE;

        try {
            Fraction result = Fraction.getReducedFraction(numerator, denominator);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("overflow: can't negate", e.getMessage());
        }
    }

}