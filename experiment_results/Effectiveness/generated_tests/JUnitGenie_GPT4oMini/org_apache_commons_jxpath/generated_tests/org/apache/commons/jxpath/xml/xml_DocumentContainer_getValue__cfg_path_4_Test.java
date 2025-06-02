package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertNull;

public class xml_DocumentContainer_getValue__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL invalidUrl = null; // Simulating a null URL to trigger the exception
        Throwable thrown = null;

        // Act
        try {
            DocumentContainer documentContainer = new DocumentContainer(invalidUrl);
            documentContainer.getValue(); // This line should not be reached if the exception is thrown
        } catch (JXPathException e) {
            thrown = e; // Capture the exception to assert later
        }

        // Assert
        assertNull("Expected JXPathException was not thrown.", thrown);
        if (thrown == null) {
            throw new AssertionError("Expected JXPathException was not thrown.");
        }
    }

}