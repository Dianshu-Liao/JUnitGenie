package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance with valid parameters
            JsonLocation location = new JsonLocation(new Object(), 1L, 1, 1);
            // Create an instance of JsonProcessingException with a non-null location
            JsonProcessingException exception = new JsonProcessingException("Error occurred", location) {};

            // Mock the getMessageSuffix method to return a non-null suffix
            String suffix = " - additional info";
            exception = new JsonProcessingException("Error occurred", location) {
                @Override
                public String getMessageSuffix() {
                    return suffix;
                }
            };

            // Call the getMessage method
            String message = exception.getMessage();

            // Verify the message contains the suffix and location
            String expectedMessage = "Error occurred - additional info\n at sourceDescription";
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullLocationAndSuffix() {
        try {
            // Create an instance of JsonProcessingException with a null location
            JsonProcessingException exception = new JsonProcessingException("Error occurred") {};

            // Mock the getMessageSuffix method to return a non-null suffix
            String suffix = " - additional info";
            exception = new JsonProcessingException("Error occurred") {
                @Override
                public String getMessageSuffix() {
                    return suffix;
                }
            };

            // Call the getMessage method
            String message = exception.getMessage();

            // Verify the message contains the suffix
            String expectedMessage = "Error occurred - additional info";
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullSuffix() {
        try {
            // Create a JsonLocation instance with valid parameters
            JsonLocation location = new JsonLocation(new Object(), 1L, 1, 1);
            // Create an instance of JsonProcessingException with a non-null location
            JsonProcessingException exception = new JsonProcessingException("Error occurred", location) {};

            // Mock the getMessageSuffix method to return null
            exception = new JsonProcessingException("Error occurred", location) {
                @Override
                public String getMessageSuffix() {
                    return null;
                }
            };

            // Call the getMessage method
            String message = exception.getMessage();

            // Verify the message contains the location
            String expectedMessage = "Error occurred\n at sourceDescription";
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}