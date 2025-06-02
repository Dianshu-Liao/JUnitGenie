package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        try {
            // Create a JsonLocation instance with a non-null source description
            JsonLocation location = new JsonLocation("source", 0, 0, 0);
            // Create an instance of JsonProcessingException with a null message
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance(null, location);
            // Call the getMessage method
            String result = exception.getMessage();
            // Verify the result
            assertEquals("N/A\n at source", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNonNullMessage() {
        try {
            // Create a JsonLocation instance with a non-null source description
            JsonLocation location = new JsonLocation("source", 0, 0, 0);
            // Create an instance of JsonProcessingException with a non-null message
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Error occurred", location);
            // Call the getMessage method
            String result = exception.getMessage();
            // Verify the result
            assertEquals("Error occurred\n at source", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}