package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_18_Test {

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
        
        // If no exception was thrown, fail the test
        throw new AssertionError("Expected JXPathException was not thrown.");
    }

    @Test(timeout = 4000)
    public void testGetValueWithValidInputStream() {
        // Arrange
        URL xmlURL = getClass().getResource("/valid.xml"); // Assuming valid.xml is a valid XML file in resources
        assertNotNull("Resource /valid.xml not found", xmlURL); // Ensure the resource is found
        DocumentContainer documentContainer = new DocumentContainer(xmlURL);

        // Act
        Object result = documentContainer.getValue();

        // Assert
        assertNotNull(result); // Ensure that the document is not null
    }

    @Test(timeout = 4000)
    public void testGetValueWithInvalidInputStream() {
        // Arrange
        URL xmlURL = getClass().getResource("/invalid.xml"); // Assuming invalid.xml is an invalid XML file in resources
        assertNotNull("Resource /invalid.xml not found", xmlURL); // Ensure the resource is found
        DocumentContainer documentContainer = new DocumentContainer(xmlURL);

        // Act
        try {
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNotNull(e);
            assertNotNull(e.getMessage());
            return; // Exit the test successfully if exception is caught
        }
        
        // If no exception was thrown, fail the test
        throw new AssertionError("Expected JXPathException was not thrown.");
    }

}