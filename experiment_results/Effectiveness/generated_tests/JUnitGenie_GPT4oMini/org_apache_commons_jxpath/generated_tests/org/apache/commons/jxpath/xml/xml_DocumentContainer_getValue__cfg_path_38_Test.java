package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import java.net.URL;
import java.net.MalformedURLException;

public class xml_DocumentContainer_getValue__cfg_path_38_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL xmlURL = null; // This will cause the document to be null and trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);
            // Act
            documentContainer.getValue();
            // If no exception was thrown, fail the test
            fail("Expected JXPathException was not thrown.");
        } catch (JXPathException e) {
            // Assert
            assertNull(e.getMessage());
            return; // Exit the test successfully if exception is caught
        } catch (Exception e) {
            // If any other exception is caught, fail the test
            fail("Expected JXPathException but got: " + e.getClass().getSimpleName());
        }
    }

}