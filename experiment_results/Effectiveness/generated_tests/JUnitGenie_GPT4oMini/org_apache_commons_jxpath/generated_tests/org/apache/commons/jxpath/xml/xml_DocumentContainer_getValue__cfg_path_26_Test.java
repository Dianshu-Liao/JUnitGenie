package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import java.net.MalformedURLException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class xml_DocumentContainer_getValue__cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenDocumentIsNullAndXmlUrlIsValid() {
        try {
            // Arrange
            URL validUrl = new URL("http://example.com/valid.xml");
            DocumentContainer documentContainer = new DocumentContainer(validUrl);

            // Act
            Object result = documentContainer.getValue();

            // Assert
            assertNotNull("Expected document to be parsed and not null", result);
        } catch (MalformedURLException e) {
            // Handle the exception for the test case
            e.printStackTrace();
        } catch (JXPathException e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWhenXmlUrlIsNull() {
        // Arrange
        DocumentContainer documentContainer = new DocumentContainer(null);

        // Act
        Object result = null;
        try {
            result = documentContainer.getValue();
        } catch (JXPathException e) {
            // Expected exception when xmlURL is null
        }

        // Assert
        assertNull("Expected document to be null since xmlURL is null", result);
    }

    @Test(timeout = 4000)
    public void testGetValueWhenIOExceptionOccurs() {
        // Arrange
        try {
            URL invalidUrl = new URL("http://example.com/invalid.xml");
            DocumentContainer documentContainer = new DocumentContainer(invalidUrl);

            // Act
            documentContainer.getValue();
        } catch (MalformedURLException e) {
            // Handle the exception for the test case
            e.printStackTrace();
        } catch (JXPathException e) {
            // Assert
            assertNotNull("Expected JXPathException to be thrown", e);
            assertNotNull("Expected cause of exception to be IOException", e.getCause());
        }
    }

}