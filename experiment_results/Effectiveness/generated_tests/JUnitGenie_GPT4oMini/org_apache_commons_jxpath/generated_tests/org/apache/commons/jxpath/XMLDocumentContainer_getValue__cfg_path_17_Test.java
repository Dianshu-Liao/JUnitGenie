package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import java.io.StringReader;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenSourceIsNullAndDelegateReturnsValidDocument() {
        try {
            // Setup
            DocumentContainer mockDelegate = new DocumentContainer(new URL("http://example.com"), ""); // Provide valid URL and String
            XMLDocumentContainer container = new XMLDocumentContainer((Source) null);
            // Using reflection to set private fields since we don't have setter methods.
            java.lang.reflect.Field delegateField = XMLDocumentContainer.class.getDeclaredField("delegate");
            delegateField.setAccessible(true);
            delegateField.set(container, mockDelegate);

            // Execution
            Object result = container.getValue();

            // Verification
            assertNotNull("The returned document should not be null", result);
        } catch (Exception ex) {
            throw new JXPathException("Test failed to execute", ex);
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWhenSourceIsNotNull() {
        try {
            // Setup
            Source source = new StreamSource(new StringReader("<root />")); // Providing valid XML source
            XMLDocumentContainer container = new XMLDocumentContainer(source);
            // Using reflection to set private field document to null to trigger the condition
            java.lang.reflect.Field documentField = XMLDocumentContainer.class.getDeclaredField("document");
            documentField.setAccessible(true);
            documentField.set(container, null);

            // Execution
            Object result = container.getValue();

            // Verification
            assertNotNull("The returned document should not be null after transformation", result);
        } catch (Exception ex) {
            throw new JXPathException("Test failed due to exception", ex);
        }
    }

}