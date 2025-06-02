package org.apache.commons.jxpath.servlet;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
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

    private HttpSessionAndServletContext mockBean;

    private HttpSession mockSession;

    private ServletContext mockServletContext;

    @BeforeEach
    public void setUp() {
        httpSessionHandler = new HttpSessionHandler();
        mockBean = mock(HttpSessionAndServletContext.class);
        mockSession = mock(HttpSession.class);
        mockServletContext = mock(ServletContext.class);
    }

    @Test
    public void testGetProperty_SessionHasAttribute() {
        String property = "testProperty";
        String expectedValue = "testValue";
        when(mockBean.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute(property)).thenReturn(expectedValue);
        Object result = httpSessionHandler.getProperty(mockBean, property);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testGetProperty_SessionIsNull() {
        String property = "testProperty";
        when(mockBean.getSession()).thenReturn(null);
        when(mockBean.getServletContext()).thenReturn(mockServletContext);
        when(httpSessionHandler.getProperty(mockServletContext, property)).thenReturn("defaultValue");
        Object result = httpSessionHandler.getProperty(mockBean, property);
        assertEquals("defaultValue", result);
        verify(mockBean).getServletContext();
    }

    @Test
    public void testGetProperty_SessionDoesNotHaveAttribute() {
        String property = "testProperty";
        when(mockBean.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute(property)).thenReturn(null);
        when(mockBean.getServletContext()).thenReturn(mockServletContext);
        when(httpSessionHandler.getProperty(mockServletContext, property)).thenReturn("defaultValue");
        Object result = httpSessionHandler.getProperty(mockBean, property);
        assertEquals("defaultValue", result);
        verify(mockSession).getAttribute(property);
        verify(mockBean).getServletContext();
    }
}
