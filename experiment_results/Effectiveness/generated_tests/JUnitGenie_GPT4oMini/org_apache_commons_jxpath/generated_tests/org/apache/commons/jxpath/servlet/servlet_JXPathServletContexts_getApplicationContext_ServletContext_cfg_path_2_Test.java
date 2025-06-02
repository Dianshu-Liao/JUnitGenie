package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.servlet.JXPathServletContexts;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletContext;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class servlet_JXPathServletContexts_getApplicationContext_ServletContext_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetApplicationContext_whenContextIsNull_createsNewContext() {
        // Arrange
        ServletContext servletContext = Mockito.mock(ServletContext.class);
        Mockito.when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(null);

        // Act
        JXPathContext context = JXPathServletContexts.getApplicationContext(servletContext);

        // Assert
        assertNotNull(context);
        Mockito.verify(servletContext).setAttribute(Constants.JXPATH_CONTEXT, context);
    }

    @Test(timeout = 4000)
    public void testGetApplicationContext_whenContextIsNotNull_returnsExistingContext() {
        // Arrange
        JXPathContext existingContext = Mockito.mock(JXPathContext.class);
        ServletContext servletContext = Mockito.mock(ServletContext.class);
        Mockito.when(servletContext.getAttribute(Constants.JXPATH_CONTEXT)).thenReturn(existingContext);

        // Act
        JXPathContext context = JXPathServletContexts.getApplicationContext(servletContext);

        // Assert
        assertNotNull(context);
        // Ensure it returns existing context
        assertSame(existingContext, context);
    }


}