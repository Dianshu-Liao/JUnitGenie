package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_isInstanceOf_Class_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsInstanceOf_WithValidInstance() {
        // Arrange
        Class<String> type = String.class;
        String obj = "test";

        // Act
        Validate.isInstanceOf(type, obj);

        // Assert
        // No exception is expected, so we do not need an assertion here.
    }

    @Test(timeout = 4000)
    public void testIsInstanceOf_WithInvalidInstance() {
        // Arrange
        Class<String> type = String.class;
        Integer obj = 123;

        // Act
        try {
            Validate.isInstanceOf(type, obj);
        } catch (IllegalArgumentException e) {
            // Assert
            // Exception is expected, so we can check the message if needed
            assert e.getMessage().contains("String");
            assert e.getMessage().contains("java.lang.Integer");
            return; // Exit the test successfully
        }
        // If we reach this point, the exception was not thrown
        assert false : "Expected IllegalArgumentException was not thrown.";
    }

}