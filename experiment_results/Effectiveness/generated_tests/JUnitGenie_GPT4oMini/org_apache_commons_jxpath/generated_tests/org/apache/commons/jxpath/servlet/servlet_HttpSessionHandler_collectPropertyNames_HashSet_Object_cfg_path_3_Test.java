package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.servlet.HttpSessionHandler;
import org.apache.commons.jxpath.servlet.HttpSessionAndServletContext;
import org.junit.Test;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class servlet_HttpSessionHandler_collectPropertyNames_HashSet_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCollectPropertyNames_withNullSession() {
        // Arrange
        HttpSessionAndServletContext mockBean = mock(HttpSessionAndServletContext.class);
        HttpSessionHandler handler = new HttpSessionHandler();

        when(mockBean.getSession()).thenReturn(null);
        ServletContext mockContext = mock(ServletContext.class);
        when(mockBean.getServletContext()).thenReturn(mockContext);

        HashSet<String> set = new HashSet<>();

        // Act
        try {
            Method method = HttpSessionHandler.class.getDeclaredMethod("collectPropertyNames", HashSet.class, Object.class);
            method.setAccessible(true);
            method.invoke(handler, set, mockBean);
        } catch (Exception e) {
            // Handle the exception as specified in the rules
            e.printStackTrace();
        }

        // Assert
        assertEquals(0, set.size());
    }


}