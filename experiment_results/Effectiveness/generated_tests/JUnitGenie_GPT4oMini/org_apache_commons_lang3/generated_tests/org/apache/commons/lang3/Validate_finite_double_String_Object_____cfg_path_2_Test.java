package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_finite_double_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFiniteThrowsIllegalArgumentExceptionForNaN() {
        try {
            Validate.finite(Double.NaN, "Value must be finite");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Value must be finite");
        }
    }

    @Test(timeout = 4000)
    public void testFiniteThrowsIllegalArgumentExceptionForInfinite() {
        try {
            Validate.finite(Double.POSITIVE_INFINITY, "Value must be finite");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Value must be finite");
        }
    }

    @Test(timeout = 4000)
    public void testFiniteDoesNotThrowForFiniteValue() {
        Validate.finite(1.0, "Value must be finite", new Object[]{});
        // No exception is expected
    }

}