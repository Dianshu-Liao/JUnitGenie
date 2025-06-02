package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathContextFactory;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

public class JXPathServletContexts_getSessionContext_2_0_Test {

    private HttpSession mockSession;

    private ServletContext mockServletContext;

    private JXPathContext mockJXPathContext;

    private JXPathContextFactory mockFactory;

    @BeforeEach
    public void setUp() throws Exception {
        mockSession = Mockito.mock(HttpSession.class);
        mockServletContext = Mockito.mock(ServletContext.class);
        mockJXPathContext = Mockito.mock(JXPathContext.class);
        mockFactory = Mockito.mock(JXPathContextFactory.class);
        // Set the factory to the mock using reflection
        Field factoryField = JXPathServletContexts.class.getDeclaredField("factory");
        factoryField.setAccessible(true);
        factoryField.set(null, mockFactory);
    }

    @Test
    public void testGetSessionContext_CreatesNewContext() {
        when(mockSession.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(mockFactory.newContext(any(), any())).thenReturn(mockJXPathContext);
        when(mockServletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        JXPathContext context = JXPathServletContexts.getSessionContext(mockSession, mockServletContext);
        assertNotNull(context);
        verify(mockSession).setAttribute(eq(Constants.JXPATH_CONTEXT), eq(mockJXPathContext));
        verify(mockJXPathContext).setVariables(any(KeywordVariables.class));
    }

    @Test
    public void testGetSessionContext_ReturnsExistingContext() {
        when(mockSession.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(mockJXPathContext);
        JXPathContext context = JXPathServletContexts.getSessionContext(mockSession, mockServletContext);
        assertEquals(mockJXPathContext, context);
        verify(mockSession, never()).setAttribute(anyString(), any());
        verify(mockFactory, never()).newContext(any(), any());
    }

    @Test
    public void testGetSessionContext_CreatesParentContext() {
        when(mockSession.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(mockFactory.newContext(any(), any())).thenReturn(mockJXPathContext);
        when(mockServletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        JXPathContext parentContext = mock(JXPathContext.class);
        when(mockFactory.newContext(null, mockServletContext)).thenReturn(parentContext);
        when(mockServletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(parentContext);
        JXPathContext context = JXPathServletContexts.getSessionContext(mockSession, mockServletContext);
        assertNotNull(context);
        verify(mockFactory).newContext(eq(parentContext), any(HttpSessionAndServletContext.class));
    }
}
