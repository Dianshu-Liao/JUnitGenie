package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class xml_DocumentContainer_getValue__cfg_path_36_Test {

    @Test(timeout = 4000)
    public void testGetValue_ThrowsJXPathException() throws Exception {
        // Setup
        URL mockURL = new URL("http://example.com/xml");
        DocumentContainer documentContainer = new DocumentContainer(mockURL) {
            @Override
            public Object parseXML(InputStream stream) {
                // Simulate IOException when trying to parse the XML
                throw new JXPathException("Simulated IOException");
            }
        };

        // Execute and verify
        try {
            documentContainer.getValue();
            fail("Expected a JXPathException to be thrown");
        } catch (JXPathException ex) {
            // Validate the exception message and cause
            String expectedMessage = "Cannot read XML from: " + mockURL.toString();
            assertEquals(expectedMessage, ex.getMessage());
            assertNotNull(ex.getCause());
        } catch (Exception e) {
            fail("Expected JXPathException but got a different exception: " + e);
        }
    }


}