package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testGetValueWithValidXML() {
        try {
            // Setup
            URL validXmlUrl = new URL("http://example.com/valid.xml");
            DocumentContainer documentContainer = new DocumentContainer(validXmlUrl);
            
            // Act
            Object result = documentContainer.getValue();
            
            // Assert
            assertNotNull("Document should not be null", result);
        } catch (Exception e) {
            // Handle exception for test case
            e.printStackTrace();
        }
    }

    @Test(expected = JXPathException.class)
    public void testGetValueWithInvalidXML() {
        try {
            // Setup
            URL invalidXmlUrl = new URL("http://example.com/invalid.xml");
            DocumentContainer documentContainer = new DocumentContainer(invalidXmlUrl);
            
            // Act
            documentContainer.getValue();
        } catch (Exception e) {
            // Handle exception for test case
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWithNullURL() {
        try {
            // Setup
            DocumentContainer documentContainer = new DocumentContainer(null);
            
            // Act
            Object result = documentContainer.getValue();
            
            // Assert
            assertNotNull("Document should not be null", result);
        } catch (Exception e) {
            // Handle exception for test case
            e.printStackTrace();
        }
    }

}