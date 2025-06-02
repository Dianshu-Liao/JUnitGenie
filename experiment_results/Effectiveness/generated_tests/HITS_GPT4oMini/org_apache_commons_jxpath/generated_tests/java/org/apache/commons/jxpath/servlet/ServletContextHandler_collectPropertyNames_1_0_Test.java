package org.apache.commons.jxpath.servlet;

import java.util.HashSet;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.DynamicPropertyHandler;

public class ServletContextHandler_collectPropertyNames_1_0_Test {

    private ServletContextHandler servletContextHandler;

    private HttpSession mockSession;

    private ServletContext mockContext;

    @BeforeEach
    public void setUp() {
        servletContextHandler = new ServletContextHandler();
        mockSession = mock(HttpSession.class);
        mockContext = mock(ServletContext.class);
    }

    @Test
    public void testCollectPropertyNames_WithServletContext() {
        HashSet<String> propertyNames = new HashSet<>();
        when(mockContext.getAttributeNames()).thenReturn(mock(Enumeration.class));
        servletContextHandler.collectPropertyNames(propertyNames, mockContext);
        assertTrue(propertyNames.isEmpty(), "Property names should be empty since no attributes were added.");
    }

    @Test
    public void testCollectPropertyNames_WithHttpSessionAndServletContext() {
        HashSet<String> propertyNames = new HashSet<>();
        String attributeName = "testAttribute";
        Enumeration<String> mockEnumeration = mock(Enumeration.class);
        when(mockEnumeration.hasMoreElements()).thenReturn(true, false);
        when(mockEnumeration.nextElement()).thenReturn(attributeName);
        when(mockContext.getAttributeNames()).thenReturn(mockEnumeration);
        HttpSessionAndServletContext sessionAndContext = new HttpSessionAndServletContext(mockSession, mockContext);
        servletContextHandler.collectPropertyNames(propertyNames, sessionAndContext);
        assertTrue(propertyNames.contains(attributeName), "Property names should contain the added attribute.");
    }

    @Test
    public void testCollectPropertyNames_EmptyContext() {
        HashSet<String> propertyNames = new HashSet<>();
        when(mockContext.getAttributeNames()).thenReturn(mock(Enumeration.class));
        servletContextHandler.collectPropertyNames(propertyNames, mockContext);
        assertTrue(propertyNames.isEmpty(), "Property names should be empty since no attributes were added.");
    }

    @Test
    public void testCollectPropertyNames_NullBean() {
        HashSet<String> propertyNames = new HashSet<>();
        servletContextHandler.collectPropertyNames(propertyNames, null);
        assertTrue(propertyNames.isEmpty(), "Property names should be empty when the bean is null.");
    }
}
