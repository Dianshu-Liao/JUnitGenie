package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import java.net.URL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class XMLDocumentContainer_getValue__cfg_path_10_Test {

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
            // You can add more assertions here to check the message or cause of the exception
            assertNotNull(ex.getMessage());
            assertEquals("XML URL is null", ex.getMessage());
        }
    }

}