package org.apache.commons.jxpath;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JXPathException_getMessage_0_0_Test {

    private JXPathException jXPathException;

    @BeforeEach
    public void setUp() {
        jXPathException = new JXPathException();
    }

    @Test
    public void testGetMessage_NoException() {
        // Test case where no exception is set
        String message = jXPathException.getMessage();
        assertNull(message, "Expected message to be null when no exception is set.");
    }

    @Test
    public void testGetMessage_ExceptionWithNullMessage() {
        // Test case where exception is set but its message is null
        Throwable throwable = new Throwable();
        jXPathException = new JXPathException(throwable);
        String message = jXPathException.getMessage();
        assertEquals("java.lang.Throwable", message, "Expected message to be the class name of the Throwable.");
    }

    @Test
    public void testGetMessage_ExceptionWithMessage() {
        // Test case where exception is set and it has a message
        Throwable throwable = new Throwable("This is an error message.");
        jXPathException = new JXPathException(throwable);
        String message = jXPathException.getMessage();
        assertEquals("This is an error message.", message, "Expected message to be the error message from the Throwable.");
    }

    @Test
    public void testGetMessage_ExceptionWithSuperMessage() {
        // Test case where exception is set and super message is not null
        Throwable throwable = new Throwable("This is an error message.");
        jXPathException = new JXPathException("Super message", throwable);
        String message = jXPathException.getMessage();
        assertEquals("Super message; This is an error message.", message, "Expected message to include super message and Throwable message.");
    }

    @Test
    public void testGetMessage_ExceptionWithSuperMessageAndNullExceptionMessage() {
        // Test case where exception is set with a super message and exception message is null
        Throwable throwable = new Throwable();
        jXPathException = new JXPathException("Super message", throwable);
        String message = jXPathException.getMessage();
        assertEquals("Super message; java.lang.Throwable", message, "Expected message to include super message and class name of the Throwable.");
    }
}
