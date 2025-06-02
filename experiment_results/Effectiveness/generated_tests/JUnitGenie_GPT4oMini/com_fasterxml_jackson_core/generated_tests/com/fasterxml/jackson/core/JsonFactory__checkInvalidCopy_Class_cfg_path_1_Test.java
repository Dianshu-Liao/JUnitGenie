package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import org.junit.Test;
import static org.junit.Assert.fail;

public class JsonFactory__checkInvalidCopy_Class_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCheckInvalidCopyThrowsException() {
        JsonFactory jsonFactory = new JsonFactory();
        Class<?> invalidClass = String.class; // Using a class that is not JsonFactory

        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = JsonFactory.class.getDeclaredMethod("_checkInvalidCopy", Class.class);
            method.setAccessible(true); // Make the method accessible

            method.invoke(jsonFactory, invalidClass); // Invoke the method with an invalid class
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
            // You can add assertions here to check the exception message if needed
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}