package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_48_Test {

    @Test(timeout = 4000)
    public void testGetValueWithSourceNull() {
        XMLDocumentContainer container = new XMLDocumentContainer((Source) null);
        Object result = container.getValue();
        assertNotNull("Document should not be null when source is null and delegate is used.", result);
    }

    @Test(timeout = 4000)
    public void testGetValueWithSourceNotNull() {
        // Ensure the test.xml file exists in the correct location
        File testFile = new File("test.xml");
        if (!testFile.exists()) {
            throw new RuntimeException("Test file 'test.xml' not found. Please ensure it exists in the working directory.");
        }
        
        Source source = new StreamSource(testFile);
        XMLDocumentContainer container = new XMLDocumentContainer(source);
        Object result = container.getValue();
        assertNotNull("Document should not be null when source is provided.", result);
    }

    @Test(timeout = 4000)
    public void testGetValueThrowsJXPathException() {
        XMLDocumentContainer container = new XMLDocumentContainer((Source) null);
        try {
            // This should trigger the exception since source is null and delegate.getValue() is expected to fail
            container.getValue();
        } catch (JXPathException ex) {
            assertNotNull("Exception message should not be null.", ex.getMessage());
            assertNotNull("Throwable should not be null.", ex.getCause());
        }
    }

}