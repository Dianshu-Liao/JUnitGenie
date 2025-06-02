package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.servlet.HttpSessionAndServletContext;
import org.apache.commons.jxpath.servlet.HttpSessionHandler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Enumeration;
import java.util.HashSet;

public class HttpSessionHandler_getProperty_1_0_Test {

    private HttpSessionHandler httpSessionHandler;

    private HttpSessionAndServletContext httpSessionAndServletContext;

    private HttpSession mockSession;

    private ServletContext mockContext;

    @BeforeEach
    public void setUp() {
        httpSessionHandler = new HttpSessionHandler();
        mockSession = mock(HttpSession.class);
        mockContext = mock(ServletContext.class);
        httpSessionAndServletContext = new HttpSessionAndServletContext(mockSession, mockContext);
    }

    @Test
    public void testGetProperty_WithSessionAttribute() {
        String propertyName = "testAttribute";
        Object expectedValue = "testValue";
        when(mockSession.getAttribute(propertyName)).thenReturn(expectedValue);
        Object result = httpSessionHandler.getProperty(httpSessionAndServletContext, propertyName);
        assertEquals(expectedValue, result);
        verify(mockSession).getAttribute(propertyName);
    }

    @Test
    public void testGetProperty_WithoutSessionAttribute() {
        String propertyName = "nonExistentAttribute";
        when(mockSession.getAttribute(propertyName)).thenReturn(null);
        when(mockContext.getAttribute(propertyName)).thenReturn("contextValue");
        Object result = httpSessionHandler.getProperty(httpSessionAndServletContext, propertyName);
        assertEquals("contextValue", result);
        verify(mockSession).getAttribute(propertyName);
        verify(mockContext).getAttribute(propertyName);
    }

    @Test
    public void testGetProperty_NullSession() {
        when(mockSession.getAttribute(anyString())).thenReturn(null);
        when(mockContext.getAttribute(anyString())).thenReturn(null);
        setSessionToNull(httpSessionAndServletContext);
        Object result = httpSessionHandler.getProperty(httpSessionAndServletContext, "anyAttribute");
        assertNull(result);
        verify(mockSession, never()).getAttribute(anyString());
        verify(mockContext, never()).getAttribute(anyString());
    }

    @Test
    public void testGetProperty_NullBean() {
        assertThrows(ClassCastException.class, () -> {
            httpSessionHandler.getProperty(null, "property");
        });
    }

    @Test
    public void testGetProperty_NullProperty() {
        assertThrows(NullPointerException.class, () -> {
            httpSessionHandler.getProperty(httpSessionAndServletContext, null);
        });
    }

    private void setSessionToNull(HttpSessionAndServletContext context) {
        try {
            Method method = HttpSessionAndServletContext.class.getDeclaredMethod("getSession");
            method.setAccessible(true);
            method.invoke(context);
        } catch (Exception e) {
            fail("Failed to set session to null", e);
        }
    }
}
