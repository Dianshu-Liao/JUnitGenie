package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathContextFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JXPathServletContexts_getSessionContext_2_0_Test {

    private static JXPathContextFactory factory;

    @BeforeAll
    public static void setup() throws Exception {
        factory = mock(JXPathContextFactory.class);
        setFactory(factory);
    }

    private static void setFactory(JXPathContextFactory factory) throws Exception {
        Field factoryField = JXPathServletContexts.class.getDeclaredField("factory");
        factoryField.setAccessible(true);
        factoryField.set(null, factory);
    }

    @Test
    public void testGetSessionContext_CreatesNewContext() {
        HttpSession session = mock(HttpSession.class);
        ServletContext servletContext = mock(ServletContext.class);
        JXPathContext parentContext = mock(JXPathContext.class);
        JXPathContext newContext = mock(JXPathContext.class);
        HttpSessionAndServletContext handle = new HttpSessionAndServletContext(session, servletContext);
        when(session.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(JXPathServletContexts.getApplicationContext(servletContext)).thenReturn(parentContext);
        when(factory.newContext(parentContext, handle)).thenReturn(newContext);
        JXPathContext context = JXPathServletContexts.getSessionContext(session, servletContext);
        assertNotNull(context);
        verify(session).setAttribute(Constants.JXPATH_CONTEXT, context);
        verify(newContext).setVariables(any(KeywordVariables.class));
    }

    @Test
    public void testGetSessionContext_ReturnsExistingContext() {
        HttpSession session = mock(HttpSession.class);
        ServletContext servletContext = mock(ServletContext.class);
        JXPathContext existingContext = mock(JXPathContext.class);
        when(session.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(existingContext);
        JXPathContext context = JXPathServletContexts.getSessionContext(session, servletContext);
        assertEquals(existingContext, context);
        verify(session, never()).setAttribute(anyString(), any());
    }

    @Test
    public void testGetSessionContext_HandlesNullSession() {
        ServletContext servletContext = mock(ServletContext.class);
        assertThrows(NullPointerException.class, () -> {
            JXPathServletContexts.getSessionContext(null, servletContext);
        });
    }

    @Test
    public void testGetSessionContext_HandlesNullServletContext() {
        HttpSession session = mock(HttpSession.class);
        assertThrows(NullPointerException.class, () -> {
            JXPathServletContexts.getSessionContext(session, null);
        });
    }
}
