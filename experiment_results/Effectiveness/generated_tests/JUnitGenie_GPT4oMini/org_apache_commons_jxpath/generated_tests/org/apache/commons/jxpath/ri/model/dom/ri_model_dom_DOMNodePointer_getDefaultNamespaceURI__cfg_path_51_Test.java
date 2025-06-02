package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_51_Test {

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenNodeIsDocumentWithNamespace() {
        // Create a Document node with a namespace
        Document document = createMockDocumentWithNamespace("http://example.com");
        DOMNodePointer pointer = new DOMNodePointer(document, null); // Assuming the second parameter is Locale, set to null for simplicity
        
        String result = pointer.getDefaultNamespaceURI();
        assertEquals("http://example.com", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenNodeIsElementWithNamespace() {
        // Create an Element node with a namespace
        Element element = createMockElementWithNamespace("http://example.com");
        DOMNodePointer pointer = new DOMNodePointer(element, null);
        
        String result = pointer.getDefaultNamespaceURI();
        assertEquals("http://example.com", result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenNoNamespace() {
        // Create an Element node without a namespace
        Element element = createMockElementWithoutNamespace();
        DOMNodePointer pointer = new DOMNodePointer(element, null);
        
        String result = pointer.getDefaultNamespaceURI();
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWhenNodeIsNull() {
        try {
            DOMNodePointer pointer = new DOMNodePointer((Node) null, null); // Specify Node type to resolve ambiguity
            String result = pointer.getDefaultNamespaceURI();
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    // Mock methods to replace MockDocumentBuilder and MockElementBuilder
    private Document createMockDocumentWithNamespace(String namespace) {
        // Implementation to create a mock Document with the specified namespace
        // This is a placeholder; actual implementation needed
        return null; // Replace with actual Document creation logic
    }

    private Element createMockElementWithNamespace(String namespace) {
        // Implementation to create a mock Element with the specified namespace
        // This is a placeholder; actual implementation needed
        return null; // Replace with actual Element creation logic
    }

    private Element createMockElementWithoutNamespace() {
        // Implementation to create a mock Element without a namespace
        // This is a placeholder; actual implementation needed
        return null; // Replace with actual Element creation logic
    }

}