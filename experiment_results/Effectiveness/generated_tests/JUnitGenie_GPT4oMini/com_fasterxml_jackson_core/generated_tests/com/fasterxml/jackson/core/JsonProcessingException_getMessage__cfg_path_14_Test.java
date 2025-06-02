package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Constructor;

public class JsonProcessingException_getMessage__cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffix() {
        try {
            // Create a JsonLocation instance (mock or real)
            JsonLocation location = new JsonLocation(null, 0, 0, 0);
            String suffix = "Error occurred";

            // Use reflection to access the protected constructor
            Constructor<JsonProcessingException> constructor = JsonProcessingException.class.getDeclaredConstructor(String.class, JsonLocation.class);
            constructor.setAccessible(true);
            JsonProcessingException exception = constructor.newInstance("Test message", location);

            // Mock the getMessageSuffix method to return a non-null value
            String messageSuffix = exception.getMessageSuffix();
            assertEquals(null, messageSuffix); // Ensure it returns null initially

            // Call the method under test
            String result = exception.getMessage();

            // Verify the result
            String expectedMessage = "Test message" + messageSuffix + "\n at " + location.toString();
            assertEquals(expectedMessage, result);
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
            JsonProcessingException exception = constructor.newInstance("Test message");

            // Call the method under test
            String result = exception.getMessage();

            // Verify the result
            assertEquals("Test message", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        try {
            // Use reflection to access the protected constructor
            Constructor<JsonProcessingException> constructor = JsonProcessingException.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            JsonProcessingException exception = constructor.newInstance(null);

            // Call the method under test
            String result = exception.getMessage();

            // Verify the result
            assertEquals("N/A", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}