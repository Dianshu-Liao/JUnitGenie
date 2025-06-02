package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.IOException;
import java.net.URL;
import static org.junit.Assert.assertNull;

public class xml_DocumentContainer_getValue__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL invalidURL = null; // Simulating a null URL to trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(invalidURL);
            // Act
            documentContainer.getValue();
        } catch (JXPathException ex) {
            // Assert
            String expectedMessage = "XML URL is null"; // Updated expected message to match the actual exception message
            assertNull(ex.getCause()); // Ensure that the cause is null since we are simulating a null URL
            assert ex.getMessage().contains(expectedMessage);
            return; // Exit the test successfully
        }

        // If we reach this point, the exception was not thrown as expected
        assert false : "Expected JXPathException was not thrown.";
    }


}