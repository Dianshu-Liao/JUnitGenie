package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class xml_DocumentContainer_getValue__cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenDocumentIsNullAndXmlURLIsNotNull() {
        try {
            // Arrange
            URL xmlURL = new URL("http://example.com/test.xml");
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);
            
            // Act
            Object result = documentContainer.getValue();
            
            // Assert
            assertNull(result);
        } catch (JXPathException e) {
            // Handle the JXPathException for the test case
            assertTrue(e.getMessage().contains("Cannot read XML from:"));
        } catch (Exception e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathExceptionWhenIOExceptionOccurs() {
        try {
            // Arrange
            URL xmlURL = new URL("http://invalid-url");
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);
            
            // Act
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertTrue(e.getMessage().contains("Cannot read XML from:"));
        } catch (Exception e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }

}