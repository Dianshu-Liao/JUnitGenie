package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_isInstanceOf_Class_Object_String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsInstanceOfThrowsIllegalArgumentException() {
        // Arrange
        Class<?> type = String.class; // Expecting a String type
        Object obj = new Integer(123); // Providing an Integer object
        String message = "Object is not of the expected type: %s";
        Object[] values = new Object[] { type.getName() };

        // Act & Assert
        try {
            Validate.isInstanceOf(type, obj, message, values);
        } catch (IllegalArgumentException e) {
            // Verify the exception message
            assert e.getMessage().equals("Object is not of the expected type: java.lang.String");
        }
    }

}