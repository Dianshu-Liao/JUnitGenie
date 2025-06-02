package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() {
        // Create a mock Document and Element to test
        Document mockDocument = createMockDocumentWithNamespace("http://example.com");
        DOMNodePointer pointer = new DOMNodePointer(mockDocument, null);

        String result = pointer.getDefaultNamespaceURI();
        assertEquals("http://example.com", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() {
        // Create a mock Document without a namespace
        Document mockDocument = createMockDocumentWithoutNamespace();
        DOMNodePointer pointer = new DOMNodePointer(mockDocument, null);

        String result = pointer.getDefaultNamespaceURI();
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullNode() {
        // Create a DOMNodePointer with a null node
        DOMNodePointer pointer = new DOMNodePointer((Node) null, Locale.getDefault());

        String result = pointer.getDefaultNamespaceURI();
        assertNull(result);
    }

    private Document createMockDocumentWithNamespace(String namespace) {
        // Implementation to create a mock Document with a namespace
        // This is a placeholder for actual mock creation logic
        return null; // Replace with actual Document creation
    }

    private Document createMockDocumentWithoutNamespace() {
        // Implementation to create a mock Document without a namespace
        // This is a placeholder for actual mock creation logic
        return null; // Replace with actual Document creation
    }


}