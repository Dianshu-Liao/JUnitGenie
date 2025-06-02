package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_50_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL xmlURL = null; // This will cause the document to be null and trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);
            // Act
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNotNull(e);
            assertNotNull(e.getMessage());
            return; // Exit the test successfully if exception is caught
        }
        // If we reach this point, the exception was not thrown
        throw new AssertionError("Expected JXPathException was not thrown.");
    }



}
