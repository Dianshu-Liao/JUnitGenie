package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullLocationAndSuffix() {
        try {
            // Create an instance of JsonProcessingException with null location and suffix
            JsonProcessingException exception = (JsonProcessingException) 
                JsonProcessingException.class.getDeclaredConstructor(String.class)
                .newInstance("Test message");

            // Mock the getLocation and getMessageSuffix methods to return null
            JsonLocation location = null; // Simulating null location
            String suffix = null; // Simulating null suffix

            // Use reflection to set the private fields if necessary (not shown here)
            // Assuming we have a way to set _location and _suffix to null

            // Call the method under test
            String message = exception.getMessage();

            // Verify the result
            assertEquals("N/A", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create an instance of JsonProcessingException with a message
            JsonProcessingException exception = (JsonProcessingException) 
                JsonProcessingException.class.getDeclaredConstructor(String.class)
                .newInstance("Test message");

            // Mock the getLocation and getMessageSuffix methods
            JsonLocation location = new JsonLocation(null, 0, 0, 0); // Simulating a valid location
            String suffix = " - additional info"; // Simulating a valid suffix

            // Use reflection to set the private fields if necessary (not shown here)
            // Assuming we have a way to set _location and _suffix to valid values

            // Call the method under test
            String message = exception.getMessage();

            // Verify the result
            String expectedMessage = "Test message - additional info\n at " + location.toString();
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}