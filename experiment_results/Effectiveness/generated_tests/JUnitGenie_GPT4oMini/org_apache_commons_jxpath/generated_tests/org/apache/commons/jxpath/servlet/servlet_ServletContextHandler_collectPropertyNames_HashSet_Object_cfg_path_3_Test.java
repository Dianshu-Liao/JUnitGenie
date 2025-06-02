package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.servlet.HttpSessionAndServletContext;
import org.apache.commons.jxpath.servlet.ServletContextHandler;
import org.junit.Test;
import javax.servlet.ServletContext;
import java.util.HashSet;
import java.util.Enumeration;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class servlet_ServletContextHandler_collectPropertyNames_HashSet_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCollectPropertyNames() {
        // Arrange
        ServletContextHandler handler = new ServletContextHandler();
        HashSet<Object> set = new HashSet<>();
        
        // Create a mock HttpSessionAndServletContext
        HttpSessionAndServletContext mockBean = mock(HttpSessionAndServletContext.class);
        ServletContext mockContext = mock(ServletContext.class);
        
        // Set up the mock to return the mock ServletContext
        when(mockBean.getServletContext()).thenReturn(mockContext);
        
        // Set up the mock ServletContext to return some attribute names
        Enumeration<String> mockEnumeration = mock(Enumeration.class);
        when(mockEnumeration.hasMoreElements()).thenReturn(true, true, false); // Two elements
        when(mockEnumeration.nextElement()).thenReturn("attribute1", "attribute2");
        when(mockContext.getAttributeNames()).thenReturn(mockEnumeration);
        
        // Act
        try {
            // Use reflection to access the protected method
            java.lang.reflect.Method method = ServletContextHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
            method.setAccessible(true);
            method.invoke(handler, set, mockBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertTrue(set.contains("attribute1"));
        assertTrue(set.contains("attribute2"));
    }

}