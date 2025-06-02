package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class xml_DocumentContainer_getValue__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL mockUrl = null; // Simulating a null URL to trigger the exception
        JXPathException thrownException = null; // Variable to hold the exception

        // Act
        try {
            DocumentContainer documentContainer = new DocumentContainer(mockUrl);
            documentContainer.getValue();
        } catch (JXPathException ex) {
            thrownException = ex; // Capture the exception
        }

        // Assert
        assertNotNull("Expected JXPathException was not thrown.", thrownException);
        assertEquals("Expected exception message to be related to null URL", "XML URL is null", thrownException.getMessage());
    }


}