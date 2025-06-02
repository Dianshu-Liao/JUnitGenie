package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        try {
            // Create an instance of JsonProcessingException with null location
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Test exception", null);
            
            // Call the getMessage method
            String result = exception.getMessage();
            
            // Verify the result
            assertEquals("N/A", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            
            // Create an instance of JsonProcessingException with location and a suffix
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Test exception", location);
            
            // Mock the getMessageSuffix method to return a suffix
            String suffix = " - additional info";
            exception = new JsonProcessingException("Test exception") {
                @Override
                public String getMessageSuffix() {
                    return suffix;
                }
            };
            
            // Call the getMessage method
            String result = exception.getMessage();
            
            // Verify the result
            assertEquals("Test exception - additional info", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}