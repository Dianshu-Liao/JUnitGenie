package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNull;

public class xml_DocumentContainer_getValue__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL mockUrl = null; // Simulating a null URL to trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(mockUrl);
            // Act
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNull(e.getMessage());
            return; // Exit the test successfully if exception is caught
        }

        // If no exception was thrown, fail the test
        throw new AssertionError("Expected JXPathException was not thrown");
    }

}