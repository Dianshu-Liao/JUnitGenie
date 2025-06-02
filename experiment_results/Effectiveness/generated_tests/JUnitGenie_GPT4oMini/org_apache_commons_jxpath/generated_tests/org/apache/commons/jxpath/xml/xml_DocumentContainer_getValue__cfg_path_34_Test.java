package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_34_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL invalidUrl = null; // Simulating a null URL to trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(invalidUrl);
            // Act
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNotNull(e.getMessage()); // Check that the exception message is not null
            return; // Exit the test successfully if exception is caught
        }

        // If we reach here, the test has failed
        throw new AssertionError("Expected JXPathException was not thrown.");
    }

}