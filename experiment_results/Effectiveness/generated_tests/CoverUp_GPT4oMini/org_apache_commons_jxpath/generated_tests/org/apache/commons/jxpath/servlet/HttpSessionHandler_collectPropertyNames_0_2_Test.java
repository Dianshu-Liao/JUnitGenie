package org.apache.commons.jxpath.servlet;

import org.apache.commons.jxpath.JXPathException;
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

class HttpSessionHandler_collectPropertyNames_0_2_Test {

    private HttpSessionHandler httpSessionHandler;

    private HttpSessionAndServletContext httpSessionAndServletContext;

    private HttpSession httpSession;

    private ServletContext servletContext;

    @BeforeEach
    void setUp() {
        httpSessionHandler = new HttpSessionHandler();
        servletContext = mock(ServletContext.class);
        httpSession = mock(HttpSession.class);
        httpSessionAndServletContext = new HttpSessionAndServletContext(httpSession, servletContext);
    }

    @Test
    void testCollectPropertyNamesWithSessionAttributes() throws Exception {
        HashSet<String> propertyNames = new HashSet<>();
        when(httpSession.getAttributeNames()).thenReturn(mockEnumeration("attr1", "attr2"));
        invokeCollectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.contains("attr1"));
        assertTrue(propertyNames.contains("attr2"));
    }

    @Test
    void testCollectPropertyNamesWithNoSession() throws Exception {
        HashSet<String> propertyNames = new HashSet<>();
        when(httpSession.getAttributeNames()).thenReturn(mockEnumeration());
        when(httpSessionAndServletContext.getSession()).thenReturn(null);
        invokeCollectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.isEmpty());
    }

    @Test
    void testCollectPropertyNamesWithEmptySession() throws Exception {
        HashSet<String> propertyNames = new HashSet<>();
        when(httpSession.getAttributeNames()).thenReturn(mockEnumeration());
        invokeCollectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.isEmpty());
    }

    private void invokeCollectPropertyNames(HashSet<String> set, Object bean) throws Exception {
        Method method = HttpSessionHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
        method.setAccessible(true);
        method.invoke(httpSessionHandler, set, bean);
    }

    private Enumeration<String> mockEnumeration(String... values) {
        return new Enumeration<String>() {

            private int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < values.length;
            }

            @Override
            public String nextElement() {
                return values[index++];
            }
        };
    }
}
