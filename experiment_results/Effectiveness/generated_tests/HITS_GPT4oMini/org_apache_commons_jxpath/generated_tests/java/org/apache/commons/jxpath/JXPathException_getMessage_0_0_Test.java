package org.apache.commons.jxpath;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JXPathException_getMessage_0_0_Test {

    @Test
    public void testGetMessage_NoException() {
        JXPathException jxpathException = new JXPathException(new Throwable(""));
        assertEquals("", jxpathException.getMessage());
    }

    @Test
    public void testGetMessage_EmptyMessage() {
        Throwable cause = new Throwable();
        JXPathException jxpathException = new JXPathException(cause);
        assertEquals(cause.getClass().getName(), jxpathException.getMessage());
    }

    @Test
    public void testGetMessage_WithMessage() {
        Throwable cause = new Throwable("This is a cause message");
        JXPathException jxpathException = new JXPathException(cause);
        assertEquals("This is a cause message", jxpathException.getMessage());
    }

    @Test
    public void testGetMessage_WithMessageAndSuperMessage() {
        Throwable cause = new Throwable("This is a cause message");
        JXPathException jxpathException = new JXPathException(cause) {

            @Override
            public String getMessage() {
                return "Super message";
            }
        };
        assertEquals("Super message; This is a cause message", jxpathException.getMessage());
    }

    @Test
    public void testGetMessage_WithNullMessageAndException() {
        Throwable cause = new Throwable("");
        JXPathException jxpathException = new JXPathException(cause);
        assertEquals(cause.getClass().getName(), jxpathException.getMessage());
    }
}
