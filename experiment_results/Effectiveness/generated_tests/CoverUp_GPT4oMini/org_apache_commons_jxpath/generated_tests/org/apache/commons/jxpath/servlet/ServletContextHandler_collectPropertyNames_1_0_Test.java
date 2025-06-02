package org.apache.commons.jxpath.servlet;

import org.apache.commons.jxpath.servlet.HttpSessionAndServletContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.DynamicPropertyHandler;

class ServletContextHandler_collectPropertyNames_1_0_Test {

    private ServletContextHandler handler;

    private ServletContext mockServletContext;

    private HttpSession mockHttpSession;

    private HttpSessionAndServletContext mockSessionAndContext;

    @BeforeEach
    void setUp() {
        handler = new ServletContextHandler();
        mockServletContext = mock(ServletContext.class);
        mockHttpSession = mock(HttpSession.class);
        mockSessionAndContext = new HttpSessionAndServletContext(mockHttpSession, mockServletContext);
    }

    @Test
    void testCollectPropertyNames_WithServletContext() {
        HashSet<String> propertyNames = new HashSet<>();
        Enumeration<String> mockEnumeration = mock(Enumeration.class);
        when(mockServletContext.getAttributeNames()).thenReturn(mockEnumeration);
        when(mockEnumeration.hasMoreElements()).thenReturn(true, false);
        when(mockEnumeration.nextElement()).thenReturn("property1");
        invokeCollectPropertyNames(propertyNames, mockServletContext);
        assertEquals(1, propertyNames.size());
        assertTrue(propertyNames.contains("property1"));
    }

    @Test
    void testCollectPropertyNames_WithHttpSessionAndServletContext() {
        HashSet<String> propertyNames = new HashSet<>();
        Enumeration<String> mockEnumeration = mock(Enumeration.class);
        when(mockServletContext.getAttributeNames()).thenReturn(mockEnumeration);
        when(mockEnumeration.hasMoreElements()).thenReturn(true, false);
        when(mockEnumeration.nextElement()).thenReturn("property2");
        invokeCollectPropertyNames(propertyNames, mockSessionAndContext);
        assertEquals(1, propertyNames.size());
        assertTrue(propertyNames.contains("property2"));
    }

    @Test
    void testCollectPropertyNames_EmptyEnumeration() {
        HashSet<String> propertyNames = new HashSet<>();
        Enumeration<String> mockEnumeration = mock(Enumeration.class);
        when(mockServletContext.getAttributeNames()).thenReturn(mockEnumeration);
        when(mockEnumeration.hasMoreElements()).thenReturn(false);
        invokeCollectPropertyNames(propertyNames, mockServletContext);
        assertTrue(propertyNames.isEmpty());
    }

    private void invokeCollectPropertyNames(HashSet<String> set, Object bean) {
        try {
            Method method = ServletContextHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
            method.setAccessible(true);
            method.invoke(handler, set, bean);
        } catch (Exception e) {
            fail("Method invocation failed: " + e.getMessage());
        }
    }
}
