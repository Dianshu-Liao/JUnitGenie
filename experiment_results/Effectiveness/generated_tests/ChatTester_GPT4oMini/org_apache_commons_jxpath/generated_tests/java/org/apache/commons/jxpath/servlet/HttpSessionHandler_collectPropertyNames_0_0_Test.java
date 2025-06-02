package org.apache.commons.jxpath.servlet;

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
import org.apache.commons.jxpath.JXPathException;

class HttpSessionHandler_collectPropertyNames_0_0_Test {

    private HttpSessionHandler httpSessionHandler;

    private HttpSessionAndServletContext mockBean;

    private HttpSession mockSession;

    @BeforeEach
    void setUp() {
        httpSessionHandler = new HttpSessionHandler();
        mockBean = mock(HttpSessionAndServletContext.class);
        mockSession = mock(HttpSession.class);
    }

    @Test
    void testCollectPropertyNamesWithNonNullSession() throws Exception {
        HashSet<String> propertyNames = new HashSet<>();
        ServletContext mockContext = mock(ServletContext.class);
        when(mockBean.getServletContext()).thenReturn(mockContext);
        when(mockBean.getSession()).thenReturn(mockSession);
        Enumeration<String> mockAttributes = mock(Enumeration.class);
        when(mockSession.getAttributeNames()).thenReturn(mockAttributes);
        when(mockAttributes.hasMoreElements()).thenReturn(true, true, false);
        when(mockAttributes.nextElement()).thenReturn("attr1", "attr2");
        // Use reflection to invoke the protected method
        Method method = HttpSessionHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
        method.setAccessible(true);
        method.invoke(httpSessionHandler, propertyNames, mockBean);
        assertEquals(2, propertyNames.size());
        assertTrue(propertyNames.contains("attr1"));
        assertTrue(propertyNames.contains("attr2"));
    }

    @Test
    void testCollectPropertyNamesWithNullSession() throws Exception {
        HashSet<String> propertyNames = new HashSet<>();
        ServletContext mockContext = mock(ServletContext.class);
        when(mockBean.getServletContext()).thenReturn(mockContext);
        when(mockBean.getSession()).thenReturn(null);
        // Use reflection to invoke the protected method
        Method method = HttpSessionHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
        method.setAccessible(true);
        method.invoke(httpSessionHandler, propertyNames, mockBean);
        assertTrue(propertyNames.isEmpty());
    }

    @Test
    void testCollectPropertyNamesWithEmptySessionAttributes() throws Exception {
        HashSet<String> propertyNames = new HashSet<>();
        ServletContext mockContext = mock(ServletContext.class);
        when(mockBean.getServletContext()).thenReturn(mockContext);
        when(mockBean.getSession()).thenReturn(mockSession);
        Enumeration<String> mockAttributes = mock(Enumeration.class);
        when(mockSession.getAttributeNames()).thenReturn(mockAttributes);
        when(mockAttributes.hasMoreElements()).thenReturn(false);
        // Use reflection to invoke the protected method
        Method method = HttpSessionHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
        method.setAccessible(true);
        method.invoke(httpSessionHandler, propertyNames, mockBean);
        assertTrue(propertyNames.isEmpty());
    }
}
