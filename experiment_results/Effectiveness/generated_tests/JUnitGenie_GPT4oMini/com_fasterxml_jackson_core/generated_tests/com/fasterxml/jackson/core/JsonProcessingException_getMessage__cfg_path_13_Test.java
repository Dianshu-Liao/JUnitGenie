package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessageSuffixAndLocation() {
        try {
            // Create a JsonLocation instance (mock or real, depending on your testing framework)
            JsonLocation location = null; // This will simulate the absence of a location

            // Use reflection to create an instance of JsonProcessingException
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Test message", location);

            // Call the getMessage method
            String result = exception.getMessage();

            // Assert the expected output
            assertEquals("N/A", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNonNullMessageSuffixAndLocation() {
        try {
            // Create a JsonLocation instance (mock or real, depending on your testing framework)
            JsonLocation location = new JsonLocation(null, 0, 0, 0); // Simulating a valid location

            // Use reflection to create an instance of JsonProcessingException
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Test message", location);

            // Mock the getMessageSuffix method to return a non-null value
            // This requires a mocking framework like Mockito to be set up
            // For example: Mockito.when(exception.getMessageSuffix()).thenReturn(" - Suffix");

            // Call the getMessage method
            String result = exception.getMessage();

            // Assert the expected output
            assertEquals("Test message - Suffix\n at " + location.toString(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}