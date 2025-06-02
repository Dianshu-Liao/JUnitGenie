package org.apache.commons.jxpath;

import org.apache.commons.jxpath.JXPathException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class JXPathException_getMessage_0_0_Test {

    @Test
    void testGetMessageWithNullException() {
        JXPathException exception = new JXPathException("Test message");
        String message = exception.getMessage();
        assertEquals("Test message", message);
    }

    @Test
    void testGetMessageWithExceptionMessage() {
        Throwable cause = new IllegalArgumentException("Illegal argument");
        JXPathException exception = new JXPathException(cause);
        String message = exception.getMessage();
        assertEquals("java.lang.IllegalArgumentException: Illegal argument", message);
    }

    @Test
    void testGetMessageWithNullCauseMessage() {
        Throwable cause = new NullPointerException();
        JXPathException exception = new JXPathException(cause);
        String message = exception.getMessage();
        assertEquals("java.lang.NullPointerException", message);
    }

    @Test
    void testGetMessageWithMessageAndException() {
        Throwable cause = new IllegalArgumentException("Illegal argument");
        JXPathException exception = new JXPathException("Test message", cause);
        String message = exception.getMessage();
        assertEquals("Test message; Illegal argument", message);
    }

    @Test
    void testGetMessageWithMessageAndNullCause() {
        JXPathException exception = new JXPathException("Test message", null);
        String message = exception.getMessage();
        assertEquals("Test message", message);
    }
}
