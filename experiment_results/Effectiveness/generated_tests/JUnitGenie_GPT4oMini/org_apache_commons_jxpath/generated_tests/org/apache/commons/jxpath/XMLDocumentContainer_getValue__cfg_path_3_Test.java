package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsExceptionWhenSourceIsNullAndDelegateThrowsException() {
        // Arrange
        try {
            XMLDocumentContainer container = new XMLDocumentContainer((URL) null);
            // Act
            container.getValue();
        } catch (JXPathException ex) {
            // Assert
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            return; // Exit the test successfully if exception is caught
        }
        // If we reach here, the exception was not thrown as expected
        throw new AssertionError("Expected JXPathException was not thrown.");
    }

    @Test(timeout = 4000)
    public void testGetValueThrowsExceptionWhenSourceIsInvalid() {
        // Arrange
        try {
            Source invalidSource = new StreamSource("invalid-source");
            XMLDocumentContainer container = new XMLDocumentContainer(invalidSource); // Use constructor to set invalid source
            // Act
            container.getValue();
        } catch (JXPathException ex) {
            // Assert
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            return; // Exit the test successfully if exception is caught
        }
        // If we reach here, the exception was not thrown as expected
        throw new AssertionError("Expected JXPathException was not thrown.");
    }

}