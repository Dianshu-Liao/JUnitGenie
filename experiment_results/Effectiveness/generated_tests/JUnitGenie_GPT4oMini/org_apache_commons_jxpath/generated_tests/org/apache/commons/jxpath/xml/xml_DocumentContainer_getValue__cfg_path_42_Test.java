package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertNull;

public class xml_DocumentContainer_getValue__cfg_path_42_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL mockUrl = null; // Simulating a null URL to trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(mockUrl);
            // Act
            documentContainer.getValue();
            // If we reach this point, the exception was not thrown as expected
            throw new AssertionError("Expected JXPathException was not thrown.");
        } catch (JXPathException e) {
            // Assert
            assertNull(e.getMessage());
            return; // Exit the test successfully if exception is caught
        }
    }

}