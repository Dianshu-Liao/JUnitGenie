package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        try {
            // Create a JsonProcessingException instance with a null message and a valid location
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance(null, location);
            
            // Mock the getMessageSuffix method to return null
            String message = exception.getMessage();
            assertEquals("N/A\n at " + location.toString(), message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNonNullMessage() {
        try {
            // Create a JsonProcessingException instance with a non-null message and a valid location
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Error occurred", location);
            
            // Mock the getMessageSuffix method to return null
            String message = exception.getMessage();
            assertEquals("Error occurred\n at " + location.toString(), message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}