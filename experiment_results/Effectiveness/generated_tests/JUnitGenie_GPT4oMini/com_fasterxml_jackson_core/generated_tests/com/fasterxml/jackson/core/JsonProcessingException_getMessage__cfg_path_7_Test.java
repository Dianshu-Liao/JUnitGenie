package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonProcessingException_getMessage__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetMessage_NonNullLocationAndSuffix() {
        // Creating a JsonLocation instance
        JsonLocation location = new JsonLocation("source", 1, 1, 1);

        // Creating an instance of JsonProcessingException using reflection
        JsonProcessingException exception = createJsonProcessingException("Error occurred", location, null);

        // Simulating the message suffix method to return a non-null value
        String expectedSuffix = " (additional info)";
        setMessageSuffix(exception, expectedSuffix);

        // Executing the method we're testing
        String actualMessage = exception.getMessage();

        // Preparing the expected message output
        String expectedMessage = "Error occurred (additional info)\n at " + location.toString();

        // Asserting that the actual message matches the expected message
        assertEquals(expectedMessage, actualMessage);
    }

    private JsonProcessingException createJsonProcessingException(String message, JsonLocation location, Throwable cause) {
        try {
            return (JsonProcessingException) JsonProcessingException.class
                .getDeclaredConstructor(String.class, JsonLocation.class, Throwable.class)
                .newInstance(message, location, cause);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setMessageSuffix(JsonProcessingException exception, String suffix) {
        try {
            java.lang.reflect.Field suffixField = JsonProcessingException.class.getDeclaredField("_messageSuffix");
            suffixField.setAccessible(true);
            suffixField.set(exception, suffix);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}