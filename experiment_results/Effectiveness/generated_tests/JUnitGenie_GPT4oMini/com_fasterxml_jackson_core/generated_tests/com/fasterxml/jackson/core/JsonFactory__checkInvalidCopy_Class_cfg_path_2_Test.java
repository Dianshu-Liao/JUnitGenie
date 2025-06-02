package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class JsonFactory__checkInvalidCopy_Class_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckInvalidCopy_Success() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        Class<?> expectedClass = JsonFactory.class;

        // Act
        try {
            invokeCheckInvalidCopy(jsonFactory, expectedClass);
            // If no exception is thrown, test should pass.
        } catch (IllegalAccessException e) {
            fail("IllegalAccessException should not have been thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCheckInvalidCopy_ThrowsException() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        Class<?> expectedClass = String.class; // Deliberately using a class that does not match.

        // Act
        try {
            invokeCheckInvalidCopy(jsonFactory, expectedClass);
            fail("Expected IllegalStateException was not thrown.");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (IllegalAccessException e) {
            fail("Unexpected IllegalAccessException was thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getMessage());
        }
    }

    private void invokeCheckInvalidCopy(JsonFactory jsonFactory, Class<?> expectedClass) 
            throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("_checkInvalidCopy", Class.class);
        method.setAccessible(true); // Make the protected method accessible
        method.invoke(jsonFactory, expectedClass);
    }


}