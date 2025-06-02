package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance with a non-null _sourceDescription
            JsonLocation location = new JsonLocation("source", 1, 1, 1);
            // Create an instance of JsonProcessingException with a message and location
            JsonProcessingException exception = (JsonProcessingException) 
                JsonProcessingException.class.getDeclaredConstructor(String.class, JsonLocation.class)
                .newInstance("Error occurred", location);
            
            // Mock the getMessageSuffix method to return a non-null value
            String suffix = " - additional info";
            JsonProcessingException mockException = new JsonProcessingException("Error occurred", location) {
                @Override
                public String getMessageSuffix() {
                    return suffix;
                }
            };

            // Call the getMessage method
            String message = mockException.getMessage();

            // Expected message
            String expectedMessage = "Error occurred" + suffix + "\nat " + location.toString();
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullLocationAndSuffix() {
        try {
            // Create an instance of JsonProcessingException with a message
            JsonProcessingException exception = (JsonProcessingException) 
                JsonProcessingException.class.getDeclaredConstructor(String.class)
                .newInstance("Error occurred");

            // Mock the getMessageSuffix method to return null
            JsonProcessingException mockException = new JsonProcessingException("Error occurred") {
                @Override
                public String getMessageSuffix() {
                    return null;
                }
            };

            // Call the getMessage method
            String message = mockException.getMessage();

            // Expected message
            String expectedMessage = "Error occurred";
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}