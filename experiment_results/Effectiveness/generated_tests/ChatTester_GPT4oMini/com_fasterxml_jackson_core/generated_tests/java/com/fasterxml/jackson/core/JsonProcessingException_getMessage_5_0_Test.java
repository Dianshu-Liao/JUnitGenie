package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonLocation;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class JsonProcessingException_getMessage_5_0_Test {

    private JsonProcessingException exception;

    @BeforeEach
    public void setUp() {
        exception = new JsonProcessingException("Test message");
    }

    @Test
    public void testGetMessage_WithMessage() {
        String message = exception.getMessage();
        assertEquals("Test message", message);
    }

    @Test
    public void testGetMessage_WithNullMessage() throws Exception {
        // Using reflection to set the message to null
        Method setMessageMethod = JsonProcessingException.class.getDeclaredMethod("setMessage", String.class);
        setMessageMethod.setAccessible(true);
        setMessageMethod.invoke(exception, (String) null);
        String message = exception.getMessage();
        assertEquals("N/A", message);
    }

    @Test
    public void testGetMessage_WithLocationAndSuffix() throws Exception {
        // Assuming we can set _location and suffix through reflection
        Method setLocationMethod = JsonProcessingException.class.getDeclaredMethod("setLocation", JsonLocation.class);
        setLocationMethod.setAccessible(true);
        // Create a valid JsonLocation instance
        JsonLocation location = new JsonLocation("source", 0, 0, 0);
        setLocationMethod.invoke(exception, location);
        Method setMessageSuffixMethod = JsonProcessingException.class.getDeclaredMethod("setMessageSuffix", String.class);
        setMessageSuffixMethod.setAccessible(true);
        setMessageSuffixMethod.invoke(exception, " - Suffix");
        String message = exception.getMessage();
        assertEquals("Test message - Suffix\n at " + location.toString(), message);
    }

    @Test
    public void testGetMessage_WithLocationOnly() throws Exception {
        // Assuming we can set _location through reflection
        Method setLocationMethod = JsonProcessingException.class.getDeclaredMethod("setLocation", JsonLocation.class);
        setLocationMethod.setAccessible(true);
        // Create a valid JsonLocation instance
        JsonLocation location = new JsonLocation("source", 0, 0, 0);
        setLocationMethod.invoke(exception, location);
        String message = exception.getMessage();
        assertEquals("Test message\n at " + location.toString(), message);
    }

    @Test
    public void testGetMessage_WithSuffixOnly() throws Exception {
        // Assuming we can set suffix through reflection
        Method setMessageSuffixMethod = JsonProcessingException.class.getDeclaredMethod("setMessageSuffix", String.class);
        setMessageSuffixMethod.setAccessible(true);
        setMessageSuffixMethod.invoke(exception, " - Suffix");
        String message = exception.getMessage();
        assertEquals("Test message - Suffix", message);
    }

    @Test
    public void testGetMessage_WithEmptyMessage() throws Exception {
        // Using reflection to set the message to an empty string
        Method setMessageMethod = JsonProcessingException.class.getDeclaredMethod("setMessage", String.class);
        setMessageMethod.setAccessible(true);
        setMessageMethod.invoke(exception, "");
        String message = exception.getMessage();
        // Expecting just the location part
        assertEquals("\n", message);
    }
}
