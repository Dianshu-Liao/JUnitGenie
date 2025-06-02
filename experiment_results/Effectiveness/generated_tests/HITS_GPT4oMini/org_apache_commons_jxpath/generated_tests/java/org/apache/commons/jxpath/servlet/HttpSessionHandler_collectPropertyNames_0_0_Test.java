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
import org.apache.commons.jxpath.JXPathException;

public class HttpSessionHandler_collectPropertyNames_0_0_Test {

    private HttpSessionHandler httpSessionHandler;

    private HttpSessionAndServletContext httpSessionAndServletContext;

    private HttpSession mockSession;

    private ServletContext mockServletContext;

    @BeforeEach
    public void setUp() {
        httpSessionHandler = new HttpSessionHandler();
        mockSession = mock(HttpSession.class);
        mockServletContext = mock(ServletContext.class);
        httpSessionAndServletContext = new HttpSessionAndServletContext(mockSession, mockServletContext);
    }

    @Test
    public void testCollectPropertyNamesWithNullSession() {
        HashSet<String> propertyNames = new HashSet<>();
        when(mockSession.getAttributeNames()).thenReturn(null);
        httpSessionHandler.collectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.isEmpty(), "Property names should be empty when session is null.");
    }

    @Test
    public void testCollectPropertyNamesWithEmptySession() {
        HashSet<String> propertyNames = new HashSet<>();
        Enumeration<String> emptyEnumeration = mock(Enumeration.class);
        when(mockSession.getAttributeNames()).thenReturn(emptyEnumeration);
        when(emptyEnumeration.hasMoreElements()).thenReturn(false);
        httpSessionHandler.collectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.isEmpty(), "Property names should be empty when session has no attributes.");
    }

    @Test
    public void testCollectPropertyNamesWithSessionAttributes() {
        HashSet<String> propertyNames = new HashSet<>();
        Enumeration<String> attributeNames = mock(Enumeration.class);
        when(mockSession.getAttributeNames()).thenReturn(attributeNames);
        when(attributeNames.hasMoreElements()).thenReturn(true, true, false);
        when(attributeNames.nextElement()).thenReturn("attr1", "attr2");
        httpSessionHandler.collectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.contains("attr1"), "Property names should contain 'attr1'.");
        assertTrue(propertyNames.contains("attr2"), "Property names should contain 'attr2'.");
        assertTrue(propertyNames.size() == 2, "Property names size should be 2.");
    }

    @Test
    public void testCollectPropertyNamesWithServletContextAttributes() {
        HashSet<String> propertyNames = new HashSet<>();
        Enumeration<String> contextAttributeNames = mock(Enumeration.class);
        when(mockServletContext.getAttributeNames()).thenReturn(contextAttributeNames);
        when(contextAttributeNames.hasMoreElements()).thenReturn(true, false);
        when(contextAttributeNames.nextElement()).thenReturn("contextAttr");
        httpSessionHandler.collectPropertyNames(propertyNames, httpSessionAndServletContext);
        assertTrue(propertyNames.contains("contextAttr"), "Property names should contain 'contextAttr' from ServletContext.");
    }
}
