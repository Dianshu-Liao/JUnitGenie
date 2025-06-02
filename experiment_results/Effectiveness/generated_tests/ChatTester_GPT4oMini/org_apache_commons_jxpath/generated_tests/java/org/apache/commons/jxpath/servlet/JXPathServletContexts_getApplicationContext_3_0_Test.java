package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
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
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathContextFactory;
import org.apache.commons.jxpath.JXPathIntrospector;

public class JXPathServletContexts_getApplicationContext_3_0_Test {

    @Mock
    private ServletContext servletContext;

    @Mock
    private JXPathContextFactory factory;

    @Mock
    private JXPathContext jXPathContext;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        JXPathServletContexts.class.getDeclaredField("factory").set(null, factory);
    }

    @Test
    public void testGetApplicationContext_WhenContextIsNull_CreatesNewContext() {
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(factory.newContext(null, servletContext)).thenReturn(jXPathContext);
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        assertNotNull(result);
        assertEquals(jXPathContext, result);
        verify(servletContext).setAttribute(Constants.JXPATH_CONTEXT, jXPathContext);
    }

    @Test
    public void testGetApplicationContext_WhenContextExists_ReturnsExistingContext() {
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(jXPathContext);
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        assertNotNull(result);
        assertEquals(jXPathContext, result);
        verify(servletContext, never()).setAttribute(anyString(), any());
    }

    @Test
    public void testGetApplicationContext_SetsVariables() {
        when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(factory.newContext(null, servletContext)).thenReturn(jXPathContext);
        JXPathContext result = JXPathServletContexts.getApplicationContext(servletContext);
        assertNotNull(result);
        verify(jXPathContext).setVariables(any(KeywordVariables.class));
    }
}
