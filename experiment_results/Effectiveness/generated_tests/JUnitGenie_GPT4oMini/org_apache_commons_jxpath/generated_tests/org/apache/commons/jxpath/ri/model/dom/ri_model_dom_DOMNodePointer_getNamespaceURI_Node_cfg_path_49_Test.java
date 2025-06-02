package org.apache.commons.jxpath.ri.model.dom;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_getNamespaceURI_Node_cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithValidElement() {
        // Setup a mock Node (Element) with a defined namespace URI.
        Element mockElement = createMockElementWithNamespace("http://example.com/namespace");

        // Call the focal method
        String result = DOMNodePointer.getNamespaceURI(mockElement);
        
        // Verify the result
        assertEquals("http://example.com/namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNoNamespace() {
        // Setting up a mock Node (Element) that does not have a namespace defined
        Node mockElementWithoutNamespace = createMockElementWithoutNamespace();

        // Call the focal method
        String result = DOMNodePointer.getNamespaceURI(mockElementWithoutNamespace);
        
        // Verify the result
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        Document mockDocument = createMockDocument();
        // Call the focal method with a Document node
        String result = DOMNodePointer.getNamespaceURI(mockDocument);
        
        // Verify it returns null as the Document has no namespace
        assertNull(result);
    }

    // Helper methods to create mock Element and Document Nodes
    private Element createMockElementWithNamespace(String uri) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElementNS(uri, "mockElement");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Node createMockElementWithoutNamespace() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("mockElement");
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Document createMockDocument() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}