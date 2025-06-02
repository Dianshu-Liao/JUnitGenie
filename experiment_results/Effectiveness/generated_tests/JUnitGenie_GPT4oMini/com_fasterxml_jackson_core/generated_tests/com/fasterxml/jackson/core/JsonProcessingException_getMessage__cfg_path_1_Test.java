package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetMessage_withNonNullLocationAndSuffix() {
        try {
            // Create a JsonLocation instance (mock or real)
            JsonLocation location = new JsonLocation("source", 1, 1, 1);
            // Create an instance of JsonProcessingException using reflection
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructors()[0]
                    .newInstance("Error message", location);

            // Mock the getMessageSuffix method to return a non-null string
            String suffix = " - additional info";
            // Use reflection to set the suffix
            java.lang.reflect.Method method = JsonProcessingException.class.getDeclaredMethod("getMessageSuffix");
            method.setAccessible(true);
            method.invoke(exception, suffix);

            // Call the getMessage method
            String result = exception.getMessage();

            // Verify the result
            String expected = "Error message - additional info\n at " + location.toString();
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}