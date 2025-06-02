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

    private HttpServletRequest mockRequest;

    private ServletContext mockContext;

    private ServletRequestAndContext servletRequestAndContext;

    @BeforeEach
    public void setUp() {
        mockRequest = mock(HttpServletRequest.class);
        mockContext = mock(ServletContext.class);
        servletRequestAndContext = new ServletRequestAndContext(mockRequest, mockContext);
    }

    @Test
    public void testGetSession_WhenRequestIsHttpServletRequest_ReturnsSession() {
        HttpSession mockSession = mock(HttpSession.class);
        when(mockRequest.getSession(false)).thenReturn(mockSession);
        HttpSession result = servletRequestAndContext.getSession();
        assertEquals(mockSession, result);
        verify(mockRequest).getSession(false);
    }

    @Test
    public void testGetSession_WhenRequestIsNotHttpServletRequest_ReturnsNull() {
        ServletRequest mockNonHttpRequest = mock(ServletRequest.class);
        servletRequestAndContext = new ServletRequestAndContext(mockNonHttpRequest, mockContext);
        HttpSession result = servletRequestAndContext.getSession();
        assertNull(result);
    }
}
