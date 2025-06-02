package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithLocationAndSuffixNull() {
        // Creating an instance of JsonProcessingException with _location as null
        JsonProcessingException exception = null;
        try {
            // Using reflection to invoke the protected constructor
            exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Test message", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testing the getMessage()
        String message = exception.getMessage();
        assertEquals("N/A", message);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithLocationNotNullAndSuffixNull() {
        // Creating a JsonLocation to pass
        JsonLocation location = new JsonLocation("", 0, 0, 0);
        
        // Creating an instance of JsonProcessingException with the location
        JsonProcessingException exception = null;
        try {
            // Using reflection to invoke the protected constructor
            exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class, JsonLocation.class)
                    .newInstance("Test message", location);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testing the getMessage()
        String message = exception.getMessage();
        assertEquals("Test message\n at " + location.toString(), message);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithLocationNullAndSuffixNotNull() {
        // Creating an instance of JsonProcessingException with the suffix set
        JsonProcessingException exception = null;
        try {
            // Using reflection to invoke the protected constructor
            exception = (JsonProcessingException) JsonProcessingException.class
                    .getDeclaredConstructor(String.class)
                    .newInstance("Test message");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mocking the getMessageSuffix() to return a non-null value
        String suffix = " - Suffix";
        try {
            java.lang.reflect.Method method = JsonProcessingException.class.getDeclaredMethod("getMessageSuffix");
            method.setAccessible(true);
            method.invoke(exception); // Must return the mocked suffix
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testing the getMessage()
        String message = exception.getMessage();
        assertEquals("Test message" + suffix, message);
    }

}