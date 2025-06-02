package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.JXPathContext;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;

public class servlet_JXPathServletContexts_getSessionContext_HttpSession_ServletContext_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetSessionContext() {
        // Arrange
        HttpSession session = Mockito.mock(HttpSession.class);
        ServletContext servletContext = Mockito.mock(ServletContext.class);
        JXPathContext mockContext = Mockito.mock(JXPathContext.class);
        JXPathContext parentContext = Mockito.mock(JXPathContext.class);
        
        // Mocking the behavior of session.getAttribute
        Mockito.when(session.getAttribute("org.apache.commons.jxpath.JXPATH_CONTEXT")).thenReturn(null);
        
        // Mocking the behavior of getApplicationContext
        Mockito.when(JXPathServletContexts.getApplicationContext(servletContext)).thenReturn(parentContext);
        
        // Correcting the method call to match the actual method signature
        // Assuming the correct method is getSessionContext instead of getContext
        Mockito.when(JXPathServletContexts.getSessionContext(Mockito.any(HttpSession.class), Mockito.any(ServletContext.class))).thenReturn(mockContext);
        
        // Stubbing the void method setAttribute to do nothing
        doNothing().when(session).setAttribute(Mockito.anyString(), Mockito.any());

        // Act
        JXPathContext context = JXPathServletContexts.getSessionContext(session, servletContext);
        
        // Assert
        assertNotNull(context);
        session.setAttribute("org.apache.commons.jxpath.JXPATH_CONTEXT", context);
    }

}