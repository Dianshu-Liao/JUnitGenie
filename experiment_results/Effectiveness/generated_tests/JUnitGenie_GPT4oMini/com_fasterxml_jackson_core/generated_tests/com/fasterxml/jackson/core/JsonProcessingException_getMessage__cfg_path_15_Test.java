package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance (mock or real)
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            // Create an instance of JsonProcessingException with a message, location, and null throwable
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Error occurred", location);
            
            // Mock the getMessageSuffix method to return a suffix
            String suffix = " - additional info";
            // Use reflection to set the suffix in the exception
            java.lang.reflect.Field suffixField = JsonProcessingException.class.getDeclaredField("suffix");
            suffixField.setAccessible(true);
            suffixField.set(exception, suffix);
            
            // Call the getMessage method
            String message = exception.getMessage();
            
            // Expected message
            String expectedMessage = "Error occurred - additional info\n at " + location.toString();
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullLocationAndSuffix() {
        try {
            // Create an instance of JsonProcessingException with a message and null location
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class)
                    .newInstance("Error occurred");
            
            // Mock the getMessageSuffix method to return null
            String suffix = null;
            // Use reflection to set the suffix in the exception
            java.lang.reflect.Field suffixField = JsonProcessingException.class.getDeclaredField("suffix");
            suffixField.setAccessible(true);
            suffixField.set(exception, suffix);
            
            // Call the getMessage method
            String message = exception.getMessage();
            
            // Expected message
            String expectedMessage = "Error occurred";
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        try {
            // Create an instance of JsonProcessingException with null message and null location
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class)
                    .newInstance(null);
            
            // Call the getMessage method
            String message = exception.getMessage();
            
            // Expected message
            String expectedMessage = "N/A";
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}