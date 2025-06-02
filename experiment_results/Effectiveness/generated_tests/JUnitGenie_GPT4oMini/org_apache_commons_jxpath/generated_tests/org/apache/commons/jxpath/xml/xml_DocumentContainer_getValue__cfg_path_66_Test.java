package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertNull;

public class xml_DocumentContainer_getValue__cfg_path_66_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL mockUrl = null; // Simulating a null URL to trigger the exception
        DocumentContainer documentContainer = null;

        // Act
        try {
            documentContainer = new DocumentContainer(mockUrl);
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNull(e.getMessage());
            return; // Exit the test successfully if exception is caught
        } catch (NullPointerException e) {
            // Handle the case where documentContainer is null
            throw new AssertionError("Expected JXPathException was not thrown.");
        }
        // If no exception is thrown, fail the test
        throw new AssertionError("Expected JXPathException was not thrown.");
    }


}