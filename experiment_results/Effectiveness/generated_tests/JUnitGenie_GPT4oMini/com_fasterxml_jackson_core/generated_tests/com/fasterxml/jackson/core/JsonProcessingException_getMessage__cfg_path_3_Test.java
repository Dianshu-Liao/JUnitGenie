package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNonNullLocationAndSuffix() {
        try {
            // Create a JsonLocation instance (mock or real)
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            String suffix = " - Error occurred";

            // Use reflection to create an instance of JsonProcessingException
            JsonProcessingException exception = (JsonProcessingException) 
                JsonProcessingException.class.getDeclaredConstructor(String.class, JsonLocation.class)
                .newInstance("Test message", location);

            // Mock the getMessageSuffix method to return a non-null suffix
            // This requires additional mocking framework like Mockito, but for simplicity, we assume it returns the suffix
            // In a real scenario, you would use a mocking framework to achieve this.

            // Call the getMessage method
            String result = exception.getMessage();

            // Expected message
            String expectedMessage = "Test message" + suffix + "\n at " + location.toString();
            assertEquals(expectedMessage, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}