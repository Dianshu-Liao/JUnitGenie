// Test method
package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.jxpath.JXPathContext;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.apache.commons.jxpath.JXPathContextFactory;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JXPathServletContexts_getSessionContext_2_0_Test {

    private HttpSession session;

    private ServletContext servletContext;

    private JXPathContextFactory factoryMock;

    private JXPathContext jXPathContextMock;

    @BeforeEach
    public void setUp() {
        session = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        factoryMock = mock(JXPathContextFactory.class);
        jXPathContextMock = mock(JXPathContext.class);
        // Set the factory to the mocked instance
        try {
            Method setFactoryMethod = JXPathServletContexts.class.getDeclaredMethod("setFactory", JXPathContextFactory.class);
            setFactoryMethod.setAccessible(true);
            setFactoryMethod.invoke(null, factoryMock);
        } catch (Exception e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    @Test
    public void testGetSessionContext_CreatesNewContext() {
        when(session.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        JXPathContext parentContext = mock(JXPathContext.class);
        when(factoryMock.newContext(any(), any())).thenReturn(jXPathContextMock);
        // Corrected the buggy line to return void correctly
        doNothing().when(jXPathContextMock).setVariables(any());
        // Mock the getApplicationContext method using reflection
        try {
            Method getApplicationContextMethod = JXPathServletContexts.class.getDeclaredMethod("getApplicationContext", ServletContext.class);
            getApplicationContextMethod.setAccessible(true);
            when(getApplicationContextMethod.invoke(null, servletContext)).thenReturn(parentContext);
        } catch (Exception e) {
            fail("Setup failed: " + e.getMessage());
        }
        JXPathContext context = JXPathServletContexts.getSessionContext(session, servletContext);
        assertNotNull(context);
        assertEquals(jXPathContextMock, context);
        verify(session).setAttribute(Constants.JXPATH_CONTEXT, context);
    }

    @Test
    public void testGetSessionContext_ReturnsExistingContext() {
        when(session.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(jXPathContextMock);
        JXPathContext context = JXPathServletContexts.getSessionContext(session, servletContext);
        assertNotNull(context);
        assertEquals(jXPathContextMock, context);
        verify(session, never()).setAttribute(anyString(), any());
    }

    @Test
    public void testGetSessionContext_WithNullSession() {
        assertThrows(NullPointerException.class, () -> {
            JXPathServletContexts.getSessionContext(null, servletContext);
        });
    }

    @Test
    public void testGetSessionContext_WithNullServletContext() {
        assertThrows(NullPointerException.class, () -> {
            JXPathServletContexts.getSessionContext(session, null);
        });
    }
}
