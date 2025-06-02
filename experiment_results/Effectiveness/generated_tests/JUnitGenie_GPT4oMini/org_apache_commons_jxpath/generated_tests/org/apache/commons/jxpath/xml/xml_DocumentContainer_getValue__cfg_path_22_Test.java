package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class xml_DocumentContainer_getValue__cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenDocumentIsNull() {
        try {
            // Arrange
            URL xmlURL = new URL("http://example.com/test.xml");
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);

            // Act
            Object result = documentContainer.getValue();

            // Assert
            assertNotNull("Document should not be null after calling getValue()", result);
        } catch (JXPathException e) {
            fail("JXPathException should not be thrown: " + e.getMessage());
        } catch (Exception e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        try {
            // Arrange
            URL xmlURL = new URL("http://invalid-url.com/test.xml");
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);

            // Act
            documentContainer.getValue();
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Assert
            assertNotNull("Expected JXPathException to be thrown", e);
            assertNotNull("Exception message should not be null", e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

}