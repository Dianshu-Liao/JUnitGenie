package com.fasterxml.jackson.core;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.lang.reflect.Constructor;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonProcessingException_getMessage__cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance with a valid source description
            JsonLocation location = new JsonLocation("source", 1, 10, 1);

            // Use reflection to access the protected constructor
            Constructor<JsonProcessingException> constructor = JsonProcessingException.class.getDeclaredConstructor(String.class, JsonLocation.class);
            constructor.setAccessible(true);
            
            // Instantiate JsonProcessingException
            JsonProcessingException exception = constructor.newInstance("Error occurred", location);
            
            // Mock the getMessageSuffix method via subclass or proxy if necessary.
            // For simplicity, we will not override here since there's no allowed subclass
            String message = exception.getMessage();
            String expectedMessage = "Error occurred at " + location.toString();
            
            // Validate the message returned by getMessage
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testGetMessageWithNullLocationAndSuffix() {
        try {
            // Use reflection to access the protected constructor
            Constructor<JsonProcessingException> constructor = JsonProcessingException.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            
            // Instantiate JsonProcessingException with no location
            JsonProcessingException exception = constructor.newInstance("Single Error");
            
            // The actual value of suffix will remain null, using default suffix
            String message = exception.getMessage();
            String expectedMessage = "Single Error";
            
            // Validate the message returned by getMessage
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testGetMessageWhenNullMessage() {
        try {
            // Use reflection to access the protected constructor 
            Constructor<JsonProcessingException> constructor = JsonProcessingException.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            
            // Instantiate JsonProcessingException with null message
            JsonProcessingException exception = constructor.newInstance(null);
            
            // The method should return "N/A" since the message is null
            String message = exception.getMessage();
            String expectedMessage = "N/A";
            
            // Validate the message returned by getMessage
            assertEquals(expectedMessage, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}