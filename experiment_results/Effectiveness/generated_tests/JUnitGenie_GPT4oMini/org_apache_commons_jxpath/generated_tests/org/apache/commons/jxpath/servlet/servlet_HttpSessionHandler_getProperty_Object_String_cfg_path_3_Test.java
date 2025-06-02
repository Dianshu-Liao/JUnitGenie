package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.servlet.HttpSessionHandler;
import org.apache.commons.jxpath.servlet.HttpSessionAndServletContext;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class servlet_HttpSessionHandler_getProperty_Object_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetProperty() {
        // Arrange
        HttpSessionHandler handler = new HttpSessionHandler();
        HttpSessionAndServletContext mockBean = mock(HttpSessionAndServletContext.class);
        HttpSession mockSession = mock(HttpSession.class);
        String property = "testAttribute";
        Object expectedValue = "testValue";

        // Setup mock behavior
        when(mockBean.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute(property)).thenReturn(expectedValue);

        // Act
        Object result = handler.getProperty(mockBean, property);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test(timeout = 4000)
    public void testGetProperty_sessionIsNull() {
        // Arrange
        HttpSessionHandler handler = new HttpSessionHandler();
        HttpSessionAndServletContext mockBean = mock(HttpSessionAndServletContext.class);
        String property = "testAttribute";

        // Setup mock behavior
        when(mockBean.getSession()).thenReturn(null);

        // Act
        Object result = handler.getProperty(mockBean, property);

        // Assert
        assertNotNull(result);
        // Additional assertions should be placed here for the value returned when session is null
    }

    @Test(timeout = 4000)
    public void testGetProperty_noAttributeFound() {
        // Arrange
        HttpSessionHandler handler = new HttpSessionHandler();
        HttpSessionAndServletContext mockBean = mock(HttpSessionAndServletContext.class);
        HttpSession mockSession = mock(HttpSession.class);
        String property = "nonExistentAttribute";

        // Setup mock behavior
        when(mockBean.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute(property)).thenReturn(null);

        // Act
        Object result = handler.getProperty(mockBean, property);

        // Assert
        assertNotNull(result);
        // Additional assertions should be placed here for the expected fallback behavior
    }

}