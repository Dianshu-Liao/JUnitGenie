package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.net.URL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class XMLDocumentContainer_getValue__cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        XMLDocumentContainer container = new XMLDocumentContainer((URL) null); // xmlURL is null

        try {
            // Act
            container.getValue();
        } catch (JXPathException ex) {
            // Assert
            assertNotNull(ex);
            // Additional assertions can be made on the exception message if needed
            assertNotNull(ex.getMessage());
            assertEquals("XML URL is null", ex.getMessage());
        }
    }


}