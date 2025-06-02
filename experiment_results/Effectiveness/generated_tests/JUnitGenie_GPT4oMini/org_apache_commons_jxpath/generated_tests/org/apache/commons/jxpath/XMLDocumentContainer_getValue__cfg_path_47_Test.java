package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.net.URL;

public class XMLDocumentContainer_getValue__cfg_path_47_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        XMLDocumentContainer container = new XMLDocumentContainer((URL) null);
        
        // Act
        try {
            container.getValue();
        } catch (JXPathException ex) {
            // Assert
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals("XML URL is null", ex.getMessage());
            return; // Exit the test successfully if exception is caught
        }
        // If we reach here, the exception was not thrown as expected
        fail("Expected JXPathException was not thrown.");
    }

}