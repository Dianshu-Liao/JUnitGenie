package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.ContentReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JsonProcessingException_getMessage_5_0_Test {

    private JsonProcessingException exceptionWithMessage;

    private JsonProcessingException exceptionWithNullMessage;

    private JsonProcessingException exceptionWithLocation;

    private JsonProcessingException exceptionWithLocationAndSuffix;

    private JsonLocation location;

    @BeforeEach
    public void setUp() {
        location = new JsonLocation(ContentReference.unknown(), 100L, 10L, 1, 1);
        exceptionWithMessage = new JsonProcessingException("Error occurred");
        exceptionWithNullMessage = new JsonProcessingException(null, (Throwable) null);
        exceptionWithLocation = new JsonProcessingException("Error occurred", location);
        exceptionWithLocationAndSuffix = new JsonProcessingException("Error occurred", location) {

            @Override
            protected String getMessageSuffix() {
                return " (additional info)";
            }
        };
    }

    @Test
    public void testGetMessage_withValidMessage() {
        assertEquals("Error occurred", exceptionWithMessage.getMessage());
    }

    @Test
    public void testGetMessage_withNullMessage() {
        assertEquals("N/A", exceptionWithNullMessage.getMessage());
    }

    @Test
    public void testGetMessage_withLocation() {
        String expectedMessage = "Error occurred\n at [Source: null; line: 1, column: 1]";
        assertEquals(expectedMessage, exceptionWithLocation.getMessage());
    }

    @Test
    public void testGetMessage_withLocationAndSuffix() {
        String expectedMessage = "Error occurred (additional info)\n at [Source: null; line: 1, column: 1]";
        assertEquals(expectedMessage, exceptionWithLocationAndSuffix.getMessage());
    }

    @Test
    public void testGetMessage_withLocationAndNoSuffix() {
        JsonProcessingException exception = new JsonProcessingException("Error occurred", location);
        String expectedMessage = "Error occurred\n at [Source: null; line: 1, column: 1]";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetMessage_withNullLocationAndSuffix() {
        JsonProcessingException exception = new JsonProcessingException("Error occurred", (Throwable) null) {

            @Override
            protected String getMessageSuffix() {
                return " (additional info)";
            }
        };
        String expectedMessage = "Error occurred (additional info)";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetMessage_withNullLocationAndNullMessage() {
        JsonProcessingException exception = new JsonProcessingException(null, (Throwable) null);
        assertEquals("N/A", exception.getMessage());
    }
}
