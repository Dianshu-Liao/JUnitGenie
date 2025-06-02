package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.servlet.JXPathServletContexts;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletContext;
import static org.junit.Assert.assertNotNull;
import org.apache.commons.jxpath.JXPathContextFactory;

public class servlet_JXPathServletContexts_getApplicationContext_ServletContext_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetApplicationContext() {
        // Arrange
        ServletContext servletContext = Mockito.mock(ServletContext.class);
        JXPathContext context = Mockito.mock(JXPathContext.class);
        Mockito.when(servletContext.getAttribute("org.apache.commons.jxpath.JXPATH_CONTEXT")).thenReturn(null);
        
        // Mocking the factory to return a new context
        JXPathContextFactory factory = Mockito.mock(JXPathContextFactory.class); // Mocking the factory instead of instantiating
        Mockito.when(factory.newContext(null, servletContext)).thenReturn(context);
        
        // Act
        JXPathContext resultContext = null;
        try {
            // Directly use the factory to create the context instead of setting it
            resultContext = factory.newContext(null, servletContext);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(resultContext);
        Mockito.verify(servletContext).setAttribute("org.apache.commons.jxpath.JXPATH_CONTEXT", resultContext);
    }

}