package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testGetValueWithSource() {
        try {
            // Setup
            Source source = new StreamSource("src/test/resources/valid/xml/file.xml"); // Updated path to a valid XML file
            XMLDocumentContainer container = new XMLDocumentContainer(source);
            
            // Execute
            Object result = container.getValue();
            
            // Verify
            assertNotNull("Expected a non-null document", result);
        } catch (Exception ex) {
            // Handle exception
            throw new JXPathException("Test failed due to unexpected exception", ex);
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWithNullSourceAndDelegate() {
        try {
            // Setup
            XMLDocumentContainer container = new XMLDocumentContainer((Source) null);
            // Use reflection to set the private delegate field
            java.lang.reflect.Field delegateField = XMLDocumentContainer.class.getDeclaredField("delegate");
            delegateField.setAccessible(true);
            delegateField.set(container, null); // No delegate
            
            // Execute
            Object result = container.getValue();
            
            // Verify
            assertNotNull("Expected a non-null document even with null source and delegate", result);
        } catch (Exception ex) {
            // Handle exception
            throw new JXPathException("Test failed due to unexpected exception", ex);
        }
    }

}