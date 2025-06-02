package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementHavingPrefix() {
        try {
            // Create a mock Document and Element
            Document document = createMockDocumentWithElement("prefix", "namespaceURI");
            Node node = document.getDocumentElement();

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertEquals("namespaceURI", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementWithoutPrefix() {
        try {
            // Create a mock Document and Element without prefix
            Document document = createMockDocumentWithoutElementPrefix();
            Node node = document.getDocumentElement();

            // Call the focal method
            String result = DOMNodePointer.getNamespaceURI(node);

            // Assert the expected result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    private Document createMockDocumentWithElement(String prefix, String namespaceURI) {
        // Implementation to create a mock Document with an Element having a prefix and namespaceURI
        // This is a placeholder for actual implementation
        return null; // Replace with actual Document creation logic
    }

    private Document createMockDocumentWithoutElementPrefix() {
        // Implementation to create a mock Document with an Element without a prefix
        // This is a placeholder for actual implementation
        return null; // Replace with actual Document creation logic
    }

}