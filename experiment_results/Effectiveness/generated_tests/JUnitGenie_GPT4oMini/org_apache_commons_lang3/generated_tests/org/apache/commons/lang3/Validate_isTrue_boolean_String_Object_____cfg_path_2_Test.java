package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_isTrue_boolean_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsTrue_withTrueExpression() {
        // This test should pass as the expression is true
        Validate.isTrue(true, "This should not throw an exception");
    }

    @Test(timeout = 4000)
    public void testIsTrue_withFalseExpression() {
        // This test should throw an IllegalArgumentException
        try {
            Validate.isTrue(false, "This should throw an exception");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("This should throw an exception");
        }
    }

    @Test(timeout = 4000)
    public void testIsTrue_withFalseExpressionAndValues() {
        // This test should throw an IllegalArgumentException with formatted message
        try {
            Validate.isTrue(false, "Error: %s", "Invalid input");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Error: Invalid input");
        }
    }

}