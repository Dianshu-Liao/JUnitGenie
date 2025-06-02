package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathContextFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import org.apache.commons.jxpath.JXPathIntrospector;

public class JXPathServletContexts_getApplicationContext_3_0_Test {

    private ServletContext servletContext;

    private JXPathContextFactory factory;

    private JXPathContext context;

    @BeforeEach
    public void setUp() {
        servletContext = mock(ServletContext.class);
        factory = mock(JXPathContextFactory.class);
        context = mock(JXPathContext.class);
        // Setting up the factory to return the mock context
        when(factory.newContext(null, servletContext)).thenReturn(context);
        // Access the private field using reflection
        try {
            java.lang.reflect.Field field = JXPathServletContexts.class.getDeclaredField("factory");
            field.setAccessible(true);
            field.set(null, factory);
        } catch (Exception e) {
            fail("Failed to set up factory: " + e.getMessage());
        }
    }

    @Test
    public void testGetApplicationContext_CreatesNewContext() {
        // Arrange
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        // Act
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        // Assert
        assertNotNull(result);
        verify(factory).newContext(null, servletContext);
        verify(context).setVariables(any());
        verify(servletContext).setAttribute(eq(Constants.JXPATH_CONTEXT), eq(context));
    }

    @Test
    public void testGetApplicationContext_ReturnsExistingContext() {
        // Arrange
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(context);
        // Act
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        // Assert
        assertEquals(context, result);
        verify(factory, never()).newContext(any(), any());
        verify(servletContext, never()).setAttribute(any(), any());
    }
}
