package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

public class xml_DocumentContainer_getValue__cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetValue_whenXmlURLIsNotNull_andIOExceptionOccurs() {
        // Arrange
        URL xmlURL = null; // Simulating an invalid URL to cause IOException
        try {
            DocumentContainer documentContainer = new DocumentContainer(xmlURL);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            // Assert
            String expectedMessage = "XML URL is null";
            Throwable cause = ex.getCause();
            assertTrue(ex.getMessage().equals(expectedMessage)); // Using assertTrue for boolean expression
            assertTrue(cause instanceof NullPointerException); // Updated to check for NullPointerException
        }
    }

}