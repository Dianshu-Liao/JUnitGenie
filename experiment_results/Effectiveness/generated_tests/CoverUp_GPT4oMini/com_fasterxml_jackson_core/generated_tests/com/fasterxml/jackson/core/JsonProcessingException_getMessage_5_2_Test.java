package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JsonProcessingException_getMessage_5_2_Test {

    @Test
    public void testGetMessage_NullMessage() throws Exception {
        // Create an instance with a null message
        JsonProcessingException exception = createException(null, null);
        // Invoke the getMessage() method
        String message = invokeGetMessage(exception);
        // Assert the expected output
        assertEquals("N/A", message);
    }

    @Test
    public void testGetMessage_EmptyMessage() throws Exception {
        // Create an instance with an empty message
        JsonProcessingException exception = createException("", null);
        // Invoke the getMessage() method
        String message = invokeGetMessage(exception);
        // Assert the expected output
        assertEquals("", message);
    }

    @Test
    public void testGetMessage_WithSuffix() throws Exception {
        // Create an instance with a message and a suffix
        JsonProcessingException exception = createException("Error occurred", null);
        setMessageSuffix(exception, " - Additional Info");
        // Invoke the getMessage() method
        String message = invokeGetMessage(exception);
        // Assert the expected output
        assertEquals("Error occurred - Additional Info", message);
    }

    @Test
    public void testGetMessage_WithLocation() throws Exception {
        // Create a JsonLocation instance
        JsonLocation location = new JsonLocation(null, 0, 1, 1);
        // Create an instance with a message and a location
        JsonProcessingException exception = createException("Error occurred", location);
        // Invoke the getMessage() method
        String message = invokeGetMessage(exception);
        // Assert the expected output
        assertEquals("Error occurred\n at [Source: null; ]", message);
    }

    @Test
    public void testGetMessage_WithSuffixAndLocation() throws Exception {
        // Create a JsonLocation instance
        JsonLocation location = new JsonLocation(null, 0, 1, 1);
        // Create an instance with a message, a location, and a suffix
        JsonProcessingException exception = createException("Error occurred", location);
        setMessageSuffix(exception, " - Additional Info");
        // Invoke the getMessage() method
        String message = invokeGetMessage(exception);
        // Assert the expected output
        assertEquals("Error occurred - Additional Info\n at [Source: null; ]", message);
    }

    private JsonProcessingException createException(String msg, JsonLocation loc) throws Exception {
        Constructor<JsonProcessingException> constructor = JsonProcessingException.class.getDeclaredConstructor(String.class, JsonLocation.class);
        constructor.setAccessible(true);
        return constructor.newInstance(msg, loc);
    }

    private String invokeGetMessage(JsonProcessingException exception) throws Exception {
        Method method = JsonProcessingException.class.getDeclaredMethod("getMessage");
        method.setAccessible(true);
        return (String) method.invoke(exception);
    }

    private void setMessageSuffix(JsonProcessingException exception, String suffix) throws Exception {
        Method method = JsonProcessingException.class.getDeclaredMethod("getMessageSuffix");
        method.setAccessible(true);
        method.invoke(exception, suffix);
    }
}
