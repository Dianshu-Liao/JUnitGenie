package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL mockUrl = null; // Simulating a null URL to trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(mockUrl);
            // Act
            documentContainer.getValue();
        } catch (JXPathException ex) {
            // Assert
            assertNotNull("Expected JXPathException to be thrown", ex);
            return; // Exit the test successfully if exception is caught
        }
        
        // If no exception was thrown, fail the test
        assertNotNull("Expected JXPathException to be thrown, but none was", null);
    }

}