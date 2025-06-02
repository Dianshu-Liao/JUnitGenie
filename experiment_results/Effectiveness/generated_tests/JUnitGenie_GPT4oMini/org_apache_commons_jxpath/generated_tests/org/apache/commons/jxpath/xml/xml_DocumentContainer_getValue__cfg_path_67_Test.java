package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class xml_DocumentContainer_getValue__cfg_path_67_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        URL mockUrl = null; // Simulating a null URL to trigger the exception
        try {
            DocumentContainer documentContainer = new DocumentContainer(mockUrl);
            // Act
            documentContainer.getValue();
            // If we reach here, the exception was not thrown as expected
            fail("Expected JXPathException was not thrown");
        } catch (JXPathException ex) {
            // Assert
            assertNull(ex.getMessage());
        }
    }

}