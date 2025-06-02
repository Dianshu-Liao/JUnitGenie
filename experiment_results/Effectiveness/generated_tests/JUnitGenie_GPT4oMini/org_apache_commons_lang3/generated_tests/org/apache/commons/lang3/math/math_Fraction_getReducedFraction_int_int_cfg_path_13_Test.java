package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class math_Fraction_getReducedFraction_int_int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetReducedFraction_OverflowNegate() {
        try {
            Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("overflow: can't negate", e.getMessage());
        }
    }

}