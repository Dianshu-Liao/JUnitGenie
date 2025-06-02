package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.servlet.HttpSessionHandler;
import org.apache.commons.jxpath.servlet.HttpSessionAndServletContext;
import org.junit.Test;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Enumeration;
import static org.mockito.Mockito.*;

public class servlet_HttpSessionHandler_collectPropertyNames_HashSet_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCollectPropertyNames() {
        // Create a mock HttpSessionAndServletContext
        HttpSessionAndServletContext mockBean = mock(HttpSessionAndServletContext.class);
        HttpSession mockSession = mock(HttpSession.class);
        ServletContext mockContext = mock(ServletContext.class);
        HashSet<Object> set = new HashSet<>();

        // Set up the mock behavior
        when(mockBean.getSession()).thenReturn(mockSession);
        when(mockBean.getServletContext()).thenReturn(mockContext);
        Enumeration<String> mockEnumeration = mock(Enumeration.class);
        when(mockSession.getAttributeNames()).thenReturn(mockEnumeration);
        when(mockEnumeration.hasMoreElements()).thenReturn(false); // Ensure it returns no elements

        // Create an instance of HttpSessionHandler
        HttpSessionHandler handler = new HttpSessionHandler();

        try {
            // Access the protected method using reflection
            Method method = HttpSessionHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
            method.setAccessible(true);
            method.invoke(handler, set, mockBean);

            // Verify that the method was called correctly
            verify(mockBean).getServletContext();
            verify(mockBean).getSession();
            verify(mockSession).getAttributeNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}