package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonProcessingException_getMessage_5_1_Test {

    @Test
    public void testGetMessage_NullMessage() {
        JsonProcessingException exception = new JsonProcessingException((String) null) {

            @Override
            protected String getMessageSuffix() {
                return null;
            }
        };
        String message = exception.getMessage();
        assertEquals("N/A", message);
    }

    @Test
    public void testGetMessage_EmptyMessage() {
        JsonProcessingException exception = new JsonProcessingException("") {

            @Override
            protected String getMessageSuffix() {
                return null;
            }
        };
        String message = exception.getMessage();
        assertEquals("", message);
    }

    @Test
    public void testGetMessage_WithSuffix() {
        JsonProcessingException exception = new JsonProcessingException("Error occurred") {

            @Override
            protected String getMessageSuffix() {
                return " - Additional Info";
            }
        };
        String message = exception.getMessage();
        assertEquals("Error occurred - Additional Info", message);
    }

    @Test
    public void testGetMessage_WithLocation() {
        JsonLocation location = new JsonLocation(null, 0, 1, 1);
        JsonProcessingException exception = new JsonProcessingException("Error occurred", location) {

            @Override
            protected String getMessageSuffix() {
                return null;
            }
        };
        String message = exception.getMessage();
        assertEquals("Error occurred\n at [Source: null; line: 1, column: 1]", message);
    }

    @Test
    public void testGetMessage_WithLocationAndSuffix() {
        JsonLocation location = new JsonLocation(null, 0, 1, 1);
        JsonProcessingException exception = new JsonProcessingException("Error occurred", location) {

            @Override
            protected String getMessageSuffix() {
                return " - Additional Info";
            }
        };
        String message = exception.getMessage();
        assertEquals("Error occurred - Additional Info\n at [Source: null; line: 1, column: 1]", message);
    }

    @Test
    public void testGetMessage_NoLocationOrSuffix() {
        JsonProcessingException exception = new JsonProcessingException("Error occurred") {

            @Override
            protected String getMessageSuffix() {
                return null;
            }
        };
        String message = exception.getMessage();
        assertEquals("Error occurred", message);
    }

    @Test
    public void testGetMessage_NullLocationAndSuffix() {
        JsonProcessingException exception = new JsonProcessingException("Error occurred") {

            @Override
            protected String getMessageSuffix() {
                return null;
            }
        };
        String message = exception.getMessage();
        assertEquals("Error occurred", message);
    }
}
