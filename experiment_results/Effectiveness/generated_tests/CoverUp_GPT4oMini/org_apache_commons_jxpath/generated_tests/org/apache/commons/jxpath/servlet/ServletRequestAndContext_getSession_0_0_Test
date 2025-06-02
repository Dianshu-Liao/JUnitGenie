package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class ServletRequestAndContext_getSession_0_0_Test {

    private ServletRequest request;

    private ServletContext context;

    private HttpServletRequest httpRequest;

    private ServletRequestAndContext servletRequestAndContext;

    @BeforeEach
    public void setUp() {
        context = mock(ServletContext.class);
    }

    @Test
    public void testGetSession_WithHttpServletRequest_ReturnsSession() {
        // Arrange
        httpRequest = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(httpRequest.getSession(false)).thenReturn(session);
        servletRequestAndContext = new ServletRequestAndContext(httpRequest, context);
        // Act
        HttpSession result = servletRequestAndContext.getSession();
        // Assert
        assertNotNull(result);
    }

    @Test
    public void testGetSession_WithHttpServletRequest_ReturnsNullWhenNoSession() {
        // Arrange
        httpRequest = mock(HttpServletRequest.class);
        when(httpRequest.getSession(false)).thenReturn(null);
        servletRequestAndContext = new ServletRequestAndContext(httpRequest, context);
        // Act
        HttpSession result = servletRequestAndContext.getSession();
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetSession_WithNonHttpServletRequest_ReturnsNull() {
        // Arrange
        request = mock(ServletRequest.class);
        servletRequestAndContext = new ServletRequestAndContext(request, context);
        // Act
        HttpSession result = servletRequestAndContext.getSession();
        // Assert
        assertNull(result);
    }
}
