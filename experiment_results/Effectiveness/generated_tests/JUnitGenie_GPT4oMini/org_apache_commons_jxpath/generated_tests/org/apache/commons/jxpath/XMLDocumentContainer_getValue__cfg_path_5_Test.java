package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

public class XMLDocumentContainer_getValue__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        // Arrange
        XMLDocumentContainer container = new XMLDocumentContainer((URL) null);
        
        // Act
        try {
            container.getValue();
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Assert
            assertTrue(e.getMessage().contains("XML URL is null"));
        }
    }


}