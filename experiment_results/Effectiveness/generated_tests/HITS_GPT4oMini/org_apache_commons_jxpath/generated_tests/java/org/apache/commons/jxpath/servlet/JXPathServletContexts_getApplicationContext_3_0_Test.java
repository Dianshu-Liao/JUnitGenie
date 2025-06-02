package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import org.apache.commons.jxpath.JXPathContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContextFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import org.apache.commons.jxpath.JXPathIntrospector;

public class JXPathServletContexts_getApplicationContext_3_0_Test {

    private ServletContext servletContext;

    private JXPathContext jxPathContext;

    private JXPathContextFactory mockFactory;

    @BeforeEach
    public void setUp() {
        servletContext = mock(ServletContext.class);
        jxPathContext = mock(JXPathContext.class);
        mockFactory = mock(JXPathContextFactory.class);
        // Use reflection to set the factory if necessary, or adjust the implementation accordingly.
        // Example: JXPathServletContexts.setFactory(mockFactory); // Ensure this method exists.
    }

    @Test
    public void testGetApplicationContext_CreatesNewContext_WhenContextIsNull() {
        // Arrange
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(mockFactory.newContext(null, servletContext)).thenReturn(jxPathContext);
        // Act
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        // Assert
        assertNotNull(result);
        verify(servletContext).setAttribute(Constants.JXPATH_CONTEXT, result);
    }

    @Test
    public void testGetApplicationContext_ReturnsExistingContext_WhenContextIsNotNull() {
        // Arrange
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(jxPathContext);
        // Act
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        // Assert
        assertNotNull(result);
        verify(servletContext, never()).setAttribute(anyString(), any());
    }
}
