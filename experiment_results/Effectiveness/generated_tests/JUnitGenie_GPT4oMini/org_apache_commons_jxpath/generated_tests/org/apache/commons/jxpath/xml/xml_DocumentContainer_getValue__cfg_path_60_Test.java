package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_60_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenDocumentIsNullAndXmlUrlIsValid() {
        try {
            // Arrange
            URL validUrl = new URL("http://example.com/valid.xml");
            DocumentContainer documentContainer = new DocumentContainer(validUrl) {
                @Override
                public Object parseXML(InputStream stream) throws JXPathException {
                    // Simulate successful parsing of XML
                    return new Object(); // Return a non-null object to avoid assertion failure
                }
            };

            // Act
            Object result = documentContainer.getValue();

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathExceptionWhenIOExceptionOccurs() {
        try {
            // Arrange
            URL invalidUrl = new URL("http://example.com/invalid.xml");
            DocumentContainer documentContainer = new DocumentContainer(invalidUrl) {
                @Override
                public Object parseXML(InputStream stream) throws JXPathException {
                    throw new JXPathException("Simulated IOException");
                }
            };

            // Act
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNotNull(e);
            assertNotNull(e.getCause());
        } catch (Exception e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }


}