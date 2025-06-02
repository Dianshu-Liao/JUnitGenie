package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testGetValueWithSource() {
        try {
            // Setup
            Source source = new DOMSource(); // Assuming a valid DOMSource is created
            XMLDocumentContainer container = new XMLDocumentContainer(source);
            // Execute
            Object result = container.getValue();
            // Verify
            assertNotNull("The document should not be null", result);
        } catch (Exception ex) {
            // Handle exception
            throw new JXPathException("Exception occurred during test execution", ex);
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWithDelegate() {
        try {
            // Setup
            URL url = new URL("http://example.com"); // Provide a valid URL
            DocumentContainer delegate = new DocumentContainer(url); // Create DocumentContainer with a URL
            XMLDocumentContainer container = new XMLDocumentContainer(new DOMSource()); // Create with a valid Source
            // Execute
            Object result = container.getValue();
            // Verify
            assertNotNull("The document should not be null", result);
        } catch (Exception ex) {
            // Handle exception
            throw new JXPathException("Exception occurred during test execution", ex);
        }
    }

    @Test(expected = JXPathException.class)
    public void testGetValueThrowsException() {
        try {
            // Setup
            XMLDocumentContainer container = new XMLDocumentContainer(new DOMSource()); // Create with a valid Source
            // Execute
            container.getValue();
        } catch (JXPathException ex) {
            // Verify that the exception is thrown
            throw ex; // Rethrow to satisfy the expected exception
        } catch (Exception ex) {
            // Handle other exceptions
            throw new JXPathException("Unexpected exception occurred", ex);
        }
    }


}