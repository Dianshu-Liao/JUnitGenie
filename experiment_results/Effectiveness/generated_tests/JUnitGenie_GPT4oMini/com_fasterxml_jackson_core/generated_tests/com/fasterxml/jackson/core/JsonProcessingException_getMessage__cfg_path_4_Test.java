package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance with a valid source description
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            // Create an instance of JsonProcessingException using reflection
            JsonProcessingException exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Error occurred", location);
            
            // Mock the getMessageSuffix method to return a non-null string
            String suffix = " - additional info";
            // Use reflection to set the suffix
            java.lang.reflect.Method method = JsonProcessingException.class.getDeclaredMethod("getMessageSuffix");
            method.setAccessible(true);
            method.invoke(exception, suffix);
            
            // Call the getMessage method
            String message = exception.getMessage();
            
            // Validate the message
            String expectedMessage = "Error occurred - additional info\n at " + location.toString();
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}