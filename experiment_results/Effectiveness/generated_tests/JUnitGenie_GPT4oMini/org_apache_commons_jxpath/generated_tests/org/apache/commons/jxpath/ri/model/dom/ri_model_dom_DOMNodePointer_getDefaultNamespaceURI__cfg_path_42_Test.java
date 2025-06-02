package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;

public class ri_model_dom_DOMNodePointer_getDefaultNamespaceURI__cfg_path_42_Test {

    private Document createMockDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithElementNode() {
        try {
            // Create a mock Document and Element to test
            Document mockDocument = createMockDocument();
            Element mockElement = mockDocument.createElement("testElement");
            mockElement.setAttribute("xmlns", "http://example.com/namespace");
            mockDocument.appendChild(mockElement);

            // Create an instance of DOMNodePointer with the mock Document
            DOMNodePointer nodePointer = new DOMNodePointer(mockElement, null); // Use mockElement instead of mockDocument

            // Call the method under test
            String result = nodePointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertEquals("http://example.com/namespace", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNoNamespace() {
        try {
            // Create a mock Document without a namespace
            Document mockDocument = createMockDocument();
            Element mockElement = mockDocument.createElement("testElement");
            mockDocument.appendChild(mockElement);

            // Create an instance of DOMNodePointer with the mock Document
            DOMNodePointer nodePointer = new DOMNodePointer(mockElement, null); // Use mockElement instead of mockDocument

            // Call the method under test
            String result = nodePointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetDefaultNamespaceURIWithNullNode() {
        try {
            // Create an instance of DOMNodePointer with a null Node
            DOMNodePointer nodePointer = new DOMNodePointer((Node) null, null); // Cast null to Node to resolve ambiguity

            // Call the method under test
            String result = nodePointer.getDefaultNamespaceURI();

            // Assert the expected result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}