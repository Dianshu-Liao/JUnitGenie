package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetMessage() {
        // Create an instance of JsonProcessingException using reflection
        JsonProcessingException exception = null;
        JsonLocation location = null; // Declare location here to make it accessible
        try {
            // Create a valid JsonLocation
            location = new JsonLocation(null, 0, 0, 0);
            // Use reflection to invoke the constructor
            java.lang.reflect.Constructor<JsonProcessingException> constructor =
                    JsonProcessingException.class.getDeclaredConstructor(String.class, JsonLocation.class);
            constructor.setAccessible(true);
            exception = constructor.newInstance("Test error message", location);
        } catch (Exception e) {
            // Handle the exception if constructor invocation fails
            e.printStackTrace();
        }
        
        // Calling getMessage method
        String result = exception.getMessage();
        
        // Check if the message is formatted correctly
        String expectedMessage = "Test error message at " + location.toString();
        assertEquals(expectedMessage, result);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullLocationAndSuffix() {
        // Create an instance of JsonProcessingException using reflection
        JsonProcessingException exception = null;
        try {
            // Use reflection to invoke the constructor with a message
            java.lang.reflect.Constructor<JsonProcessingException> constructor =
                    JsonProcessingException.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            exception = constructor.newInstance("Test error message");
        } catch (Exception e) {
            // Handle the exception if constructor invocation fails
            e.printStackTrace();
        }

        // Calling getMessage method
        String result = exception.getMessage();

        // Check the expected output
        assertEquals("Test error message", result);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        // Create an instance of JsonProcessingException using reflection
        JsonProcessingException exception = null;
        try {
            // Use reflection to invoke the constructor with a null message
            java.lang.reflect.Constructor<JsonProcessingException> constructor =
                    JsonProcessingException.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            exception = constructor.newInstance((String) null); // Cast to String to suppress warning
        } catch (Exception e) {
            // Handle the exception if constructor invocation fails
            e.printStackTrace();
        }

        // Calling getMessage method
        String result = exception.getMessage();

        // Check the expected output when the internal message is null
        assertEquals("N/A", result);
    }


}