package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.servlet.JXPathServletContexts;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

public class servlet_JXPathServletContexts_getSessionContext_HttpSession_ServletContext_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetSessionContext() {
        // Arrange
        HttpSession session = mock(HttpSession.class);
        ServletContext servletContext = mock(ServletContext.class);
        JXPathContext expectedContext = mock(JXPathContext.class);
        
        // Correctly handle the void method setAttribute
        doNothing().when(session).setAttribute(Constants.JXPATH_CONTEXT, expectedContext);
        when(session.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);
        when(JXPathServletContexts.getApplicationContext(servletContext)).thenReturn(expectedContext);
        
        // Act
        JXPathContext actualContext = null;
        try {
            actualContext = JXPathServletContexts.getSessionContext(session, servletContext);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(actualContext);
    }


}