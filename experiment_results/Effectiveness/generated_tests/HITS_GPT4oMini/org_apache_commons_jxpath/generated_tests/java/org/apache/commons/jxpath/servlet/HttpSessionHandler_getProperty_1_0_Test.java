package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Enumeration;
import java.util.HashSet;
import org.apache.commons.jxpath.JXPathException;

public class HttpSessionHandler_getProperty_1_0_Test {

    private HttpSessionHandler httpSessionHandler;

    private HttpSession mockSession;

    private ServletContext mockContext;

    private HttpSessionAndServletContext mockSessionContext;

    @BeforeEach
    public void setUp() {
        httpSessionHandler = new HttpSessionHandler();
        mockSession = Mockito.mock(HttpSession.class);
        mockContext = Mockito.mock(ServletContext.class);
        mockSessionContext = new HttpSessionAndServletContext(mockSession, mockContext);
    }

    @Test
    public void testGetPropertyFromSession() {
        String propertyName = "testProperty";
        String expectedValue = "testValue";
        when(mockSession.getAttribute(propertyName)).thenReturn(expectedValue);
        Object result = httpSessionHandler.getProperty(mockSessionContext, propertyName);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testGetPropertyFromContextWhenSessionIsNull() {
        String propertyName = "testProperty";
        String expectedValue = "contextValue";
        when(mockSession.getAttribute(propertyName)).thenReturn(null);
        when(mockContext.getAttribute(propertyName)).thenReturn(expectedValue);
        Object result = httpSessionHandler.getProperty(mockSessionContext, propertyName);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testGetPropertyReturnsNullWhenNotFound() {
        String propertyName = "nonExistentProperty";
        when(mockSession.getAttribute(propertyName)).thenReturn(null);
        when(mockContext.getAttribute(propertyName)).thenReturn(null);
        Object result = httpSessionHandler.getProperty(mockSessionContext, propertyName);
        assertEquals(null, result);
    }
}
