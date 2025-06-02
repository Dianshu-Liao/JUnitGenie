package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Vector;
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

    private HttpSessionAndServletContext mockHttpSessionAndServletContext;

    @BeforeEach
    void setUp() {
        handler = new ServletContextHandler();
        mockServletContext = mock(ServletContext.class);
        mockHttpSessionAndServletContext = mock(HttpSessionAndServletContext.class);
    }

    @Test
    void testCollectPropertyNamesWithServletContext() {
        HashSet<String> propertyNames = new HashSet<>();
        Vector<String> attributes = new Vector<>();
        attributes.add("attr1");
        attributes.add("attr2");
        when(mockServletContext.getAttributeNames()).thenReturn(attributes.elements());
        handler.collectPropertyNames(propertyNames, mockServletContext);
        assertEquals(2, propertyNames.size());
        assertTrue(propertyNames.contains("attr1"));
        assertTrue(propertyNames.contains("attr2"));
    }

    @Test
    void testCollectPropertyNamesWithHttpSessionAndServletContext() {
        HashSet<String> propertyNames = new HashSet<>();
        Vector<String> attributes = new Vector<>();
        attributes.add("attr3");
        attributes.add("attr4");
        when(mockHttpSessionAndServletContext.getServletContext()).thenReturn(mockServletContext);
        when(mockServletContext.getAttributeNames()).thenReturn(attributes.elements());
        handler.collectPropertyNames(propertyNames, mockHttpSessionAndServletContext);
        assertEquals(2, propertyNames.size());
        assertTrue(propertyNames.contains("attr3"));
        assertTrue(propertyNames.contains("attr4"));
    }

    // Test for null bean
    @Test
    void testCollectPropertyNamesWithNullBean() {
        HashSet<String> propertyNames = new HashSet<>();
        assertThrows(ClassCastException.class, () -> {
            handler.collectPropertyNames(propertyNames, null);
        });
    }

    // Test for empty attributes
    @Test
    void testCollectPropertyNamesWithEmptyAttributes() {
        HashSet<String> propertyNames = new HashSet<>();
        when(mockServletContext.getAttributeNames()).thenReturn(new Vector<String>().elements());
        handler.collectPropertyNames(propertyNames, mockServletContext);
        assertTrue(propertyNames.isEmpty());
    }
}
