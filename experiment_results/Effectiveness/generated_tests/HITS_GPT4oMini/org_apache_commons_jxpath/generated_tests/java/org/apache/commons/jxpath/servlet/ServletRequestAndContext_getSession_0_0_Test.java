package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServletRequestAndContext_getSession_0_0_Test {

    private ServletRequest request;

    private ServletContext context;

    private ServletRequestAndContext servletRequestAndContext;

    @BeforeEach
    public void setUp() {
        context = mock(ServletContext.class);
        request = mock(ServletRequest.class);
        servletRequestAndContext = new ServletRequestAndContext(request, context);
    }

    @Test
    public void testGetSession_WhenRequestIsHttpServletRequest_ReturnsNull() {
        // Arrange
        HttpServletRequest httpRequest = mock(HttpServletRequest.class);
        when(request instanceof HttpServletRequest).thenReturn(true);
        servletRequestAndContext = new ServletRequestAndContext(httpRequest, context);
        // Act
        HttpSession session = servletRequestAndContext.getSession();
        // Assert
        assertNull(session);
    }

    @Test
    public void testGetSession_WhenRequestIsNotHttpServletRequest_ReturnsNull() {
        // Arrange
        // No need to change the request as it is already a ServletRequest
        // Act
        HttpSession session = servletRequestAndContext.getSession();
        // Assert
        assertNull(session);
    }
}
