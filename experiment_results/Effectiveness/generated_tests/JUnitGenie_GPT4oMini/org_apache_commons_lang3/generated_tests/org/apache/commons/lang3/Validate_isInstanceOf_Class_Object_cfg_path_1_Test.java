package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Validate_isInstanceOf_Class_Object_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testIsInstanceOfThrowsException() {
        Class<?> type = String.class; // The expected type
        Object obj = new Integer(123); // An object of a different type to trigger the exception

        try {
            Validate.isInstanceOf(type, obj);
        } catch (IllegalArgumentException e) {
            // Exception is expected, we can assert the message if needed
            String expectedMessage = "Expected type: java.lang.String, actual: java.lang.Integer";
            assertEquals(expectedMessage, e.getMessage());
            throw e; // Rethrow to satisfy the expected exception in the test
        }
    }


}