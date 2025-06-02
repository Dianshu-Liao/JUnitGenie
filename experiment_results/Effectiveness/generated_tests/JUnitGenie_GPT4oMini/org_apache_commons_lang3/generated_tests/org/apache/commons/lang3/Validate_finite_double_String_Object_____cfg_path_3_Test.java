package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_finite_double_String_Object_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFiniteWithFiniteValue() {
        // This test should pass as the value is finite
        Validate.finite(1.0, "Value must be finite");
    }

    @Test(timeout = 4000)
    public void testFiniteWithNaNValue() {
        // This test should throw IllegalArgumentException
        try {
            Validate.finite(Double.NaN, "Value must be finite");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testFiniteWithInfiniteValue() {
        // This test should throw IllegalArgumentException
        try {
            Validate.finite(Double.POSITIVE_INFINITY, "Value must be finite");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}