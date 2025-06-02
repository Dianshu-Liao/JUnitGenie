package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertTrue;

public class xml_DocumentContainer_getValue__cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL xmlURL = null; // This will cause the document to be null and trigger the exception
        JXPathException thrownException = null;

        // Act
        try {
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);
            documentContainer.getValue();
        } catch (JXPathException ex) {
            thrownException = ex; // Capture the exception
        }
        
        // Assert
        assertTrue("Expected JXPathException to be thrown", thrownException != null);
        assertTrue("Expected JXPathException message to be 'XML URL is null'", 
                   "XML URL is null".equals(thrownException.getMessage()));
    }

}